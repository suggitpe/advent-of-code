package org.suggs.aoc2024

import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test
import org.suggs.adventofcode.Util.getTextBlocksFrom
import org.suggs.aoc2024.Day05Cafeteria.countTotalFreshIngredientsFrom
import org.suggs.aoc2024.Day05Cafeteria.countValidIngredientsFrom

class Day05CafeteriaTest {

    @Test
    fun `counts the number of valid ingredients based on ranges of ingredient ids - small data`() {
        countValidIngredientsFrom(smallData) shouldBe 3
    }

    @Test
    @Disabled
    fun `counts the number of valid ingredients based on ranges of ingredient ids - large data`() {
        countValidIngredientsFrom(largeData) shouldBe 1234
    }

    @Test
    fun `counts the total number of fresh ingredients - small data`() {
        countTotalFreshIngredientsFrom(smallData.first()) shouldBe 14L
    }

    @Test
    @Disabled
    fun `counts the total number of fresh ingredients - large data`() {
        countTotalFreshIngredientsFrom(largeData.first()) shouldBe 1234L
    }

    private val smallData = """3-5
10-14
16-20
12-18

1
5
8
11
17
32""".split("\n\n")
    private val largeData = getTextBlocksFrom("day05-input.txt")
}