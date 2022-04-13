package us.util.maldiveswhether.config

import org.springframework.cloud.openfeign.EnableFeignClients
import org.springframework.context.annotation.Configuration
import us.util.maldiveswhether.adaptor.out.MeteorologicalAgencyClient

@EnableFeignClients(basePackageClasses = [MeteorologicalAgencyClient::class])
@Configuration
class FeignConfig