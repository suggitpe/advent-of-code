package org.suggs.adventofcode

import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.suggs.adventofcode.Day03GearRatios.sumAllNumbersWithAdjacentSymbolsFrom
import org.suggs.adventofcode.Util.getFileLinesFrom
import org.suggs.adventofcode.Util.readFileAsString

@DisplayName("Gear Ratios")
class Day03GearRatiosTest {

    @Test
    fun `adds all the numbers that have an adjacent symbol from a small set of data`() {
        sumAllNumbersWithAdjacentSymbolsFrom(smallData) shouldBe 4361
    }

    @Test
    @Disabled
    fun `adds all the numbers that have an adjacent symbol from a large set of data`() {
        sumAllNumbersWithAdjacentSymbolsFrom(largeData) shouldBe 123
    }


    val smallData = readFileAsString("day03-testdata.txt")
    val largeData = readFileAsString("day03-input.txt")

}