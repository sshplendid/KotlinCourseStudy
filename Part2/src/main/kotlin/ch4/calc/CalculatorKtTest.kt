package ch4.calc

import org.junit.Assert.*
import org.junit.Test

class CalculatorKtTest {

    @Test
    fun sum() {
        assertEquals(5, sum(3, 2))
    }

    @Test
    fun sub() {
        assertEquals(1, sub(3, 2))
    }

    @Test
    fun mul() {
        assertEquals(6, mul(3, 2))
    }

    @Test
    fun div() {
        assertEquals(2, div(4, 2))
    }
}