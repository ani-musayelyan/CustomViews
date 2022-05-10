package com.example.painting

import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.view.View

class CropUsingCanvas @JvmOverloads constructor(context: Context, attributeSet: AttributeSet? = null, defaultAttrs: Int = 0)
    : View(context , attributeSet , defaultAttrs) {

    var bitmapImg = BitmapFactory.decodeResource(resources , R.drawable.img1)


    var cropRect: Rect = Rect(100, 100, 600, 600)
    var paint = Paint()
    init {
        setLayerType(LAYER_TYPE_SOFTWARE , null)
        paint.apply {
            style = Paint.Style.FILL
            strokeWidth = 10f
            isAntiAlias = true
            xfermode = PorterDuffXfermode(PorterDuff.Mode.LIGHTEN)
        }
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        canvas.drawBitmap(bitmapImg , 0f , 0f , null)
        canvas.drawRect(cropRect , paint.apply {
            color = Color.RED
        })
        paint.xfermode = null

    }


}