package org.suggs.aoc2024

import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.suggs.adventofcode.Grid
import org.suggs.adventofcode.Util.createGridFromFileContent
import org.suggs.aoc2024.Day04CeresSearch.countXmasWordsInGrid
import org.suggs.aoc2024.Day04CeresSearch.findCrossingMasInGrid

@DisplayName("Day 04 Ceres Search")
class Day04CeresSearchTest {

    @Test
    fun `find number of xmas's in small grid`() {
        countXmasWordsInGrid(smallData) shouldBe 18
    }

    @Test
    @Disabled
    fun `find number of xmas's in large grid`() {
        countXmasWordsInGrid(largeData) shouldBe 123
    }

    @Test
    fun `find number of crossing MAS in small grid`() {
        findCrossingMasInGrid(smallData) shouldBe 9
    }

    @Test
    @Disabled
    fun `find number of crossing MAS in large grid`() {
        findCrossingMasInGrid(largeData) shouldBe 123
    }

    private val largeData = createGridFromFileContent("day04-input.txt")
    private val smallData = Grid(
        """MMMSXXMASM
MSAMXMSMSA
AMXSXMAAMM
MSAMASMSMX
XMASAMXAMM
XXAMMXXAMA
SMSMSASXSS
SAXAMASAAA
MAMMMXMMMM
MXMXAXMASX"""
    )
}