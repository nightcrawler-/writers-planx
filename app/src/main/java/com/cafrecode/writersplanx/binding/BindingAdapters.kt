package com.cafrecode.writersplanx.binding

import android.icu.text.RelativeDateTimeFormatter
import android.widget.TextView
import androidx.databinding.BindingAdapter

class BindingAdapters {

    companion object {

        @JvmStatic
        @BindingAdapter("app:time")
        fun setText(view: TextView, value: Long) {
            val format = RelativeDateTimeFormatter.getInstance()
            view.text = format.format(
                (value / 1000).toDouble(),
                RelativeDateTimeFormatter.Direction.PLAIN,
                RelativeDateTimeFormatter.RelativeUnit.SECONDS
            )
        }
    }
}