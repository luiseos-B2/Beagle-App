package com.example.beagleapp.beagle.storehandler

import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.provider.BaseColumns
import br.com.zup.beagle.android.store.LocalStore
import com.example.beagleapp.AppApplication
import com.example.beagleapp.beagle.httpclient.BeagleMessageLogs

internal object ScreenEntry : BaseColumns {
    const val TABLE_NAME = "KeyValueCache"
    const val KEY_COLUMN_NAME = "key"
    const val VALUE_COLUMN_NAME = "value"
}

internal class DatabaseLocalStore(
    private val contentValuesFactory: ContentValuesFactory = ContentValuesFactory(),
    private val database: SQLiteDatabase = BeagleDatabaseManager.getDatabase(AppApplication.instance)
) : LocalStore {

    override fun save(key: String, value: String) {
        val values = contentValuesFactory.make().apply {
            put(ScreenEntry.KEY_COLUMN_NAME, key)
            put(ScreenEntry.VALUE_COLUMN_NAME, value)
        }


        val newRowId = database.insertWithOnConflict(
            ScreenEntry.TABLE_NAME, null, values,
            SQLiteDatabase.CONFLICT_REPLACE)
        if (newRowId == -1L) {
            BeagleMessageLogs.logDataNotInsertedOnDatabase(key, value)
        }
    }

    override fun restore(key: String): String? {
        return executeRestoreQueryForKey(key).use { cursor ->
            if (cursor.count > 0) {
                cursor.moveToFirst()
                cursor.getString(cursor.getColumnIndexOrThrow(ScreenEntry.VALUE_COLUMN_NAME))
            } else {
                null
            }
        }
    }

    override fun delete(key: String) {
        database.delete(ScreenEntry.TABLE_NAME, "${ScreenEntry.KEY_COLUMN_NAME}=?", arrayOf(key))
    }

    override fun getAll(): Map<String, String> {
        val columnsToReturn = arrayOf(ScreenEntry.KEY_COLUMN_NAME, ScreenEntry.VALUE_COLUMN_NAME)
        val columnsForWhereClause = ""
        val valuesForWhereClause = arrayOf<String>()
        val cursor = database.query(
            ScreenEntry.TABLE_NAME,
            columnsToReturn,
            columnsForWhereClause,
            valuesForWhereClause,
            null,
            null,
            null
        )

        val returnMap = mutableMapOf<String, String>()
        if (cursor.count > 0) {
            cursor.moveToFirst()
            while (!cursor.isAfterLast) {
                returnMap[cursor.getString(cursor.getColumnIndexOrThrow(ScreenEntry.KEY_COLUMN_NAME))] =
                    cursor.getString(cursor.getColumnIndexOrThrow(ScreenEntry.VALUE_COLUMN_NAME))

                cursor.moveToNext()
            }
        }
        cursor.close()

        return returnMap
    }

    private fun executeRestoreQueryForKey(key: String): Cursor {
        val columnsToReturn = arrayOf(ScreenEntry.VALUE_COLUMN_NAME)
        val columnsForWhereClause = "${ScreenEntry.KEY_COLUMN_NAME}=?"
        val valuesForWhereClause = arrayOf(key)
        return database.query(
            ScreenEntry.TABLE_NAME,
            columnsToReturn,
            columnsForWhereClause,
            valuesForWhereClause,
            null,
            null,
            null
        )
    }
}

internal class ContentValuesFactory {
    fun make(): ContentValues = ContentValues()
}

internal object BeagleDatabaseManager {

    private const val DATABASE_NAME = "BeagleDefaultStore.db"
    private const val DATABASE_VERSION = 2

    private lateinit var database: SQLiteDatabase

    fun getDatabase(context: Context): SQLiteDatabase {
        if (!BeagleDatabaseManager::database.isInitialized) {
            database = BeagleSQLiteDatabase(
                context,
                DATABASE_NAME,
                DATABASE_VERSION
            ).writableDatabase
        }
        return database
    }
}

internal open class BeagleSQLiteDatabase(
    context: Context,
    databaseName: String,
    databaseVersion: Int
) : SQLiteOpenHelper(
    context,
    databaseName,
    null,
    databaseVersion
) {
    override fun onCreate(db: SQLiteDatabase?) {
        val createTableQuery = "CREATE TABLE ${ScreenEntry.TABLE_NAME} (" +
                "${BaseColumns._ID} INTEGER PRIMARY KEY," +
                "${ScreenEntry.KEY_COLUMN_NAME} TEXT NOT NULL UNIQUE," +
                "${ScreenEntry.VALUE_COLUMN_NAME} TEXT NOT NULL" +
                ")"
        db?.execSQL(createTableQuery)
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        val deleteTableQuery = "DROP TABLE IF EXISTS ${ScreenEntry.TABLE_NAME}"
        db?.execSQL(deleteTableQuery)
        onCreate(db)
    }
}