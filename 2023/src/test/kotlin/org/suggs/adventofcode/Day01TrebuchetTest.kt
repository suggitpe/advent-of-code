package org.suggs.adventofcode

import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

@DisplayName("Trebuchet?!")
class Day01TrebuchetTest {

    @Test
    fun `calculates calibration values from strings (small data)`() =
        Day01Trebuchet.calculateTotalCalibrationValuesFrom(smallData) shouldBe 142


    private val smallData = """1abc2
pqr3stu8vwx
a1b2c3d4e5f
treb7uchet"""
}