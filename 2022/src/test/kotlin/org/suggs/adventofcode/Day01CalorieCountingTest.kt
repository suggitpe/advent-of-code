package org.suggs.adventofcode

import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test
import org.suggs.adventofcode.Day01CalorieCounting.findMaxCaloriesOfTopThreeFrom
import org.suggs.adventofcode.Day01CalorieCounting.findMaxCaloriesFrom
import org.suggs.adventofcode.Util.getTextBlocksFrom

class Day01CalorieCountingTest {

    @Test
    fun `find max calories from small list`() {
        findMaxCaloriesFrom(smallData) shouldBe 24000
    }

    @Test
    fun `find max calories from larger list`() {
        findMaxCaloriesFrom(largeData) shouldBe 70720
    }

    @Test
    fun `find calorie count of top three from small list`() {
        findMaxCaloriesOfTopThreeFrom(smallData) shouldBe 45000
    }

    @Test
    fun `find calorie count of top three from larger list`() {
        findMaxCaloriesOfTopThreeFrom(largeData) shouldBe 207148
    }

    private val largeData: List<String> = getTextBlocksFrom("day01-input.txt")

    private val smallData: List<String> = """1000
2000
3000

4000

5000
6000

7000
8000
9000

10000""".split("\n\n")

}