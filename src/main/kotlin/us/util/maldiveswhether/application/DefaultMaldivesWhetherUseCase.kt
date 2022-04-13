package us.util.maldiveswhether.application

import org.springframework.stereotype.Service
import us.util.maldiveswhether.application.`in`.GetAverageRequest
import us.util.maldiveswhether.application.`in`.GetAverageResponse

@Service
class DefaultMaldivesWhetherUseCase: MaldivesWhetherUseCase {

    override fun getAverage(getAverageRequest: GetAverageRequest): GetAverageResponse {
        TODO("Not yet implemented")
    }

}