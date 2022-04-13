package us.util.maldiveswhether.adaptor.out

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import us.util.maldiveswhether.adaptor.out.testdouble.SpyMaldivesWhetherDtoMapper
import us.util.maldiveswhether.adaptor.out.testdouble.SpyMeteorologicalAgencyClient
import java.time.LocalDate

internal class MaldivesMeteorologicalAgencyAdaptorTest {

    private lateinit var maldivesMeteorologicalAgencyAdaptor: MaldivesMeteorologicalAgencyAdaptor

    private lateinit var spyMeteorologicalAgencyClient: SpyMeteorologicalAgencyClient
    private lateinit var spyMaldivesWhetherDtoMapper: SpyMaldivesWhetherDtoMapper


    @BeforeEach
    fun setUp() {
        spyMeteorologicalAgencyClient = SpyMeteorologicalAgencyClient()
        spyMaldivesWhetherDtoMapper = SpyMaldivesWhetherDtoMapper()

        maldivesMeteorologicalAgencyAdaptor = MaldivesMeteorologicalAgencyAdaptor(
            meteorologicalAgencyClient = spyMeteorologicalAgencyClient,
            maldivesWhetherDtoMapper = spyMaldivesWhetherDtoMapper
        )
    }

    @Test
    fun getWhether_callsGetWhether_inMeteorologicalAgencyClient() {
        val dates = listOf(
            LocalDate.of(2022, 12, 21),
            LocalDate.of(2022, 12, 22),
            LocalDate.of(2022, 12, 23),
            LocalDate.of(2022, 12, 24),
            LocalDate.of(2022, 12, 25),
        )
        maldivesMeteorologicalAgencyAdaptor.getWhether(dates)

        assertThat(spyMeteorologicalAgencyClient.numberOfGetWhetherCalls).isEqualTo(dates.size)
    }

    @Test
    fun getWhether_callsMapByString_inMaldivesWhetherDtoMapper() {
        val dates = listOf(
            LocalDate.of(2022, 12, 21),
            LocalDate.of(2022, 12, 22),
            LocalDate.of(2022, 12, 23),
            LocalDate.of(2022, 12, 24),
            LocalDate.of(2022, 12, 25),
        )
        maldivesMeteorologicalAgencyAdaptor.getWhether(dates)

        assertThat(spyMaldivesWhetherDtoMapper.numberOfMapByStringCalls).isEqualTo(dates.size)
    }

}
