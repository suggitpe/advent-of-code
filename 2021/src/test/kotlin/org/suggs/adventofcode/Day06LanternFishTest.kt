package org.suggs.adventofcode

import io.kotest.matchers.ints.shouldBeInRange
import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test
import org.suggs.adventofcode.Day06LanternFish.calculateNumberOfFishFrom

class Day06LanternFishTest {

    @Test
    fun `calculates the number of fish after 80 days for a small set of fish`(){
        calculateNumberOfFishFrom(verySmallDataSet).after(80) shouldBe 5934
    }

    @Test
    fun `calculates the number of fish after 80 days for a large number of fish`(){
        calculateNumberOfFishFrom(readDataSet).after(80) shouldBeInRange 350000..355000
    }

    private val readDataSet: List<Int> = Util.getFileLinesFrom("day06-input.txt").first().split(",").map { it.toInt() }
    private val verySmallDataSet: List<Int> = """3,4,3,1,2""".split(",").map { it.toInt() }
}