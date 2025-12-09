package org.suggs.aoc2024

import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test
import org.suggs.adventofcode.Util.getFileLinesFrom

class Day09MovieTheaterTest {

    @Test
    fun `finds the largest rectangle from list of coordinates - small`(){
        Day09MovieTheater.findLargestRectangleFrom(smallData) shouldBe 50L
    }

    @Test
    @Disabled
    fun `finds the largest rectangle from list of coordinates - large`(){
        Day09MovieTheater.findLargestRectangleFrom(largeData) shouldBe 1234L
    }

    val largeData = getFileLinesFrom("day09-input.txt")
    val smallData = """7,1
11,1
11,7
9,7
9,5
2,5
2,3
7,3""".split("\n")
}