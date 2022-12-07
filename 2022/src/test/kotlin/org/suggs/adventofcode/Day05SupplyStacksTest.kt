package org.suggs.adventofcode

import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.suggs.adventofcode.Day05SupplyStacks.calculateStackTopsFrom
import org.suggs.adventofcode.Util.getTextBlocksFrom

@DisplayName("Pops things from one stack to another")
class Day05SupplyStacksTest {



    @Test
    fun `calculates the top letters from stacks after popping from small data set`() =
        calculateStackTopsFrom(unitData, true) shouldBe "CMZ"

    @Test
    @Disabled
    fun `calculates the top letters from stacks after popping from larger data set`() =
        calculateStackTopsFrom(largeData, true) shouldBe "CMZ"

    @Test
    fun `calculates the top letters from stacks after shifting from small data set`() =
        calculateStackTopsFrom(unitData, false) shouldBe "MCD"

    @Test
    @Disabled
    fun `calculates the top letters from stacks after shifting from larger data set`() =
        calculateStackTopsFrom(largeData, false) shouldBe "MCD"

    private val largeData: List<String> = getTextBlocksFrom("day05-input.txt")
    private val unitData = """    [D]
[N] [C]
[Z] [M] [P]
 1   2   3

move 1 from 2 to 1
move 3 from 1 to 3
move 2 from 2 to 1
move 1 from 1 to 2""".split("\n\n")
}