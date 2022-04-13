package us.util.maldiveswhether.adaptor.out

import org.springframework.stereotype.Component
import us.util.maldiveswhether.application.out.MaldivesWhetherDto
import java.time.LocalTime

@Component
class MaldivesWhetherDtoMapper {

    fun mapByString(whetherString: String): List<MaldivesWhetherDto> {
        val hFields = getHFields(extractHFields(whetherString))
        return hFields.map { MaldivesWhetherDto(
            time = it.key,
            temp = it.value[1].substring(it.value[1].indexOf('"') + 1, it.value[1].indexOf('&')).toInt(),
            humidity = it.value[5].substring(it.value[5].indexOf('"') + 1, it.value[5].indexOf('%')).toInt(),
            barometer = it.value[6].substring(it.value[6].indexOf('"') + 1, it.value[6].indexOfLast { it == ' ' }).toInt(),
            whether = it.value[2].substring(it.value[2].indexOf('"') + 1, it.value[2].length)
        ) }
    }

    private fun getHFields(hFields: List<String>): HashMap<LocalTime, MutableList<String>> {
        val map = hashMapOf<LocalTime, MutableList<String>>()

        val regex = """\d\d:\d\d""".toRegex()
        var currentHour = LocalTime.of(23, 59)
        hFields.forEach {
            regex.find(it)?.let {
                val value = it.value
                val time = LocalTime.of(value.substring(0, 2).toInt(), value.substring(3, 5).toInt())
                if (time != currentHour) {
                    currentHour = time
                    map[currentHour] = mutableListOf()
                }
            } ?: map[currentHour]!!.add(it)
        }
        return map
    }

    private fun extractHFields(whetherString: String): List<String> {
        val hFields = mutableListOf<String>()

        var currentIndex = 0
        var hField = false
        whetherString.forEachIndexed { index, c ->
            if (c == 'h') {
                currentIndex = index
                hField = true
            }
            if (c == '}' && hField) {
                hFields.add(whetherString.substring(currentIndex, index))
                hField = false
            }
        }
        return hFields
    }

}