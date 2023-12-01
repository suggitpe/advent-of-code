package org.suggs.adventofcode

import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.suggs.adventofcode.Day01Trebuchet.calculateTotalCalibrationValuesFromDigitsAndStringsIn
import org.suggs.adventofcode.Day01Trebuchet.calculateTotalCalibrationValuesFromDigitsIn

@DisplayName("Trebuchet?!")
class Day01TrebuchetTest {

    @Test
    fun `calculates calibration values from digits (small data)`() {
        calculateTotalCalibrationValuesFromDigitsIn(smallData) shouldBe 142
    }

    @Test
    @Disabled
    fun `calculates calibration values from digits (large data)`() {
        calculateTotalCalibrationValuesFromDigitsIn(largeData) shouldBe 123
    }

    @Test
    fun `calculates calibration values from digits and strings (small data)`() {
        calculateTotalCalibrationValuesFromDigitsAndStringsIn(otherSmallData) shouldBe 281
    }

    @Test
    fun `calculates calibration values from digits and strings (large data)`() {
        calculateTotalCalibrationValuesFromDigitsAndStringsIn(largeData) shouldBe 123
    }


    private val largeData = Util.getFileLinesFrom("day01-input.txt")

    private val smallData = """1abc2
pqr3stu8vwx
a1b2c3d4e5f
treb7uchet""".split("\n")

    private val otherSmallData = """two1nine
eightwothree
abcone2threexyz
xtwone3four
4nineeightseven2
zoneight234
7pqrstsixteen""".split("\n")
}
