package us.util.maldiveswhether.adaptor.out

import org.springframework.stereotype.Component
import us.util.maldiveswhether.application.out.MaldivesMeteorologicalAgencyPort
import us.util.maldiveswhether.application.out.MaldivesWhetherDto
import java.time.LocalDate

@Component
class MaldivesMeteorologicalAgencyAdaptor(
    private val meteorologicalAgencyClient: MeteorologicalAgencyClient
) : MaldivesMeteorologicalAgencyPort {

    override fun getWhether(dates: List<LocalDate>): List<MaldivesWhetherDto> {
        // dates에 존재하는 데이터로 client에 요청한다
        // 응답된 데이터를 MaldivesWhetherDto에 담는다
        // 반환한다
        TODO("Not yet implemented")
    }

}