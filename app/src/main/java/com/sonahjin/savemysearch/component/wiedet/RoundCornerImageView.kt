package com.sonahjin.savemysearch.component.wiedet

import android.annotation.SuppressLint
import android.content.Context
import android.content.res.TypedArray
import android.graphics.Canvas
import android.graphics.Path
import android.graphics.RectF
import android.util.AttributeSet
import android.widget.ImageView
import com.sonahjin.savemysearch.R

@SuppressLint("AppCompatCustomView")
class RoundCornerImageView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : ImageView(context, attrs, defStyleAttr) {

    private val cornerRect = RectF()
    private val path = Path()
    var radius: Int = 0
        private set
    private var roundedCorners: Int = 0

    init {

        val a = context.obtainStyledAttributes(attrs, R.styleable.RoundishImageView)
        radius = a.getDimensionPixelSize(R.styleable.RoundishImageView_cornerRadius, 0)
        roundedCorners = a.getInt(R.styleable.RoundishImageView_roundedCorners, CORNER_NONE)
        a.recycle()
    }

    fun setCornerRadius(radius: Int) {
        this.radius = radius
        setPath()
        invalidate()
    }

    fun setRoundedCorners(corners: Int) {
        roundedCorners = corners
        setPath()
        invalidate()
    }

    fun getRoundedCorners(): Int {
        return roundedCorners
    }

    override fun onSizeChanged(w: Int, h: Int, oldw: Int, oldh: Int) {
        super.onSizeChanged(w, h, oldw, oldh)
        setPath()
    }

    override fun onDraw(canvas: Canvas) {
        if (!path.isEmpty) {
            canvas.clipPath(path)
        }
        super.onDraw(canvas)
    }

    private fun setPath() {
        path.rewind()

        if (radius >= 1f && roundedCorners != CORNER_NONE) {
            val width = width
            val height = height
            val twoRadius = (radius * 2).toFloat()
            cornerRect.set((-radius).toFloat(), (-radius).toFloat(), radius.toFloat(), radius.toFloat())

            if (isRounded(CORNER_TOP_LEFT)) {
                cornerRect.offsetTo(0f, 0f)
                path.arcTo(cornerRect, 180f, 90f)
            } else {
                path.moveTo(0f, 0f)
            }

            if (isRounded(CORNER_TOP_RIGHT)) {
                cornerRect.offsetTo(width - twoRadius, 0f)
                path.arcTo(cornerRect, 270f, 90f)
            } else {
                path.lineTo(width.toFloat(), 0f)
            }

            if (isRounded(CORNER_BOTTOM_RIGHT)) {
                cornerRect.offsetTo(width - twoRadius, height - twoRadius)
                path.arcTo(cornerRect, 0f, 90f)
            } else {
                path.lineTo(width.toFloat(), height.toFloat())
            }

            if (isRounded(CORNER_BOTTOM_LEFT)) {
                cornerRect.offsetTo(0f, height - twoRadius)
                path.arcTo(cornerRect, 90f, 90f)
            } else {
                path.lineTo(0f, height.toFloat())
            }

            path.close()
        }
    }

    private fun isRounded(corner: Int): Boolean {
        return roundedCorners and corner == corner
    }

    companion object {

        val CORNER_NONE = 0
        val CORNER_TOP_LEFT = 1
        val CORNER_TOP_RIGHT = 2
        val CORNER_BOTTOM_RIGHT = 4
        val CORNER_BOTTOM_LEFT = 8
        val CORNER_ALL = 15
    }
}