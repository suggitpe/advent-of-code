package org.suggs.adventofcode

import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.suggs.adventofcode.Day01CalorieCounting.findMaxCaloriesFrom
import org.suggs.adventofcode.Day01CalorieCounting.findMaxCaloriesOfTopThreeFrom
import org.suggs.adventofcode.Util.getTextBlocksFrom

@DisplayName("Calculate calorie counts for a set of imaginary elves")
class Day01CalorieCountingTest {

    @Test
    fun `max calories for a small set of data`() =
        findMaxCaloriesFrom(smallData) shouldBe 24000

    @Test
    @Disabled
    fun `max calories from larger list`() =
        findMaxCaloriesFrom(largeData) shouldBe 24000

    @Test
    fun `calorie count of top three from small list`() =
        findMaxCaloriesOfTopThreeFrom(smallData) shouldBe 45000

    @Test
    @Disabled
    fun `calorie count of top three from larger list`() =
        findMaxCaloriesOfTopThreeFrom(largeData) shouldBe 45000

    private val largeData: List<String> = getTextBlocksFrom("day01-input.txt")
    private val smallData: List<String> =
        """1000
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