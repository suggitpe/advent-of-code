package org.suggs.adventofcode

import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.suggs.adventofcode.Day01Trebuchet.calculateTotalCalibrationValuesFrom

@DisplayName("Trebuchet?!")
class Day01TrebuchetTest {

    @Test
    fun `calculates calibration values from strings (small data)`() {
        calculateTotalCalibrationValuesFrom(smallData) shouldBe 142
    }

    @Test
    fun `calculates calibration values from external data`() {
        calculateTotalCalibrationValuesFrom(largeData) shouldBe 123
    }


    private val largeData = Util.getFileLinesFrom("day01-input.txt")
    private val smallData = """1abc2
pqr3stu8vwx
a1b2c3d4e5f
treb7uchet""".split("\n")
}
