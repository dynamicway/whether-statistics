package us.util.maldiveswhether.adaptor.out.testdouble

import us.util.maldiveswhether.adaptor.out.MeteorologicalAgencyClient
import java.time.LocalDate

class SpyMeteorologicalAgencyClient : MeteorologicalAgencyClient {

    var numberOfGetWhetherCalls: Int = 0

    override fun getWhether(date: LocalDate, month: Int, year: Int): String {
        numberOfGetWhetherCalls++
        return ""
    }

}
