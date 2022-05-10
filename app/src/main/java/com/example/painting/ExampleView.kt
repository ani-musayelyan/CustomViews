package com.example.painting

import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.util.Log
import android.view.View

class ExampleView @JvmOverloads constructor (context: Context,
                                             attrs: AttributeSet? = null,
                                             defStyleAtr: Int = 0)  : View(context , attrs , defStyleAtr){

    private var paint = Paint()
    private var path = Path()
    var mode: PorterDuff.Mode = PorterDuff.Mode.CLEAR
        set(value) {
            field = value
            paint.xfermode = PorterDuffXfermode(mode)
            invalidate()
        }
    init {
        paint.apply {
            color = Color.RED
            style = Paint.Style.STROKE
            strokeWidth = 10f
        }
        path.apply {
            moveTo(100f , 100f)
            lineTo(100f , 580f)
            lineTo(580f , 580f)
            lineTo(100f , 100f)
        }
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        canvas.apply {
            drawPath(path, paint)
        }
    }

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        Log.v("gggw", MeasureSpec.toString(widthMeasureSpec));
        Log.v("gggh", MeasureSpec.toString(heightMeasureSpec));
        setMeasuredDimension(700 , 700)
    }


}