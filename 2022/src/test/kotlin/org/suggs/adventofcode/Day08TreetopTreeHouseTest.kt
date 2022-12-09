package org.suggs.adventofcode

import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test
import org.suggs.adventofcode.Day08TreetopTreeHouse.countAllVisibleTreesFrom

class Day08TreetopTreeHouseTest {

    @Test
    @Disabled
    fun `counts visible trees from small data`() {
        countAllVisibleTreesFrom(smallData) shouldBe 21
    }

    @Test
    @Disabled
    fun `counts visible trees from large data`() {
        countAllVisibleTreesFrom(largeData) shouldBe 21
    }

    private val largeData: List<List<Int>> = Util.getFileLinesFrom("day08-input.txt").map { it.toList().map { char -> char.code - 48 } }
    private val smallData: List<List<Int>> = """30373
25512
65332
33549
35390""".split("\n").map { it.toList().map { char -> char.code - 48 } }
}