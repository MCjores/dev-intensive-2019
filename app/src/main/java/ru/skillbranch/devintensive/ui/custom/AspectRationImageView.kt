package ru.skillbranch.devintensive.ui.custom

import android.content.Context
import android.util.AttributeSet
import android.widget.ImageView
import ru.skillbranch.devintensive.R

class AspectRationImageView @JvmOverloads constructor (
    context : Context,
    attrs: AttributeSet? = null,
    defStyle:Int = 0
) : ImageView(context, attrs, defStyle){
    companion object{
        private const val DEFAULT_ASPECT_RATIO = 1.78f
    }

    private var aspectRetio = DEFAULT_ASPECT_RATIO

    init {
        if(attrs!=null){
            val a = context.obtainStyledAttributes(attrs, R.styleable.AspectRationImageView)
            aspectRetio = a.getFloat(R.styleable.AspectRationImageView_aspectRatio, DEFAULT_ASPECT_RATIO)
            a.recycle()
        }
    }

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec)
        val newHeight = (measuredWidth/aspectRetio).toInt() // ширину на коэффициент измерения сторон
        setMeasuredDimension(measuredWidth, newHeight)
    }
}
