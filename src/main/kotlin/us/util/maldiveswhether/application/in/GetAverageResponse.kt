package us.util.maldiveswhether.application.`in`

data class GetAverageResponse(
    val temp: Double,
    val humidity: Double,
    val barometer: Double,
    val precipitationProbability: Double,
    val whether: Map<String, Int> = mapOf()
)
