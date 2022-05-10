package com.example.painting

import android.content.Context
import android.graphics.*
import android.view.View

class DrawView(context  : Context) : View(context) {

    private var paintSrc :Paint? = null
    private var paintDest :Paint? = null
    private var paintBorder : Paint? = null

    var pathSrc: Path? = null
    var pathDst: Path? = null

    private var srcBitmap: Bitmap? = null
    private var dstBitmap: Bitmap? = null

     private var mode = PorterDuff.Mode.SRC_OVER



    private var colorDst: Int = Color.BLUE
    private var colorSrc: Int = Color.YELLOW

    init {

        setLayerType(LAYER_TYPE_SOFTWARE, null)
        //source
        pathSrc = Path()
        pathSrc.let {
            it!!.moveTo(0f , 0f)
            it.lineTo(500f , 0f)
            it.lineTo(0f , 500f)
            it.close()
        }
        srcBitmap = createBitmap(pathSrc!! , colorSrc)
        paintSrc = Paint()

        //destination
        pathDst = Path()
        pathDst.let {
            it!!.moveTo(0f , 0f)
            it.lineTo(500f , 0f)
            it.lineTo(500f,500f)
            it.close()
        }
        dstBitmap = createBitmap(pathDst!! , colorDst)

        paintDest = Paint()

        paintSrc!!.xfermode = PorterDuffXfermode(mode)

        // кисть для рамки
        paintBorder = Paint();
        paintBorder!!.style = Paint.Style.STROKE;
        paintBorder!!.strokeWidth = 3f;
        paintBorder!!.color = Color.BLACK;


    }
    private fun createBitmap(path : Path , color: Int) : Bitmap {
        val bitmap : Bitmap = Bitmap.createBitmap(500,500,Bitmap.Config.ARGB_8888)
        val bitmapCanvas = Canvas(bitmap)

        val paint = Paint(Paint.ANTI_ALIAS_FLAG)
        paint.style = Paint.Style.FILL
        paint.color = color
        bitmapCanvas.drawPath(path , paint)
        return bitmap
    }

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        canvas?.translate(80f , 80f)
        canvas?.drawBitmap(dstBitmap!! , 0f , 0f , paintDest)
        canvas?.drawBitmap(srcBitmap!! , 0f , 0f , paintSrc)

        canvas?.drawRect(0f, 0f, 500f, 500f, paintBorder!!);

    }






}