package org.suggs.adventofcode

import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.suggs.adventofcode.Day01CalorieCounting.findMaxCaloriesFrom
import org.suggs.adventofcode.Day01CalorieCounting.findMaxCaloriesOfTopThreeFrom
import org.suggs.adventofcode.Util.getTextBlocksFrom

@DisplayName("Calculate calorie counts for a set of imaginary elves")
class Day01CalorieCountingTest {

    private val smallData: List<String> = getTextBlocksFrom("day01-unit.txt")
    private val largeData: List<String> = getTextBlocksFrom("day01-input.txt")

    @Test
    fun `max calories for a small set of data`() =
        findMaxCaloriesFrom(smallData) shouldBe 24000

    @Test
    fun `max calories from larger list`() =
        findMaxCaloriesFrom(largeData) shouldBe 70720

    @Test
    fun `calorie count of top three from small list`() =
        findMaxCaloriesOfTopThreeFrom(smallData) shouldBe 45000

    @Test
    fun `calorie count of top three from larger list`() =
        findMaxCaloriesOfTopThreeFrom(largeData) shouldBe 207148
}