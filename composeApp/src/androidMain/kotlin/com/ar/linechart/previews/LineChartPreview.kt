package com.ar.linechart.previews

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ar.linechart.presentation.chart.ChartScreen
import com.ar.linechart.presentation.coinPriceList
import com.ar.linechart.presentation.components.LineChart
import com.ar.linechart.presentation.models.ChartStyle
import com.ar.linechart.presentation.models.DataPoint
import kotlinx.datetime.LocalDateTime
import kotlinx.datetime.format
import kotlinx.datetime.format.Padding
import kotlinx.datetime.format.char


@Preview(widthDp = 1200)
@Composable
private fun LineChartPreview() {
    MaterialTheme {
//        val coinHistoryRandomized = remember {
//            (1..20).map {
//                CoinPrice(
//                    priceUsd = Random.nextFloat() * 1000.0,
//                    dateTime = Clock.System.now().plus(it, DateTimeUnit.HOUR)
//                )
//            }.reversed()
//        }
        val style = ChartStyle(
            chartLineColor = Color.Blue,
            unselectedColor = Color(0xFF7C7C7C),
            selectedColor = Color.Cyan,
            helperLinesThicknessPx = 5f,
            axisLinesThicknessPx = 5f,
            labelFontSize = 14.sp,
            minYLabelSpacing = 25.dp,
            verticalPadding = 8.dp,
            horizontalPadding = 8.dp,
            xAxisLabelSpacing = 8.dp
        )

        val dataPoints = remember {
            coinPriceList.map {
                DataPoint(
                    x = it.dateTime.hour.toFloat(),
                    y = it.priceUsd.toFloat(),
                    xLabel = it.dateTime
                        .format(
                            LocalDateTime.Format {
                                amPmHour(Padding.NONE)
                                amPmMarker("AM", "PM")
                                char('\n')
                                monthNumber()
                                char('/')
                                dayOfMonth()
                            }
                        )
                )
            }
        }
        LineChart(
            dataPoints = dataPoints,
            style = style,
            visibleDataPointsIndices = 0..19,
            unit = "$",
            modifier = Modifier
                .width(700.dp)
                .height(300.dp)
                .background(MaterialTheme.colorScheme.background),
            selectedDataPoint = dataPoints[11]
        )
    }
}

@Preview(device = Devices.TABLET)
@Preview(device = Devices.PIXEL_FOLD)
@Preview(device = Devices.PHONE)
@Preview(device = Devices.TV_1080p )
@Composable
private fun ChartScreenPreview() {
    MaterialTheme {
        ChartScreen()
    }
}