package com.example.painting

import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.util.Log
import android.widget.ImageView

class MaskImage @JvmOverloads constructor(context: Context, attributeSet: AttributeSet? = null, defStyleAttr :Int = 0)
    : androidx.appcompat.widget.AppCompatImageView(context , attributeSet , defStyleAttr) {


    private  val imageBitmap = BitmapFactory.decodeResource(resources , R.drawable.pict)
    private  var maskBitmap = BitmapFactory.decodeResource(resources , R.drawable.mask9)
    private val resizedMaskBitmap = Bitmap.createScaledBitmap(maskBitmap , 700 , 700 , true)
    private val paint = Paint()
    init {
        setLayerType(LAYER_TYPE_SOFTWARE , null)
        paint.apply {
            isAntiAlias = true
            xfermode = PorterDuffXfermode(PorterDuff.Mode.DST_OUT);
        }
    }


    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        canvas.apply {
            drawBitmap(imageBitmap, 0f, 0f, null)
            drawBitmap(resizedMaskBitmap ,0f,0f, paint)
            paint.xfermode = null
        }
    }


}