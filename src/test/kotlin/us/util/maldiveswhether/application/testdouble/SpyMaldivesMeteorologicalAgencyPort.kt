package us.util.maldiveswhether.application.testdouble

import us.util.maldiveswhether.application.out.MaldivesMeteorologicalAgencyPort
import us.util.maldiveswhether.application.out.MaldivesWhetherDto
import java.time.LocalDate

class SpyMaldivesMeteorologicalAgencyPort : MaldivesMeteorologicalAgencyPort {

    var getWhetherResult = listOf<MaldivesWhetherDto>()
    var getWhetherArguments = listOf<LocalDate>()

    override fun getWhether(dates: List<LocalDate>): List<MaldivesWhetherDto> {
        getWhetherArguments = dates
        return getWhetherResult
    }

}
