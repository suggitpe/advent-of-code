package org.suggs.adventofcode

import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.suggs.adventofcode.Day08HauntedWasteland.countHopsInDataMap
import org.suggs.adventofcode.Day08HauntedWasteland.countHopsInDataMapForMultiHop
import org.suggs.adventofcode.Util.getTextBlocksFrom

@DisplayName("Haunted Wasteland")
class Day08HauntedWastelandTest {

    @Test
    fun `part 1 - count hops to finsh using small data`() {
        countHopsInDataMap(smallData1) shouldBe 6
    }

    @Test
    @Disabled
    fun `part 1 - count hops to finsh using large data`() {
        countHopsInDataMap(largeData) shouldBe 123
    }

    @Test
    fun `part 2 - count hops to finish for multi hop with small data`() {
        countHopsInDataMapForMultiHop(smallData2) shouldBe 6
    }

    @Test
    @Disabled
    fun `part 2 - count hops to finish for multi hop with large data`() {
        countHopsInDataMapForMultiHop(largeData) shouldBe 123
    }

    private val largeData = getTextBlocksFrom("day08-input.txt")

    private val smallData1 = """LLR

AAA = (BBB, BBB)
BBB = (AAA, ZZZ)
ZZZ = (ZZZ, ZZZ)""".split("\n\n")

    private val smallData2 = """LR

11A = (11B, XXX)
11B = (XXX, 11Z)
11Z = (11B, XXX)
22A = (22B, XXX)
22B = (22C, 22C)
22C = (22Z, 22Z)
22Z = (22B, 22B)
XXX = (XXX, XXX)""".split("\n\n")
}