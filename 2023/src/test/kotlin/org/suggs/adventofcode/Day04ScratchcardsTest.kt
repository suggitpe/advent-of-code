package org.suggs.adventofcode

import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.suggs.adventofcode.Day04Scratchcards.addTotalWinningCardsFrom
import org.suggs.adventofcode.Day04Scratchcards.sumPowerUpScoreForEachCardFrom
import org.suggs.adventofcode.Util.getFileLinesFrom

@DisplayName("Scratchcards")
class Day04ScratchcardsTest {

    @Test
    fun `adds up fibonacci score for each card from small data`() {
        sumPowerUpScoreForEachCardFrom(smallData) shouldBe 13
    }

    @Test
    @Disabled
    fun `adds up fibonacci score for each card from large data`() {
        sumPowerUpScoreForEachCardFrom(largeData) shouldBe 123
    }

    @Test
    fun `adds up total cards based on wins for small data`() {
        addTotalWinningCardsFrom(smallData) shouldBe 30
    }

    @Test
    @Disabled
    fun `adds up total cards based on wins for large data`() {
        addTotalWinningCardsFrom(largeData) shouldBe 123
    }

    private val largeData = getFileLinesFrom("day04-input.txt")
    private val smallData = """Card 1: 41 48 83 86 17 | 83 86  6 31 17  9 48 53
Card 2: 13 32 20 16 61 | 61 30 68 82 17 32 24 19
Card 3:  1 21 53 59 44 | 69 82 63 72 16 21 14  1
Card 4: 41 92 73 84 69 | 59 84 76 51 58  5 54 83
Card 5: 87 83 26 28 32 | 88 30 70 12 93 22 82 36
Card 6: 31 18 13 56 72 | 74 77 10 23 35 67 36 11""".split("\n")
}