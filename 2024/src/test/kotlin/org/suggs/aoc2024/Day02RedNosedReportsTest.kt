package org.suggs.aoc2024

import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.suggs.adventofcode.Util.getFileLinesFrom
import org.suggs.aoc2024.Day02RedNosedReports.countNumberOfDampenedSafeReportsFrom
import org.suggs.aoc2024.Day02RedNosedReports.countNumberOfSafeReportsFrom

@DisplayName("Day 02 Red-Nosed Reports")
class Day02RedNosedReportsTest {

    @Test
    fun `counts number of safe reports from a short list`() {
        countNumberOfSafeReportsFrom(smallData) shouldBe 2
    }

    @Test
    @Disabled
    fun `counts number of safe reports from a longer list`() {
        countNumberOfSafeReportsFrom(largeData) shouldBe 123
    }

    @Test
    fun `counts number of dampened safe reports from a short list`() {
        countNumberOfDampenedSafeReportsFrom(smallData) shouldBe 4
    }

    @Test
    @Disabled
    fun `counts number of dampened safe reports from a larger  list`() {
        countNumberOfDampenedSafeReportsFrom(largeData) shouldBe 123
    }

    private val largeData = getFileLinesFrom("day02-input.txt")
    private val smallData = """7 6 4 2 1
1 2 7 8 9
9 7 6 2 1
1 3 2 4 5
8 6 4 4 1
1 3 6 7 9""".split("\n")
}