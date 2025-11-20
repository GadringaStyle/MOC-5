package com.example.canteenchecker.adminapp.misc

import android.content.Context
import android.graphics.Canvas
import android.graphics.Paint
import android.text.TextPaint
import android.util.AttributeSet
import android.widget.EditText
import androidx.appcompat.widget.AppCompatEditText
import com.example.canteenchecker.adminapp.R
import androidx.core.content.withStyledAttributes

class EditTextWithSuffix : AppCompatEditText {
    private val textPaint: TextPaint = TextPaint();
    private lateinit var suffix: String;
    private var suffixPadding: Float = 0.0f;
    constructor(context: Context) : super(context)
    constructor(context: Context, attr: AttributeSet) : super(context, attr) {
        getAttributes(context, attr, 0)
    }
    constructor(context: Context, attr: AttributeSet, defStyleAttr: Int) : super(context, attr, defStyleAttr){
        getAttributes(context, attr, defStyleAttr)
    }

    override fun onDraw(canvas: Canvas){
        super.onDraw(canvas)
        val suffixPosX: Float =  (textPaint.measureText(text.toString()) + paddingLeft)
        canvas.drawText(suffix,
            suffixPosX.coerceAtLeast(suffixPadding), baseline.toFloat(), textPaint)
    }

    override fun onFinishInflate() {
        super.onFinishInflate()
        textPaint.setColor(currentTextColor)
        textPaint.textSize = textSize
        textPaint.textAlign = Paint.Align.LEFT
    }

    private fun getAttributes(context: Context, attr: AttributeSet, defStyle: Int){
        context.withStyledAttributes(attr, R.styleable.EditTextWithSuffix) {
            suffix = getString(R.styleable.EditTextWithSuffix_suffix) ?: ""
            suffixPadding = getDimension(R.styleable.EditTextWithSuffix_suffixPadding, 0.0f)
        }
    }
}