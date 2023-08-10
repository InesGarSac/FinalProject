package com.keepcoding.finalproject.components

import android.content.Context
import android.util.AttributeSet
import android.widget.FrameLayout
import android.widget.ImageView
import com.keepcoding.finalproject.R

class StarComponent @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : FrameLayout(context, attrs, defStyleAttr) {

    private val imageView: ImageView

    var checked: Boolean = false
        set(value) {
            field = value
            selectImage()
        }


    init {
        imageView = inflate(context, R.layout.component_star, this)
            .findViewById(R.id.iv_star)
    }

    private fun selectImage() = imageView.setImageResource(
        if (checked) {
            R.drawable.favorite_filled_white
        } else {
            R.drawable.favorite_white
        }
    )
}
