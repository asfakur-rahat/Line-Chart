package com.ar.linechart.presentation.chart

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.Icon
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.onSizeChanged
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ar.linechart.presentation.coinPriceList
import com.ar.linechart.presentation.components.LineChart
import com.ar.linechart.presentation.models.ChartStyle
import com.ar.linechart.presentation.models.DataPoint
import kotlinx.datetime.LocalDateTime
import kotlinx.datetime.format
import kotlinx.datetime.format.Padding
import kotlinx.datetime.format.char


@Composable
fun ChartScreen(
    goBack: () -> Unit = {},
){
    val coinHistory = coinPriceList.map {
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
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = {
            Box(
                modifier = Modifier.fillMaxWidth().height(64.dp),
                contentAlignment = Alignment.Center
            ) {
                Icon(
                    modifier = Modifier.size(48.dp)
                        .align(Alignment.CenterStart)
                        .padding(start = 20.dp)
                        .clickable {
                            goBack.invoke()
                        },
                    imageVector = Icons.AutoMirrored.Default.ArrowBack,
                    contentDescription = "Back",
                    tint = MaterialTheme.colorScheme.onBackground
                )
                Text(
                    text = "Line Chart",
                    style = LocalTextStyle.current.copy(
                        color = MaterialTheme.colorScheme.primary,
                        fontWeight = FontWeight.Bold,
                        fontSize = 24.sp
                    )
                )
            }
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier.fillMaxSize()
                .padding(paddingValues)
                .padding(vertical = 10.dp, horizontal = 20.dp)
                .verticalScroll(rememberScrollState()),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            var selectedDataPoint by remember {
                mutableStateOf<DataPoint?>(null)
            }
            var labelWidth by remember {
                mutableFloatStateOf(0f)
            }
            var totalChartWidth by remember {
                mutableFloatStateOf(0f)
            }
            val amountOfVisibleDataPoints = if (labelWidth > 0) {
                ((totalChartWidth - 2.5 * labelWidth) / labelWidth).toInt()
            } else {
                0
            }
            val startIndex = (coinHistory.lastIndex - amountOfVisibleDataPoints)
                .coerceAtLeast(0)

            LineChart(
                dataPoints = coinHistory,
                style = ChartStyle(
                    chartLineColor = MaterialTheme.colorScheme.primary,
                    unselectedColor = MaterialTheme.colorScheme.secondary.copy(
                        alpha = 0.3f
                    ),
                    selectedColor = MaterialTheme.colorScheme.primary,
                    helperLinesThicknessPx = 5f,
                    axisLinesThicknessPx = 5f,
                    labelFontSize = 14.sp,
                    minYLabelSpacing = 25.dp,
                    verticalPadding = 8.dp,
                    horizontalPadding = 8.dp,
                    xAxisLabelSpacing = 8.dp
                ),
                visibleDataPointsIndices = startIndex..coinHistory.lastIndex,
                unit = "$",
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 15.dp)
                    .aspectRatio(16 / 9f)
                    .onSizeChanged { totalChartWidth = it.width.toFloat() },
                selectedDataPoint = selectedDataPoint,
                onSelectedDataPoint = {
                    selectedDataPoint = it
                },
                onXLabelWidthChange = { labelWidth = it }
            )
        }
    }
}