package us.util.maldiveswhether.domain

import java.time.LocalTime

class Whether(
    val time: LocalTime,
    val temp: Int,
    val humidity: Int,
    val barometer: Int,
    val whether: String
)
