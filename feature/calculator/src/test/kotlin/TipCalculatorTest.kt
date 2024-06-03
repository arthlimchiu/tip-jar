import com.arthlimchiu.feature.calculator.tipcalculator.TipCalculator
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test
import java.math.BigDecimal
import kotlin.math.exp

class TipCalculatorTest {

    private lateinit var calculator: TipCalculator

    @Before
    fun setUp() {
        calculator = TipCalculator()
    }

    @Test
    fun computeTotalTip_shouldReturnZeroIfNumOfPeopleIsZero() {
        val expected = BigDecimal.ZERO
        val actual = calculator.computeTotalTip(BigDecimal(10.0), 0)

        assertEquals(expected, actual)
    }

    @Test
    fun computeTotalTip_shouldReturnAmountTimesNumOfPeople() {
        val expected = BigDecimal(50.0)
        val actual = calculator.computeTotalTip(BigDecimal(10.0), 5)

        assertEquals(expected, actual)
    }

    @Test
    fun computeTipPerPerson_shouldReturnZeroIfPercentageIsZero() {
        val expected = BigDecimal.ZERO
        val actual = calculator.computeTipPerPerson(BigDecimal(10.0), BigDecimal.ZERO)

        assertEquals(expected, actual)
    }

    @Test
    fun computeTipPerPerson_shouldReturnAPercentageOfTheAmount() {
        val expected = BigDecimal(10.0)
        val actual = calculator.computeTipPerPerson(BigDecimal(100.0), BigDecimal(10.0))

        assertEquals(expected, actual)
    }
}