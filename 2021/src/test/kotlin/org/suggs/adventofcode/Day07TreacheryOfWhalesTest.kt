package org.suggs.adventofcode

import io.kotest.matchers.ints.shouldBeInRange
import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.suggs.adventofcode.Day07TreacheryOfWhales.convergeToCommonNumberWithLeastCostUsingAdditiveCosting
import org.suggs.adventofcode.Day07TreacheryOfWhales.convergeToCommonNumberWithLeastCostUsingSimpleCosting

@DisplayName("Treachery of whales should ... ")
class Day07TreacheryOfWhalesTest {

    @Test
    fun `calculates the minimum simple cost to converge all numbers on a common number from a small data set`() =
        convergeToCommonNumberWithLeastCostUsingSimpleCosting(verySmallDataSet) shouldBe 37

    @Test
    fun `calculates the minimum simple cost to converge all numbers on a common number from a large data set`() =
        convergeToCommonNumberWithLeastCostUsingSimpleCosting(readDataSet) shouldBeInRange 341500..341600

    @Test
    fun `calculates the minimum additive cost to converge all numbers on a common number from a small data set`() =
        convergeToCommonNumberWithLeastCostUsingAdditiveCosting(verySmallDataSet) shouldBe 168

    @Test
    fun `calculates the minimum additive cost to converge all numbers on a common number from a large data set`() =
        convergeToCommonNumberWithLeastCostUsingAdditiveCosting(readDataSet) shouldBeInRange 93390000..93400000

    private val readDataSet: List<Int> = Util.getFileLinesFrom("day07-input.txt").first().split(",").map { it.toInt() }
    private val verySmallDataSet: List<Int> = """16,1,2,0,4,2,7,1,2,14""".split(",").map { it.toInt() }

}