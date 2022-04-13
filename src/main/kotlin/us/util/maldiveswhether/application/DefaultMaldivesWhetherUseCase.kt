package us.util.maldiveswhether.application

import org.springframework.stereotype.Service
import us.util.maldiveswhether.application.`in`.GetAverageRequest
import us.util.maldiveswhether.application.`in`.GetAverageResponse
import us.util.maldiveswhether.application.out.MaldivesMeteorologicalAgencyPort

@Service
class DefaultMaldivesWhetherUseCase(
    private val maldivesMeteorologicalAgencyPort: MaldivesMeteorologicalAgencyPort
): MaldivesWhetherUseCase {

    override fun getAverage(getAverageRequest: GetAverageRequest): GetAverageResponse {
        // 원하는 날짜들을 요청한다
        // 통계를 구한다
        // 반환한다
        TODO("Not yet implemented")
    }

}