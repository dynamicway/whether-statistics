package us.util.maldiveswhether.application.`in`

class GetAverageResponse(
    val temp: Double,
    val windSpeed: Double,
    val humidity: Double,
    val barometer: Double,
    val precipitationProbability: Double,
    val whether: Map<String, Int> = mapOf()
)
