package com.example.painting

import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.util.Log
import android.view.View
import kotlin.math.cos
import kotlin.math.sin

class StarView @JvmOverloads constructor(context: Context, attributeSet: AttributeSet?= null, defStyleAttributeSet: Int= 0)
    :View(context , attributeSet , defStyleAttributeSet) {


    val starPaint = Paint()
    val starPath = Path()

    init {
        val r = 60f
        val c = 128.0f
        starPath.apply {
            moveTo(c+r , c)
            for (i in 1..15) {
                val a = 0.44879895f * i
                val r1 = r+r*(i%2)
                lineTo(c+r* cos(a) , c+r* sin(a))
            }
        }

        setLayerType(LAYER_TYPE_SOFTWARE , null)

        starPaint.apply {
            color = Color.YELLOW
            style = Paint.Style.FILL_AND_STROKE
            strokeWidth = 4f
            strokeCap = Paint.Cap.ROUND
            isAntiAlias = true
            alpha = 180
            xfermode = PorterDuffXfermode(PorterDuff.Mode.SRC_ATOP)
        }

    }
    private val points = FloatArray(750*4)
    init {
        for (i in 1..749*4) {
            points[i] = Math.random().toFloat() * 1080
            Log.i("st" , points[i].toString())
        }
    }


    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        setBackgroundColor(Color.parseColor("#0B0B45")).apply {
            alpha = 0.85f
        }
        canvas.apply {
            translate(40f , 10f)
            drawPath(starPath , starPaint)
            drawPoints(points , starPaint)
        }
    }

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec)
        Log.v("gw", MeasureSpec.toString(widthMeasureSpec));
        Log.v("gh", MeasureSpec.toString(heightMeasureSpec));
    }


}