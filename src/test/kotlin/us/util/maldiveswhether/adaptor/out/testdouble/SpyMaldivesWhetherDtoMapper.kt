package us.util.maldiveswhether.adaptor.out.testdouble

import us.util.maldiveswhether.adaptor.out.MaldivesWhetherDtoMapper
import us.util.maldiveswhether.application.out.MaldivesWhetherDto

class SpyMaldivesWhetherDtoMapper : MaldivesWhetherDtoMapper() {

    var mapByStringResult = listOf<MaldivesWhetherDto>()
    var numberOfMapByStringCalls = 0

    override fun mapByString(whetherString: String): List<MaldivesWhetherDto> {
        numberOfMapByStringCalls++
        return mapByStringResult
    }

}
