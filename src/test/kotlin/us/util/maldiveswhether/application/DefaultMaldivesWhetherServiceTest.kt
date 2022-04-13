package us.util.maldiveswhether.application

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import us.util.maldiveswhether.application.`in`.GetAverageRequest
import us.util.maldiveswhether.application.`in`.GetAverageResponse
import us.util.maldiveswhether.application.out.MaldivesWhetherDto
import us.util.maldiveswhether.application.testdouble.SpyMaldivesMeteorologicalAgencyPort
import java.time.LocalDate
import java.time.LocalTime

internal class DefaultMaldivesWhetherServiceTest {

    private lateinit var defaultMaldivesWhetherService: DefaultMaldivesWhetherService

    private lateinit var spyMaldivesMeteorologicalAgencyPort: SpyMaldivesMeteorologicalAgencyPort

    @BeforeEach
    fun setUp() {
        spyMaldivesMeteorologicalAgencyPort = SpyMaldivesMeteorologicalAgencyPort()

        defaultMaldivesWhetherService = DefaultMaldivesWhetherService(
            maldivesMeteorologicalAgencyPort = spyMaldivesMeteorologicalAgencyPort
        )
    }

    @Test
    fun getAverage_callsGetWhether_inMaldivesMeteorologicalAgencyPort() {
        val dates = listOf(
            LocalDate.of(2022, 12, 24),
            LocalDate.of(2022, 12, 25),
            LocalDate.of(2022, 12, 26),
        )
        defaultMaldivesWhetherService.getAverage(GetAverageRequest(dates))

        assertThat(spyMaldivesMeteorologicalAgencyPort.getWhetherArguments).containsAnyElementsOf(dates)
    }

    @Test
    fun getAverage_result() {
        val maldivesWhetherDtos = listOf(
            MaldivesWhetherDto(
                time = LocalTime.of(0, 0),
                temp = 1,
                humidity = 10,
                barometer = 100,
                whether = "a"
            ),
            MaldivesWhetherDto(
                time = LocalTime.of(0, 0),
                temp = 2,
                humidity = 20,
                barometer = 200,
                whether = "a"
            ),
            MaldivesWhetherDto(
                time = LocalTime.of(0, 0),
                temp = 3,
                humidity = 30,
                barometer = 300,
                whether = "b"
            ),
            MaldivesWhetherDto(
                time = LocalTime.of(0, 0),
                temp = 4,
                humidity = 40,
                barometer = 400,
                whether = "c"
            ),
        )
        spyMaldivesMeteorologicalAgencyPort.getWhetherResult = maldivesWhetherDtos

        val getAverageResponse = defaultMaldivesWhetherService.getAverage(GetAverageRequest(listOf()))

        assertThat(getAverageResponse).isEqualTo(
            GetAverageResponse(
                temp = maldivesWhetherDtos.map { it.temp }.average(),
                humidity = maldivesWhetherDtos.map { it.humidity }.average(),
                barometer = maldivesWhetherDtos.map { it.barometer }.average(),
                precipitationProbability = (maldivesWhetherDtos.filter { it.whether.contains("rain") }.size * 100).div(
                    maldivesWhetherDtos.size.toDouble()
                ),
                mapOf(
                    "a" to 2,
                    "b" to 1,
                    "c" to 1
                )
            )
        )
    }

}