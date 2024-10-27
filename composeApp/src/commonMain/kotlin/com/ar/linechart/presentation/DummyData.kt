package com.ar.linechart.presentation

import com.ar.linechart.domain.models.CoinPrice
import kotlinx.datetime.Instant
import kotlinx.datetime.LocalDateTime
import kotlinx.datetime.TimeZone
import kotlinx.datetime.toLocalDateTime

val coinPriceList = listOf(
    CoinPrice(priceUsd = 67523.29447277206, dateTime = (1729576800000).toLocalDateTime()),
    CoinPrice(priceUsd = 67272.22310470518, dateTime = (1729598400000).toLocalDateTime()),
    CoinPrice(priceUsd = 67286.23402934878, dateTime = (1729620000000).toLocalDateTime()),
    CoinPrice(priceUsd = 67382.22828172974, dateTime = (1729641600000).toLocalDateTime()),
    CoinPrice(priceUsd = 67036.92114081097, dateTime = (1729663200000).toLocalDateTime()),
    CoinPrice(priceUsd = 66377.70960296805, dateTime = (1729684800000).toLocalDateTime()),
    CoinPrice(priceUsd = 65687.46443379475, dateTime = (1729706400000).toLocalDateTime()),
    CoinPrice(priceUsd = 66649.78342202902, dateTime = (1729728000000).toLocalDateTime()),
    CoinPrice(priceUsd = 67302.88653961633, dateTime = (1729749600000).toLocalDateTime()),
    CoinPrice(priceUsd = 67215.96514736777, dateTime = (1729771200000).toLocalDateTime()),
    CoinPrice(priceUsd = 67630.49991339970, dateTime = (1729792800000).toLocalDateTime()),
    CoinPrice(priceUsd = 68159.99987552392, dateTime = (1729814400000).toLocalDateTime()),
    CoinPrice(priceUsd = 67731.15536088530, dateTime = (1729836000000).toLocalDateTime()),
    CoinPrice(priceUsd = 68057.90470192365, dateTime = (1729857600000).toLocalDateTime()),
    CoinPrice(priceUsd = 67059.76680416442, dateTime = (1729879200000).toLocalDateTime()),
    CoinPrice(priceUsd = 66543.83911408066, dateTime = (1729900800000).toLocalDateTime()),
    CoinPrice(priceUsd = 67072.29629051982, dateTime = (1729922400000).toLocalDateTime()),
    CoinPrice(priceUsd = 67076.22145136475, dateTime = (1729944000000).toLocalDateTime()),
    CoinPrice(priceUsd = 67003.78994690187, dateTime = (1729965600000).toLocalDateTime()),
    CoinPrice(priceUsd = 67062.26297458902, dateTime = (1729987200000).toLocalDateTime())
    //CoinPrice(priceUsd = 333.26297458902, dateTime = Instant.fromEpochMilliseconds(1729987200000))
)

private fun Long.toLocalDateTime(timeZone: String = "Asia/Dhaka"): LocalDateTime {
    val instant = Instant.fromEpochMilliseconds(this)
    return instant.toLocalDateTime(TimeZone.of(timeZone))
}