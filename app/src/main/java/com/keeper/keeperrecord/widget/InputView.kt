package com.keeper.keeperrecord.widget

import android.content.Context
import android.text.InputType
import android.util.AttributeSet
import android.view.View
import android.widget.LinearLayout
import com.keeper.keeperrecord.R
import kotlinx.android.synthetic.main.item_input_et_view.view.*

class InputView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyle: Int = 0
) : LinearLayout(context, attrs, defStyle) {

    companion object {
        const val EMAIL = "email"
        const val PASSWORD = "password"
    }

    val text: String
        get() = input_et.text.trim().toString()

    init {
        View.inflate(context, R.layout.item_input_et_view, this)
    }

    fun setHint(hint: String) {
        input_et.hint = hint
    }

    fun setTitle(title: String) {
        title_tv.text = title
    }

    fun setInputType(inputType: String) {
        when (inputType) {
            EMAIL -> {
                input_et.inputType = InputType.TYPE_TEXT_VARIATION_EMAIL_ADDRESS
            }
            PASSWORD -> {
                input_et.inputType =
                    InputType.TYPE_CLASS_TEXT or InputType.TYPE_TEXT_VARIATION_PASSWORD
            }
        }

    }

}