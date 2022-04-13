package us.util.maldiveswhether.application.out

import java.time.LocalDate

interface MaldivesMeteorologicalAgencyPort {

    fun getWhether(dates: List<LocalDate>): List<MaldivesWhetherDto>

}