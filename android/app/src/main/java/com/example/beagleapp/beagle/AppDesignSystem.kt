package com.example.beagleapp.beagle

import br.com.zup.beagle.android.annotation.BeagleComponent
import br.com.zup.beagle.android.setup.DesignSystem
import com.example.beagleapp.R

@BeagleComponent
class AppDesignSystem: DesignSystem() {

    override fun toolbarStyle(id: String): Int? {
        return when(id){
            "DesignSystem.Toolbar.Center" -> R.style.DesignSystem_Toolbar_Center
            else -> R.style.DesignSystem_Toolbar_Center
        }
    }

    override fun textStyle(id: String): Int? {
        return when(id){
            "DesignSystem.Text.Title" -> R.style.DesignSystem_Text_Title
            "DesignSystem.Text.Description" -> R.style.DesignSystem_Text_Description
            else -> R.style.DesignSystem_Text_Default
        }
    }

    override fun buttonStyle(id: String): Int? {
        return when(id){
            "DesignSystem.Button.Screen" -> R.style.DesignSystem_Button_Screen
            else -> R.style.DesignSystem_Button_Default
        }
    }

    override fun inputTextStyle(id: String): Int? {
        return when(id){
            "DesignSystem.TextInput.Context" -> R.style.DesignSystem_TextInput_Context
            else -> R.style.DesignSystem_TextInput_Default
        }
    }
}