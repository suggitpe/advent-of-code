package org.suggs.adventofcode

import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.suggs.adventofcode.Day07CamelCards.calculateCamelCardsValueFrom
import org.suggs.adventofcode.Util.getFileLinesFrom

@DisplayName("Camel Cards")
class Day07CamelCardsTest {

    @Test
    fun `part 1 - camel cards calculation from small data set`() {
        calculateCamelCardsValueFrom(smallData) shouldBe 6440
    }

    @Test
    @Disabled
    fun `part 1 - camel cards calculation from large data set`() {
        calculateCamelCardsValueFrom(largeData) shouldBe 123
    }

    private val largeData = getFileLinesFrom("day07-input.txt")

    private val smallData = """32T3K 765
T55J5 684
KK677 28
KTJJT 220
QQQJA 483""".split("\n")

}