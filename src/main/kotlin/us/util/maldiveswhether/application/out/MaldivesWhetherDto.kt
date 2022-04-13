package us.util.maldiveswhether.application.out

import java.time.LocalTime

data class MaldivesWhetherDto(
    val time: LocalTime,
    val temp: Int,
    val humidity: Int,
    val barometer: Int,
    val whether: String
)