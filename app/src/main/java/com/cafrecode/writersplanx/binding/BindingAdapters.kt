package com.cafrecode.writersplanx.binding

import android.icu.text.RelativeDateTimeFormatter
import android.text.format.DateUtils
import android.widget.ImageView
import android.widget.TextView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide

class BindingAdapters {

    companion object {

        @JvmStatic
        @BindingAdapter("app:time")
        fun setText(view: TextView, value: Long) {
            val format = RelativeDateTimeFormatter.getInstance()
            view.text = DateUtils.getRelativeTimeSpanString(
                value,
                System.currentTimeMillis(),
                DateUtils.DAY_IN_MILLIS
            );
        }

        @JvmStatic
        @BindingAdapter("app:imageUrl")
        fun setImage(imageView: ImageView, imageUrl: String?){
            if(!imageUrl.isNullOrEmpty()){
                Glide.with(imageView.context).load(imageUrl).into(imageView)
            }
        }
    }
}