package org.suggs.adventofcode

import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.suggs.adventofcode.Day03BinaryDiagnostic.calculateCO2ScrubberRatingFrom
import org.suggs.adventofcode.Day03BinaryDiagnostic.calculateEpsilonFrom
import org.suggs.adventofcode.Day03BinaryDiagnostic.calculateGammaFrom
import org.suggs.adventofcode.Day03BinaryDiagnostic.calculateLifeSupportRatingFrom
import org.suggs.adventofcode.Day03BinaryDiagnostic.calculateOxygenGeneratorRatingFrom
import org.suggs.adventofcode.Day03BinaryDiagnostic.calculatePowerConsumptionFrom

@DisplayName("Diagnostic test should ... ")
class Day03BinaryDiagnosticTest {

    @Test
    fun `calculates gamma number from very small data set`() {
        calculateGammaFrom(verySmallDataSet) shouldBe 22
    }

    @Test
    fun `calculates epsilon number from very small data set`() {
        calculateEpsilonFrom(verySmallDataSet) shouldBe 9
    }

    @Test
    fun `calculation of powerConsumption from very small data set`() {
        calculatePowerConsumptionFrom(verySmallDataSet) shouldBe 198
    }

    @Test
    fun `calculation of powerConsumption from consumption file`() {
        calculatePowerConsumptionFrom(readDataSet) shouldBe 2595824
    }

    @Test
    fun `calculate oxygen generator from very small data set`() {
        calculateOxygenGeneratorRatingFrom(verySmallDataSet) shouldBe 23
    }

    @Test
    fun `calculate CO2 scrubber rating from a very small set`() {
        calculateCO2ScrubberRatingFrom(verySmallDataSet) shouldBe 10
    }

    @Test
    fun `calculate life support rating from a very small set`() {
        calculateLifeSupportRatingFrom(verySmallDataSet) shouldBe 230
    }

    @Test
    fun `calculate life support rating from consumption file`() {
        calculateLifeSupportRatingFrom(readDataSet) shouldBe 2135254
    }

    private val readDataSet = Util.createStringListFrom("day03-input.txt")

    private val verySmallDataSet: List<String> = """00100
11110
10110
10111
10101
01111
00111
11100
10000
11001
00010
01010""".split("\n")
}
