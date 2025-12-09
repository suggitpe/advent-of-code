package org.suggs.aoc2024

import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test
import org.slf4j.LoggerFactory
import org.suggs.adventofcode.Coordinate
import org.suggs.adventofcode.Grid
import org.suggs.adventofcode.Util.createGridFromFileContent
import org.suggs.aoc2024.Day07Laboratories.countSplitterEncountersFrom
import org.suggs.aoc2024.Day07Laboratories.findUniqueRoutesFor

class Day07LaboratoriesTest {

    private val log = LoggerFactory.getLogger(this::class.java)

    @Test
    fun `counts the splitter encounters - very small`() {
        countSplitterEncountersFrom(verySmallGrid) shouldBe 3
    }

    @Test
    @Disabled
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

    @Test
    @Disabled
    fun `let tests`(){
        val coord = Coordinate(1,1)
        val hash = mutableMapOf<Coordinate, Long>()
        hash[coord]?.let{log.debug("first $it ... should not run")}
        if(hash.containsKey(coord)){ log.debug("this should also not work")}
        hash[coord] = 4L
        hash[coord]?.let{log.debug("second $it should run")}
        if(hash.containsKey(coord)){ log.debug("this should work")}
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