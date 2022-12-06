package org.suggs.adventofcode

import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.suggs.adventofcode.Day05SupplyStacks.calculateStackTopsFrom

@DisplayName("Pops things from one stack to another")
class Day05SupplyStacksTest {

    private val smallData: List<String> = Util.getTextBlocksFrom("day05-unit.txt")
    private val largeData: List<String> = Util.getTextBlocksFrom("day05-input.txt")

    @Test
    fun `calculates the top letters from stacks after popping from small data set`() =
        calculateStackTopsFrom(smallData, true) shouldBe "CMZ"

    @Test
    @Disabled
    fun `calculates the top letters from stacks after popping from larger data set`() =
        calculateStackTopsFrom(largeData, true) shouldBe "CMZ"

    @Test
    fun `calculates the top letters from stacks after shifting from small data set`() =
        calculateStackTopsFrom(smallData, false) shouldBe "MCD"

    @Test
    @Disabled
    fun `calculates the top letters from stacks after shifting from larger data set`() =
        calculateStackTopsFrom(largeData, false) shouldBe "MCD"
}