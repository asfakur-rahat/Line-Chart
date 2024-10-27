package com.ar.linechart.presentation.home

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun HomeScreen(
    goToChartScreen: () -> Unit = {},
) {
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = {
            Box(
                modifier = Modifier.fillMaxWidth().height(64.dp),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = "Home Screen",
                    style = LocalTextStyle.current.copy(
                        color = MaterialTheme.colorScheme.primary,
                        fontWeight = FontWeight.Bold,
                        fontSize = 32.sp
                    )
                )
            }
        }
    ){ paddings ->
        Box(
            modifier = Modifier.fillMaxSize()
                .padding(paddings),
            contentAlignment = Alignment.Center
        ){
            Button(
                modifier = Modifier.fillMaxWidth()
                    .padding(horizontal = 20.dp),
                shape = RoundedCornerShape(20),
                onClick = {
                    goToChartScreen.invoke()
                }
            ){
                Text(text = "Go to Chart Screen")
            }
        }
    }
}