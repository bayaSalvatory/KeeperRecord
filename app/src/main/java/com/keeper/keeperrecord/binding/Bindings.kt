package com.keeper.keeperrecord.binding

import android.view.View
import androidx.core.view.isVisible
import androidx.databinding.BindingAdapter
import com.keeper.keeperrecord.widget.InputView


@BindingAdapter("hint")
fun setHint(inputView: InputView, hint: String) {
    inputView.setHint(hint)
}

@BindingAdapter("title")
fun setTitle(inputView: InputView, title: String) {
    inputView.setTitle(title)
}

@BindingAdapter("inputType")
fun setInputType(inputView: InputView, inputType: String) {
    inputView.setInputType(inputType)
}

@BindingAdapter("visibleOrGone")
fun visibleOrGone(
    view: View,
    value: Boolean
) {
    view.isVisible = value
}


