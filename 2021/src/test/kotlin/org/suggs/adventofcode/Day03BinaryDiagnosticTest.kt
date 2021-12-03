package org.suggs.adventofcode

import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test
import org.slf4j.LoggerFactory
import org.suggs.adventofcode.Day03BinaryDiagnostic.calculateEpsilonFrom
import org.suggs.adventofcode.Day03BinaryDiagnostic.calculateGammaFrom
import org.suggs.adventofcode.Day03BinaryDiagnostic.calculatePowerConsumptionFrom

class Day03BinaryDiagnosticTest {

    companion object {
        private val log = LoggerFactory.getLogger(this::class.java)
    }

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
