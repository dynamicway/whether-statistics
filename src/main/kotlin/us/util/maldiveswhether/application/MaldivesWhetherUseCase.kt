package us.util.maldiveswhether.application

import us.util.maldiveswhether.application.`in`.GetAverageRequest
import us.util.maldiveswhether.application.`in`.GetAverageResponse

interface MaldivesWhetherUseCase {

    fun getAverage(getAverageRequest: GetAverageRequest): GetAverageResponse

}
