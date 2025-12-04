package org.suggs.aoc2024

import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test
import org.suggs.adventofcode.Grid
import org.suggs.adventofcode.Util.createGridFromFileContent
import org.suggs.aoc2024.Day04PrintingDepartment.countPaperRollsWithFewerThanFourSpaces
import org.suggs.aoc2024.Day04PrintingDepartment.iterativelyCountAllThePaperRollsThatCouldBeRemoved

class Day04PrintingDepartmentTest {

    @Test
    fun `counts the number of rolls of paper with less than four spaces surrounding - small`() {
        countPaperRollsWithFewerThanFourSpaces(smallData) shouldBe 13
    }

    @Test
    @Disabled
    fun `counts the number of rolls of paper with less than four spaces surrounding - large`() {
        countPaperRollsWithFewerThanFourSpaces(largeData) shouldBe 1234
    }

    @Test
    fun `iteratively counts the number of rolls of paper that could be removed - small`() {
        iterativelyCountAllThePaperRollsThatCouldBeRemoved(smallData) shouldBe 43
    }

    @Test
    @Disabled
    fun `iteratively counts the number of rolls of paper that could be removed - large`() {
        iterativelyCountAllThePaperRollsThatCouldBeRemoved(largeData) shouldBe 1234
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