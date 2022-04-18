package us.util.maldiveswhether.adaptor.`in`.testdouble

import us.util.maldiveswhether.application.MaldivesWhetherService
import us.util.maldiveswhether.application.`in`.GetAverageRequest
import us.util.maldiveswhether.application.`in`.GetAverageResponse

class SpyMaldivesWhetherService: MaldivesWhetherService {

    override fun getAverage(getAverageRequest: GetAverageRequest): GetAverageResponse {
        TODO("Not yet implemented")
    }

}
