package org.suggs.adventofcode

import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.suggs.adventofcode.Day06TuningTrouble.identifyMarkerLocationFrom
import org.suggs.adventofcode.Util.readFile

@DisplayName("Identified unique character combinations in a string")
class Day06TuningTroubleTest {

    @Test
    fun `identifies unique character markers in strings`() {
        identifyMarkerLocationFrom("bvwbjplbgvbhsrlpgdmjqwftvncz", 4) shouldBe 5
        identifyMarkerLocationFrom("nppdvjthqldpwncqszvftbrmjlhg", 4) shouldBe 6
        identifyMarkerLocationFrom("nznrnfrfntjfmvfwmzdfjlvtqnbhcprsg", 14) shouldBe 29
        identifyMarkerLocationFrom("zcfzfwzzqfrljwzlrfnpqdbhtmscgvjw", 14) shouldBe 26
    }

    @Test
    @Disabled
    fun `identifies unique character marker in large string`() {
        identifyMarkerLocationFrom(readFile("day06-input.txt").readText(), 14) shouldBe 1234
    }
}