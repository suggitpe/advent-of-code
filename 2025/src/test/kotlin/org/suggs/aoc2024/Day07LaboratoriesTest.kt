package org.suggs.aoc2024

import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test
import org.suggs.adventofcode.Grid
import org.suggs.adventofcode.Util.createGridFromFileContent
import org.suggs.aoc2024.Day07Laboratories.countSplitterEncountersFrom
import org.suggs.aoc2024.Day07Laboratories.findUniqueRoutesFor

class Day07LaboratoriesTest {

    @Test
    fun `counts the splitter encounters - very small`() {
        countSplitterEncountersFrom(verySmallGrid) shouldBe 3
    }

    @Test
    fun `counts the splitter encounters - small`() {
        countSplitterEncountersFrom(smallGrid) shouldBe 21
    }

    @Test
    @Disabled
    fun `counts the splitter encounters - large`() {
        countSplitterEncountersFrom(largeGrid) shouldBe 1234
    }

    @Test
    fun `counts the unique routes - very small`() {
        findUniqueRoutesFor(verySmallGrid) shouldBe 4L
    }

    @Test
    fun `counts the unique routes - small`() {
        findUniqueRoutesFor(smallGrid) shouldBe 40L
    }

    @Test
    @Disabled
    fun `counts the unique routes - large`() {
        findUniqueRoutesFor(largeGrid) shouldBe 1234L
    }

    private val largeGrid = createGridFromFileContent("day07-input.txt")

    private val verySmallGrid = Grid(""".......S.......
...............
.......^.......
...............
......^.^......
...............""")

    private val smallGrid = Grid(
        """.......S.......
...............
.......^.......
...............
......^.^......
...............
.....^.^.^.....
...............
....^.^...^....
...............
...^.^...^.^...
...............
..^...^.....^..
...............
.^.^.^.^.^...^.
............... """
    )
}