package us.util.maldiveswhether.adaptor.`in`

import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.get
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get
import org.springframework.test.web.servlet.setup.MockMvcBuilders
import us.util.maldiveswhether.adaptor.`in`.testdouble.SpyMaldivesWhetherService

internal class MaldivesWhetherApiTest {

    private val mockMvc: MockMvc by lazy { MockMvcBuilders.standaloneSetup(maldivesWhetherApi).build() }

    private lateinit var maldivesWhetherApi: MaldivesWhetherApi

    private lateinit var spyMaldivesWhetherService: SpyMaldivesWhetherService

    @BeforeEach
    fun setUp() {
        spyMaldivesWhetherService = SpyMaldivesWhetherService()

        maldivesWhetherApi = MaldivesWhetherApi(
            maldivesWhetherService = spyMaldivesWhetherService
        )
    }

    @Test
    fun getMaldivesWhether_status_isOk() {
        mockMvc.perform(get("/whether/maldives")
        )
    }

}