package org.suggs.adventofcode

import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.suggs.adventofcode.Day09RopeBridge.countTailPositionsFrom
import org.suggs.adventofcode.Util.getFileLinesFrom

@DisplayName("Tracks location of rop tail over map")
class Day09RopeBridgeTest {

    @Test
    @Disabled
    fun `counts all the rop tail positions from a small set of instructions`() =
        countTailPositionsFrom(smallData) shouldBe 13

    @Test
    @Disabled
    fun `counts all the rop tail positions from a larger set of instructions`() =
        countTailPositionsFrom(largeData) shouldBe 1234

    private val largeData = getFileLinesFrom("day09-input.txt")
    private val smallData = """R 4
U 4
L 3
D 1
R 4
D 1
L 5
R 2""".split("\n")
}