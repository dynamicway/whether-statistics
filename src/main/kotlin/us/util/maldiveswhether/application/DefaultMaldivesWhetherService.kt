package us.util.maldiveswhether.application

import org.springframework.stereotype.Service
import us.util.maldiveswhether.application.`in`.GetAverageRequest
import us.util.maldiveswhether.application.`in`.GetAverageResponse
import us.util.maldiveswhether.application.out.MaldivesMeteorologicalAgencyPort

@Service
class DefaultMaldivesWhetherService(
    private val maldivesMeteorologicalAgencyPort: MaldivesMeteorologicalAgencyPort
) : MaldivesWhetherService {

    override fun getAverage(getAverageRequest: GetAverageRequest): GetAverageResponse {
        val maldivesWhetherDtos = maldivesMeteorologicalAgencyPort.getWhether(getAverageRequest.dates)

        val whether = hashMapOf<String, Int>()

        maldivesWhetherDtos.forEach {
            whether[it.whether] = (whether[it.whether] ?: 0) + 1
        }

        return GetAverageResponse(
            temp = maldivesWhetherDtos.map { it.temp }.average(),
            humidity = maldivesWhetherDtos.map { it.humidity }.average(),
            barometer = maldivesWhetherDtos.map { it.barometer }.average(),
            precipitationProbability = (maldivesWhetherDtos.filter { it.whether.contains("rain") }.size * 100).div(
                maldivesWhetherDtos.size.toDouble()
            ),
            whether = whether
        )
    }

}