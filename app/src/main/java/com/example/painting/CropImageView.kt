package com.example.painting

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.view.MotionEvent
import android.view.View

class CropImageView  @JvmOverloads constructor(context: Context, attributeSet: AttributeSet? = null, defaultAttrs: Int = 0)
    : View(context , attributeSet , defaultAttrs) {

  //  private var picBitmap : Bitmap
    private var pict  = R.drawable.pict
    private var path = Path()
    private var paint : Paint
    init {
        setLayerType(LAYER_TYPE_SOFTWARE , null)
        attributeSet.let {
            val typedArray = context.obtainStyledAttributes(it , R.styleable.CropImageView , 0 , 0)
            pict = typedArray.getResourceId(R.styleable.CropImageView_image , R.drawable.pict)
            typedArray.recycle()
        }
        paint = Paint()
        paint.apply {
            color = Color.BLUE
            style = Paint.Style.STROKE
            strokeWidth = 5F
        }
    }
    private var picBitmap = BitmapFactory.decodeResource(resources , R.drawable.pict)


    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        canvas.apply {
            drawBitmap(picBitmap , 0f , 0f , null)
            drawPath(path , paint)
        }
    }

    @SuppressLint("ClickableViewAccessibility")
    override fun onTouchEvent(event: MotionEvent): Boolean {
        val x : Float = event.x
        val y : Float = event.y
        when(event.action) {
            MotionEvent.ACTION_DOWN -> {
                path.moveTo(x , y)

            }
            MotionEvent.ACTION_MOVE -> {
                path.lineTo(x , y)

            }
            MotionEvent.ACTION_UP -> {
                path.lineTo(x, y)
                cropBitmap()
            }
        }
        invalidate()
        return true
    }


    private fun cropBitmap() {
        val paint = Paint()
        val croppedBitmap = Bitmap.createBitmap(picBitmap.width , picBitmap.height , picBitmap.config )
        val cropCanvas = Canvas(croppedBitmap)
        cropCanvas.drawBitmap(picBitmap , 0f ,0f ,paint)
        cropCanvas.drawPath(path,paint)
        paint.xfermode = PorterDuffXfermode(PorterDuff.Mode.DST_IN)
        picBitmap = croppedBitmap
        invalidate()
    }

    }