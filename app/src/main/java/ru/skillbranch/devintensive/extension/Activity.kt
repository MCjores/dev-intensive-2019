package ru.skillbranch.devintensive.extension

import android.app.Activity
import android.content.Context
import android.view.View
import android.view.WindowManager
import android.view.inputmethod.InputMethodManager
import androidx.core.content.getSystemService


/**
 * Метод скрытия клавиатуры
 */
fun Activity.hideKeyboard() {
//    window.setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN)
    val imm: InputMethodManager =
        getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
    val view: View? = this.currentFocus ?: View(this)


    imm.hideSoftInputFromWindow(view!!.windowToken, 0)
}