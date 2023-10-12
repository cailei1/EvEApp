package com.onepiece.eveapp.ui.station

import android.graphics.Color
import androidx.core.content.ContextCompat
import com.github.mikephil.charting.charts.LineChart
import com.github.mikephil.charting.components.XAxis
import com.github.mikephil.charting.components.YAxis
import com.github.mikephil.charting.data.Entry
import com.github.mikephil.charting.data.LineData
import com.github.mikephil.charting.data.LineDataSet
import com.github.mikephil.charting.formatter.IndexAxisValueFormatter
import com.onepiece.eveapp.R
import com.onepiece.eveapp.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject


@HiltViewModel
class PowerStationViewModel @Inject constructor() : BaseViewModel() {


    fun initLineChart(lineChart: LineChart) {
        //无数据时显示
        //无数据时显示
        lineChart.setNoDataText("没有获取到数据哦~")
        lineChart.setNoDataTextColor(Color.parseColor("#00bcef"))
        //取消缩放
        //取消缩放
        lineChart.setScaleEnabled(false)
        //不显示高亮
        //不显示高亮
        lineChart.setHighlightPerTapEnabled(false)
        //不显示description
        //不显示description
        lineChart.getDescription().setEnabled(false)
        //不显示边界
        //不显示边界
        lineChart.setDrawBorders(false)
        //不显示图例
        //不显示图例
        lineChart.getLegend().setEnabled(false)
        lineChart.setHighlightPerDragEnabled(false)
        lineChart.setExtraBottomOffset(10f)
        //获取X轴
        //获取X轴
        val xAxis: XAxis = lineChart.getXAxis()

        xAxis.valueFormatter = IndexAxisValueFormatter(
            arrayOf(
                "00:00",
                "04:00",
                "08:00",
                "12:00",
                "16:00",
                "18:00",
                "24:00"
            )
        )
        xAxis.setDrawGridLines(false)
        xAxis.setDrawAxisLine(false)
        xAxis.position = XAxis.XAxisPosition.BOTTOM
        xAxis.textSize = 12f
        val leftYAxis: YAxis = lineChart.axisLeft
        leftYAxis.setGranularity(5f); // 设置标签间隔
        leftYAxis.setAxisMinimum(0f); // 设置最小值
        leftYAxis.setAxisMaximum(25f);
        leftYAxis.axisMinimum = 0f
//        leftYAxis.isEnabled = false
        val rightYAxis: YAxis = lineChart.getAxisRight()
        rightYAxis.isEnabled = false
        //初始化显示数据
        //初始化显示数据
        val floats: MutableList<Float> = ArrayList()
        floats.add(10f)
        floats.add(12f)
        floats.add(15f)
        floats.add(10f)
        floats.add(8f)
        floats.add(7f)
        floats.add(14f)
        val entries: MutableList<Entry> = ArrayList()
        for (i in floats.indices) {
            entries.add(Entry(i.toFloat(), floats[i]))
        }
        //将数据赋给数据集,一个数据集表示一条线
        //将数据赋给数据集,一个数据集表示一条线
        val lineDataSet = LineDataSet(entries, "")
        //线颜色
        //线颜色
        lineDataSet.color = Color.parseColor("#FF099D84")
        //线宽度
        //线宽度
        lineDataSet.lineWidth = 1.0f
        //显示圆点
        //显示圆点
        lineDataSet.setDrawCircles(true)
        //设置圆点颜色(外圈)
        //设置圆点颜色(外圈)
        lineDataSet.setCircleColor(Color.parseColor("#FF099D84"))
        //设置圆点填充颜色
        //设置圆点填充颜色
        lineDataSet.circleHoleColor = Color.parseColor("#FF099D84")
        //设置线条为平滑曲线
        //设置线条为平滑曲线
        lineDataSet.mode = LineDataSet.Mode.HORIZONTAL_BEZIER
        //设置直线图填充
        //设置直线图填充
        lineDataSet.setDrawFilled(true)
        //设置填充颜色
        //设置填充颜色
        val drawable = ContextCompat.getDrawable(lineChart.context, R.drawable.chart_bg)
        lineDataSet.fillDrawable = drawable
//        lineDataSet.fillColor = Color.parseColor("#FFA2A2")
        val lineData = LineData(lineDataSet)
        //不显示曲线点的具体数值
        //不显示曲线点的具体数值
        lineData.setDrawValues(false)
        lineChart.setData(lineData)
    }
}