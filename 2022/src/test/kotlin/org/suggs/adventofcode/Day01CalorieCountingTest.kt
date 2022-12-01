package org.suggs.adventofcode

import io.kotest.core.spec.style.ShouldSpec
import io.kotest.matchers.shouldBe
import org.suggs.adventofcode.Day01CalorieCounting.findMaxCaloriesFrom
import org.suggs.adventofcode.Day01CalorieCounting.findMaxCaloriesOfTopThreeFrom
import org.suggs.adventofcode.Util.getTextBlocksFrom

class Day01CalorieCountingTest : ShouldSpec({

    val smallData: List<String> = getTextBlocksFrom("day01-unit.txt")
    val largeData: List<String> = getTextBlocksFrom("day01-input.txt")

    context("Calculate calorie counts for a set of imaginary elves") {

        should("find the maximum calories for a small set of data") {
            findMaxCaloriesFrom(smallData) shouldBe 24000
        }

        should("find max calories from larger list") {
            findMaxCaloriesFrom(largeData) shouldBe 70720
        }

        should("find calorie count of top three from small list") {
            findMaxCaloriesOfTopThreeFrom(smallData) shouldBe 45000
        }

        should("find calorie count of top three from larger list") {
            findMaxCaloriesOfTopThreeFrom(largeData) shouldBe 207148
        }
    }

})