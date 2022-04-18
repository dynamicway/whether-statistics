package us.util.maldiveswhether.adaptor.`in`

import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController
import us.util.maldiveswhether.application.MaldivesWhetherService
import us.util.maldiveswhether.application.`in`.GetAverageRequest

@RestController
class MaldivesWhetherApi(
    private val maldivesWhetherService: MaldivesWhetherService
) {

    @PostMapping("/whether/maldives")
    fun getMaldivesWhether(
        @RequestBody getAverageRequest: GetAverageRequest
    ) = maldivesWhetherService.getAverage(getAverageRequest)

}