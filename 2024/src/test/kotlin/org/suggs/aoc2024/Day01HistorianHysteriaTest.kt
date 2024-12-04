package org.suggs.aoc2024

import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.suggs.adventofcode.Util.getFileLinesFrom
import org.suggs.aoc2024.Day01HistorianHysteria.addListDistancesFor
import org.suggs.aoc2024.Day01HistorianHysteria.addSimilarityScoresFor

@DisplayName("Day 01 Historian Hysteria")
class Day01HistorianHysteriaTest {

    @Test
    fun `adds distances of paired numbers in small list`() {
        addListDistancesFor(smallData) shouldBe 11
    }

    @Test
    @Disabled
    fun `adds distances of paired numbers in large list`() {
        addListDistancesFor(largeData) shouldBe 123
    }

    @Test
    fun `calculate total similarity score in small list`() {
        addSimilarityScoresFor(smallData) shouldBe 31
    }

    @Test
    @Disabled
    fun `calculate total similarity score in large list`() {
        addSimilarityScoresFor(largeData) shouldBe 123
    }

    private val largeData = getFileLinesFrom("day01-input.txt")

    private val smallData = """3   4
4   3
2   5
1   3
3   9
3   3""".split("\n")
}