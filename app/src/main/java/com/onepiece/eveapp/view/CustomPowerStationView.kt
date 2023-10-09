package com.onepiece.eveapp.view

import android.animation.ValueAnimator
import android.content.Context
import android.graphics.Canvas
import android.graphics.Paint
import android.util.AttributeSet
import android.util.Log
import android.view.View
import android.view.ViewGroup
import android.view.animation.LinearInterpolator
import android.widget.ImageView
import androidx.constraintlayout.widget.ConstraintLayout
import com.blankj.utilcode.util.ScreenUtils
import com.onepiece.eveapp.R
import com.onepiece.eveapp.utils.centerX
import com.onepiece.eveapp.utils.centerY
import com.onepiece.eveapp.utils.dp
import kotlin.math.atan
import kotlin.math.tan


class CustomPowerStationView : ConstraintLayout {

    private lateinit var leftTopView: View
    private lateinit var rightTopView: View
    private lateinit var leftBottomView: View
    private lateinit var rightBottomView: View


    private val paint1: Paint by lazy {
        val paint = Paint()
        paint.setAntiAlias(true)
        paint.setStrokeWidth(2f.dp)
        paint.setStyle(Paint.Style.FILL)
        paint.color = this.context.getColor(R.color.line_color)
        paint
    }

    private val paint2: Paint by lazy {
        val paint = Paint()
        paint.setAntiAlias(true)
        paint.setStrokeWidth(2f.dp)
        paint.setStyle(Paint.Style.FILL)
        paint.color = this.context.getColor(R.color.line_color)
        paint
    }


    public var leftTopImage: ImageView? = null

    public var rightTopImage: ImageView? = null

    constructor(context: Context) : this(context, null)
    constructor(context: Context, attrs: AttributeSet?) : this(context, attrs, 0)
    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(
        context, attrs, defStyleAttr
    ) {
        init(context, attrs!!)
    }

    private fun init(context: Context, attrs: AttributeSet) {
        leftTopImage = ImageView(context)
        rightTopImage = ImageView(context)
    }


    override fun onSizeChanged(w: Int, h: Int, oldw: Int, oldh: Int) {
        super.onSizeChanged(w, h, oldw, oldh)

    }

    override fun onLayout(changed: Boolean, left: Int, top: Int, right: Int, bottom: Int) {
        super.onLayout(changed, left, top, right, bottom)
        leftTopView = getViewById(R.id.left_top_image)
        rightBottomView = getViewById(R.id.right_bottom_image)
        rightTopView = getViewById(R.id.right_top_image)
        leftBottomView = getViewById(R.id.left_bottom_image)
    }

    override fun dispatchDraw(canvas: Canvas) {
        drawLine(canvas)
        super.dispatchDraw(canvas)



    }

    private fun drawLine(canvas: Canvas) {
        canvas.drawLine(
            leftTopView.centerX.toFloat(),
            leftTopView.centerY.toFloat(),
            rightBottomView.centerX.toFloat(),
            rightBottomView.centerY.toFloat(),
            paint1
        )

        canvas.drawLine(
            rightTopView.centerX.toFloat(),
            rightTopView.centerY.toFloat(),
            leftBottomView.centerX.toFloat(),
            leftBottomView.centerY.toFloat(),
            paint2
        )
    }


    public fun startLeftTopAnimaor() {
        // 获取ImageView的初始位置
        // 获取ImageView的初始位置
        val startX = leftTopView.centerX + 13f.dp
        val startY = leftTopView.centerY

        // 获取ImageView的目标位置
        val endX = rightBottomView.centerX + 13f.dp// 目标X坐标
        val endY = rightBottomView.centerY // 目标Y坐标

        val animator = ValueAnimator.ofFloat(0f, 1f)
        animator.duration = 10000 // 动画持续时间，单位毫秒

        animator.interpolator = LinearInterpolator()
        animator.repeatCount = ValueAnimator.INFINITE // 无限重复

        animator.addUpdateListener { animation ->
            val fraction = animation.animatedFraction
            // 在更新监听器中计算ImageView的当前位置
            val currentX = startX + (endX - startX) * fraction
            val currentY = startY + (endY - startY) * fraction
            // 更新ImageView的位置
            leftTopImage?.pivotX = 0f
            leftTopImage?.pivotY = 0f
            leftTopImage?.translationX = currentX
            leftTopImage?.translationY = currentY
        }
        animator.start()
    }

