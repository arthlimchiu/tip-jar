import com.arthlimchiu.utils.date.ext.formatDateString
import com.arthlimchiu.utils.date.ext.toDefaultFormat
import org.junit.Assert.assertEquals
import org.junit.Test
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

class DateFormatterTest {

    @Test
    fun toDefaultFormat_shouldReturnInISOLocalDateTimeFormat() {
        val expected = "2024-06-03T16:23:33.416987"
        val dateTime = LocalDateTime.parse(expected, DateTimeFormatter.ISO_LOCAL_DATE_TIME)

        val actual = dateTime.toDefaultFormat()

        assertEquals(expected, actual)
    }

    @Test
    fun formatDateString_shouldReturnStringInYearFullMonthDayFormat() {
        val expected = "2024 June 03"
        val actual = "2024-06-03T16:23:33.416987".formatDateString()

        assertEquals(expected, actual)
    }
}