package org.suggs.adventofcode

import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.suggs.adventofcode.Day10PipeMaze.lengthOfMaze
import org.suggs.adventofcode.Util.readFileAsString

@DisplayName("Pipe Maze")
class Day10PipeMazeTest {

    @Test
    fun `part 1 - measure furthest point from S in small grid`() {
        lengthOfMaze(smallData)/2 shouldBe 8
    }

    @Test
    @Disabled
    fun `part 1 - measure furthest point from S in large grid`() {
        lengthOfMaze(largeData)/2 shouldBe 123
    }

    private val largeData = readFileAsString("day10-input.txt")
    private val smallData = """..F7.
.FJ|.
SJ.L7
|F--J
LJ..."""
}