    public fun startRightTopAnimaor() {
        // 获取ImageView的初始位置
        // 获取ImageView的初始位置
        val startX = rightTopView.centerX + 12f.dp
        val startY = rightTopView.centerY

        // 获取ImageView的目标位置
        val endX = leftBottomView.centerX + 12f.dp// 目标X坐标
        val endY = leftBottomView.centerY // 目标Y坐标

        val animator = ValueAnimator.ofFloat(0f, 1f)
        animator.duration = 10000 // 动画持续时间，单位毫秒

        animator.interpolator = LinearInterpolator()
        animator.repeatCount = ValueAnimator.INFINITE // 无限重复

        animator.addUpdateListener { animation ->
            val fraction = animation.animatedFraction
            // 在更新监听器中计算ImageView的当前位置
            val currentX = startX + (endX - startX) * fraction
            val currentY = startY + (endY - startY) * fraction
            // 更新ImageView的位置
            rightTopImage?.pivotX = 0f
            rightTopImage?.pivotY = 0f
            rightTopImage?.translationX = currentX
            rightTopImage?.translationY = currentY
        }
        animator.start()
    }


    public fun addLeftTopImage() {
        leftTopImage?.setImageResource(R.mipmap.img_light)
        val layoutManager = ViewGroup.MarginLayoutParams(42f.dp.toInt(), 15f.dp.toInt())
////        layoutManager.setMargins(100,100,0,0)
        leftTopImage?.layoutParams = layoutManager
//        image?.rotation = 45f
        leftTopImage?.pivotX = 0f
        leftTopImage?.pivotY = 0f
        val tanValue = tan(172f.dp / (ScreenUtils.getScreenWidth() - 128f.dp))
        Log.e("eve", tanValue.toString())
        val degree = atan(tanValue)
        Log.e("eve", ScreenUtils.getScreenWidth().toString())
        leftTopImage?.rotation = Math.toDegrees(degree.toDouble()).toFloat() - 2f
//        image?.x = leftTopView.centerX.toFloat()
        Log.e("eve", leftTopImage?.rotation.toString())
//        image?.y = leftTopView.centerY.toFloat()
        this.addView(leftTopImage, 1)
    }

    public fun addRightTopImage() {
        rightTopImage?.setImageResource(R.mipmap.img_light)
        val layoutManager = ViewGroup.MarginLayoutParams(42f.dp.toInt(), 15f.dp.toInt())
////        layoutManager.setMargins(100,100,0,0)
        rightTopImage?.layoutParams = layoutManager
//        image?.rotation = 45f
        rightTopImage?.pivotX = 0f
        rightTopImage?.pivotY = 0f

//        rightTopImage?.x = rightTopView.centerX.toFloat() + 13f.dp
//        rightTopImage?.y = rightTopView.centerY.toFloat()
        val tanValue =
            tan(188f.dp/(ScreenUtils.getScreenWidth()-132f.dp))
        Log.e("eve", tanValue.toString())
        val degree = atan(tanValue)
        Log.e("eve", ScreenUtils.getScreenWidth().toString())
        rightTopImage?.rotation = 180 - Math.toDegrees(degree.toDouble()).toFloat() + 7f
//        image?.x = leftTopView.centerX.toFloat()
        Log.e("eve", leftTopImage?.rotation.toString())
//        image?.y = leftTopView.centerY.toFloat()
        this.addView(rightTopImage,2)
    }

}