package com.example.painting

import android.content.Context
import android.graphics.*
import android.view.View

class CircleView(context: Context) : View(context) {

    private val paintCircle = Paint()
    private val paintRect = Paint()

    init {
        setLayerType(LAYER_TYPE_SOFTWARE, null)
        paintRect.apply {
            color = Color.GREEN
            style = Paint.Style.STROKE
            strokeWidth = 10f
           // xfermode = PorterDuffXfermode(PorterDuff.Mode.DST)
        }

        paintCircle.apply {
            color = Color.YELLOW
            xfermode = PorterDuffXfermode(PorterDuff.Mode.DST_IN)
            isAntiAlias = true
        }
        invalidate()
    }

    private val rect = Rect(200 ,500 , 580 , 880)


    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        if (width == 0 || height == 0) return
        canvas.apply {
            drawPaint(paintRect.apply {
                color = Color.GRAY
                style = Paint.Style.FILL
            })
          //  drawRect(rect , paintRect)
            drawCircle((width/2).toFloat() , (height/2).toFloat() , 280f , paintCircle)

        }
    }

}