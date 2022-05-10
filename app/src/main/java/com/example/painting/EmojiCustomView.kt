package com.example.painting

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.util.AttributeSet
import android.view.View

class EmojiCustomView(
    context: Context ,
    attributeSet: AttributeSet? = null ,
    defaultAttrs: Int = 0
) : View(context , attributeSet , defaultAttrs) {

    private val painter = Paint().apply {
        color = Color.YELLOW
        style = Paint.Style.FILL
        isAntiAlias = true
        strokeWidth = 40f
    }

    override fun onDraw(canvas: Canvas) {

        canvas.apply {
            val centerX = (width/2).toFloat()
            val centerY = (height/2).toFloat()
            drawColor(Color.DKGRAY)
            drawCircle(centerX , centerY , 300f , painter)
            painter.color = Color.BLACK
            drawCircle(centerX-100 , centerY-100 , 50f , painter)
            drawCircle(centerX+100 , centerY-100 , 50f , painter)
            drawLine(centerX-130 , centerY+150 , centerX+130 , centerY+130,painter)
        }

    }

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec)
    }



}