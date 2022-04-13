package us.util.maldiveswhether.adaptor.out

import org.springframework.stereotype.Component
import us.util.maldiveswhether.application.out.MaldivesMeteorologicalAgencyPort
import us.util.maldiveswhether.application.out.MaldivesWhetherDto
import java.time.LocalDate

@Component
class MaldivesMeteorologicalAgencyAdaptor(
    private val meteorologicalAgencyClient: MeteorologicalAgencyClient,
    private val maldivesWhetherDtoMapper: MaldivesWhetherDtoMapper
) : MaldivesMeteorologicalAgencyPort {

    override fun getWhether(dates: List<LocalDate>): List<MaldivesWhetherDto> {

        val maldivesWhetherDtos = mutableListOf<MaldivesWhetherDto>()

        dates.forEach {
            val whetherString = meteorologicalAgencyClient.getWhether(it, it.dayOfMonth, it.dayOfYear)
            maldivesWhetherDtos.addAll(maldivesWhetherDtoMapper.mapByString(whetherString))
        }
        return maldivesWhetherDtos
    }

}