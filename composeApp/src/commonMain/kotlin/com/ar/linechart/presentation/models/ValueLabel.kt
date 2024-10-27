package com.ar.linechart.presentation.models

data class ValueLabel(
    val value: Float,
    val unit: String
){
    fun formatted(): String {
        return when{
            value >= 1000f -> {
                val integerPart = value.toInt()
                val formattedIntegerPart = integerPart.toString().reversed().chunked(3).joinToString(",").reversed()
                "$formattedIntegerPart $unit"
            }
            value >= 100f -> {
                val integerPart = value.toInt()
                val decimalPart = ((value - integerPart) * 100).toInt()
                "$integerPart.$decimalPart $unit"
            }
            else -> {
                val integerPart = value.toInt()
                val decimalPart = ((value - integerPart) * 1000).toInt()
                "$integerPart.$decimalPart $unit"
            }
        }
    }
}
