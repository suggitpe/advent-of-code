package org.suggs.aoc2024

import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test
import org.suggs.adventofcode.Grid
import org.suggs.adventofcode.Util.createGridFromFileContent
import org.suggs.aoc2024.Day04PrintingDepartment.countPaperRollsWithFewerThanFourSpaces

class Day04PrintingDepartmentTest {

    @Test
    fun `counts the number of rolls of paper with less than four spaces surrounding - small`() {
        countPaperRollsWithFewerThanFourSpaces(smallData) shouldBe 13
    }

    @Test
    @Disabled
    fun `counts the number of rolls of paper with less than four spaces surrounding - large`() {
        countPaperRollsWithFewerThanFourSpaces(largeData) shouldBe 13
    }

    private val smallData = Grid(
        """..@@.@@@@.
@@@.@.@.@@
@@@@@.@.@@
@.@@@@..@.
@@.@@@@.@@
.@@@@@@@.@
.@.@.@.@@@
@.@@@.@@@@
.@@@@@@@@.
@.@.@@@.@."""
    )
    private val largeData = createGridFromFileContent("day04-input.txt")

}