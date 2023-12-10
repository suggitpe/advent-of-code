package org.suggs.adventofcode

import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.suggs.adventofcode.Day10PipeMaze.findInnerArea
import org.suggs.adventofcode.Day10PipeMaze.lengthOfMaze
import org.suggs.adventofcode.Util.readFileAsString

@DisplayName("Pipe Maze")
class Day10PipeMazeTest {

    @Test
    fun `part 1 - measure furthest point from S in small grid`() {
        lengthOfMaze(smallData1) / 2 shouldBe 8
    }

    @Test
    @Disabled
    fun `part 1 - measure furthest point from S in large grid`() {
        lengthOfMaze(largeData) / 2 shouldBe 123
    }

    @Test
    @Disabled
    fun `part 2 - find inner area of the loop from small grid`() {
        findInnerArea(smallData2) shouldBe 8
    }

    @Test
    @Disabled
    fun `part 2 - find inner area of the loop from another small grid`() {
        findInnerArea(smallData3) shouldBe 10
    }

    @Test
    @Disabled
    fun `part 2 - find inner area of the loop from large grid`() {
        findInnerArea(largeData) shouldBe 10
    }

    private val largeData = readFileAsString("day10-input.txt")
    private val smallData1 = """..F7.
.FJ|.
SJ.L7
|F--J
LJ..."""
    private val smallData2 = """.F----7F7F7F7F-7....
.|F--7||||||||FJ....
.||.FJ||||||||L7....
FJL7L7LJLJ||LJ.L-7..
L--J.L7...LJS7F-7L7.
....F-J..F7FJ|L7L7L7
....L7.F7||L7|.L7L7|
.....|FJLJ|FJ|F7|.LJ
....FJL-7.||.||||...
....L---J.LJ.LJLJ..."""

    private val smallData3 = """FF7FSF7F7F7F7F7F---7
L|LJ||||||||||||F--J
FL-7LJLJ||||||LJL-77
F--JF--7||LJLJ7F7FJ-
L---JF-JLJ.||-FJLJJ7
|F|F-JF---7F7-L7L|7|
|FFJF7L7F-JF7|JL---7
7-L-JL7||F7|L7F-7F7|
L.L7LFJ|||||FJL7||LJ
L7JLJL-JLJLJL--JLJ.L"""

}