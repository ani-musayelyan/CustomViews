package com.example.painting

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.view.View

@SuppressLint("CustomViewStyleable")
class DrawPorterDuffView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0,
    defStyleRes: Int = 0
) : View(context , attrs , defStyleAttr , defStyleRes) {

    private val fullRect by lazy {
        Rect(0, 0, width, height)
    }

    private val paintDest = Paint()
    private val paintSrc = Paint()
    private var resourceImageSrc = R.drawable.img5
    private var resourceImageDst= R.drawable.grid


    init {
        setLayerType(LAYER_TYPE_SOFTWARE, null)
        attrs?.let {
            val typedArray = context.obtainStyledAttributes(it,
                R.styleable.draw_porter_duff_attributes, 0, 0)
            resourceImageSrc = typedArray.getResourceId(
                R.styleable.draw_porter_duff_attributes_draw_porter_duff_image_src, R.drawable.img5)
            resourceImageDst = typedArray.getResourceId(
                R.styleable.draw_porter_duff_attributes_draw_porter_duff_image_dst, R.drawable.grid)

            typedArray.recycle()
        }
    }


    private val bitmapSource by lazy { BitmapFactory.decodeResource(resources, resourceImageSrc) }
    private val bitmapDestination by lazy { BitmapFactory.decodeResource(resources, resourceImageDst) }


    var mode: PorterDuff.Mode = PorterDuff.Mode.CLEAR
        set(value) {
            field = value
            paintSrc.xfermode = PorterDuffXfermode(mode)
            invalidate()
        }

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)

        if (width == 0 || height == 0) return
        canvas?.drawBitmap(bitmapDestination, null, fullRect, paintDest)
        canvas?.drawBitmap(bitmapSource, null, fullRect, paintSrc)
    }


}