package org.suggs.adventofcode

import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test
import org.suggs.adventofcode.Day02RockPaperScissors.playRockPaperScissorsWith
import org.suggs.adventofcode.Util.getFileLinesFrom

class Day02RockPaperScissorsTest {

    private val smallData: List<String> = getFileLinesFrom("day02-unit.txt")
    private val largeData: List<String> = getFileLinesFrom("day02-input.txt")

    @Test
    fun `play rock paper scissors with small data`() =
        playRockPaperScissorsWith(smallData) shouldBe 15


    @Test
    fun `play rock paper scissors with larger data`() =
        playRockPaperScissorsWith(largeData) shouldBe 12458

}