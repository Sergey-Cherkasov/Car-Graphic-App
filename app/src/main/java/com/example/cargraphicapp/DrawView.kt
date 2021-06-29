package com.example.cargraphicapp

import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.view.View

class DrawView(c: Context) : View(c) {
    constructor(c: Context, attrs: AttributeSet)
            : this(c)
    constructor(c: Context, attrs: AttributeSet, defStyleAttr: Int)
            : this(c, attrs)

    override fun onDraw(canvas: Canvas?) {
        val paint: Paint = Paint()
        paint.style = Paint.Style.STROKE
        paint.color = Color.BLACK
        paint.strokeWidth = 2f
        canvas?.drawPath(drawCar(), paint)
    }

    private fun drawCar(): Path {
        val path = Path()
        path.moveTo(50f, 50f)
        path.addRoundRect(
            50f, 50f,
            100f, 60f,
            floatArrayOf(4f, 4f, 4f, 4f, 4f, 4f, 4f, 4f),
            Path.Direction.CW
        )
        path.addRoundRect(
            55f, 40f,
            90f, 50f,
            floatArrayOf(4f, 4f, 4f, 4f, 4f, 4f, 4f, 4f),
            Path.Direction.CW
        )
        path.addCircle(64f, 64f, 8f, Path.Direction.CW)
        path.addCircle(89F, 64f, 8f, Path.Direction.CW)
        return path
    }
}