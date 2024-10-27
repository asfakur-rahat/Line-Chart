package com.ar.linechart

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform