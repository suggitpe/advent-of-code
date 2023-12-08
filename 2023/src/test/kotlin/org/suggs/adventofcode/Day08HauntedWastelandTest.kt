package org.suggs.adventofcode

import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.suggs.adventofcode.Day08HauntedWasteland.countHopsInDataMap
import org.suggs.adventofcode.Util.getTextBlocksFrom

@DisplayName("Haunted Wasteland")
class Day08HauntedWastelandTest {

    @Test
    fun `part 1 - count hops to finsh using small data`() {
        countHopsInDataMap(smallData) shouldBe 6
    }

    @Test
    fun `part 1 - count hops to finsh using large data`() {
        countHopsInDataMap(largeData) shouldBe 123
    }

    private val largeData = getTextBlocksFrom("day08-input.txt")

    private val smallData = """LLR

AAA = (BBB, BBB)
BBB = (AAA, ZZZ)
ZZZ = (ZZZ, ZZZ)""".split("\n\n")
}