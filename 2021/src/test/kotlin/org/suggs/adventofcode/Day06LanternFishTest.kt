package org.suggs.adventofcode

import io.kotest.matchers.longs.shouldBeInRange
import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test
import org.suggs.adventofcode.Day06LanternFish.calculateNumberOfFishFrom

class Day06LanternFishTest {

    @Test
    fun `calculate number of fish for a single fish`() {
        calculateNumberOfFishFrom(listOf(4)).after(10) shouldBe 2
    }

    @Test
    fun `calculates the number of fish after 80 days for a small set of fish`() {
        calculateNumberOfFishFrom(verySmallDataSet).after(80) shouldBe 5934
    }

    @Test
    fun `calculates the number of fish after 80 days for a large number of fish`() {
        calculateNumberOfFishFrom(readDataSet).after(80) shouldBeInRange 350000L..355000L
    }

    @Disabled
    @Test
    fun `calculates the number of fish after 256 days for a small set of fish`() {
        calculateNumberOfFishFrom(verySmallDataSet).after(256) shouldBe 26984457539
    }

    @Disabled
    @Test
    fun `calculates the number of fish after 256 days for a large number of fish`() {
        calculateNumberOfFishFrom(readDataSet).after(256) shouldBeInRange 350000L..355000L
    }

    private val readDataSet: List<Int> = Util.getFileLinesFrom("day06-input.txt").first().split(",").map { it.toInt() }
    private val verySmallDataSet: List<Int> = """3,4,3,1,2""".split(",").map { it.toInt() }
}