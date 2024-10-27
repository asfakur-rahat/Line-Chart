package com.ar.linechart.domain.models

import kotlinx.datetime.LocalDateTime

data class CoinPrice(
    val priceUsd: Double,
    val dateTime: LocalDateTime,
)
