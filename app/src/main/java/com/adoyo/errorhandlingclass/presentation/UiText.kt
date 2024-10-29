package com.adoyo.errorhandlingclass.presentation

import android.content.Context
import androidx.annotation.StringRes
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext

sealed class UiText {
    data class DynamicString(val value: String) : UiText()
    class StringResources(@StringRes val id: Int, val args: Array<Int> = arrayOf()) : UiText()

    @Composable
    fun asString(): String {
        return  when(this) {
            is DynamicString -> value
            is StringResources -> LocalContext.current.getString(id, args)
        }
    }

    fun asString(context: Context): String {
        return when(this) {
            is DynamicString -> value
            is StringResources -> context.getString(id, args)
        }
    }
}