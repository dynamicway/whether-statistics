package us.util.maldiveswhether.adaptor.out

import org.springframework.cloud.openfeign.FeignClient
import org.springframework.format.annotation.DateTimeFormat
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import java.time.LocalDate

@FeignClient(name = "meteorologicalAgency", url = "https://www.timeanddate.com")
interface MeteorologicalAgencyClient {

    @GetMapping("/scripts/cityajax.php?n=maldives/male&mode=historic&hd={date}&month={month}&year={year}&json=1")
    fun getWhether(
        @DateTimeFormat(pattern = "yyyyMMdd")
        @PathVariable date: LocalDate,
        @PathVariable month: Int,
        @PathVariable year: Int
    ): String

}