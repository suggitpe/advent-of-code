package org.suggs.aoc2024

import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.suggs.adventofcode.Grid
import org.suggs.adventofcode.Util.createGridFromFileContent
import org.suggs.aoc2024.Day06GuardGallivant.countStepsToReachEdgeOfGrid

@DisplayName("Day 06 Guard Gallivant")
class Day06GuardGallivantTest {

    @Test
    fun `counts steps to reach the edge of a small grid`() {
        countStepsToReachEdgeOfGrid(smallGrid) shouldBe 0
    }

    @Test
    @Disabled
    fun `counts steps to reach the edge of a large grid`() {
        countStepsToReachEdgeOfGrid(largeGrid) shouldBe 123
    }

    private val largeGrid = createGridFromFileContent("day06-input.txt")

    private val smallGrid = Grid(
        """....#.....
.........#
..........
..#.......
.......#..
..........
.#..^.....
........#.
#.........
......#..."""
    )
}