package us.util.maldiveswhether.application.out

import java.time.LocalTime

class MaldivesWhetherDto(
    val time: LocalTime,
    val temp: Int,
    val windSpeed: Int,
    val humidity: Int,
    val barometer: Int,
    val whether: String
)