package org.suggs.aoc2024

import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.suggs.adventofcode.Util.getTextBlocksFrom
import org.suggs.aoc2024.Day05PrintQueue.correctIncorrectlyOrderedPrintJobsThenSumMedium
import org.suggs.aoc2024.Day05PrintQueue.extractMiddleNumberFrom
import org.suggs.aoc2024.Day05PrintQueue.sumMiddleNumbersFromValidPrintQueues

@DisplayName("Day 05 Pringt Queue")
class Day05PrintQueueTest {

    @Test
    fun `sums middle numbers from valid print queues in small data`() {
        sumMiddleNumbersFromValidPrintQueues(smallData) shouldBe 143
    }

    @Test
    @Disabled
    fun `sums middle numbers from valid print queues in large data`() {
        sumMiddleNumbersFromValidPrintQueues(largeData) shouldBe 123
    }

    @Test
    fun `can get middle element in a set`() {
        extractMiddleNumberFrom(listOf(0, 1, 2, 3, 4)) shouldBe 2
        extractMiddleNumberFrom(listOf(0, 1, 2)) shouldBe 1
    }

    @Test
    fun `corrects incorrectly ordered print jobs from small data`() {
        correctIncorrectlyOrderedPrintJobsThenSumMedium(smallData) shouldBe 123
    }

    @Test
    @Disabled
    fun `corrects incorrectly ordered print jobs from large data`() {
        correctIncorrectlyOrderedPrintJobsThenSumMedium(largeData) shouldBe 123
    }

    private val largeData = getTextBlocksFrom("day05-input.txt")
    private val smallData = """47|53
97|13
97|61
97|47
75|29
61|13
75|53
29|13
97|29
53|29
61|53
97|53
61|29
47|13
75|47
97|75
47|61
75|61
47|29
75|13
53|13

75,47,61,53,29
97,61,53,29,13
75,29,13
75,97,47,61,53
61,13,29
97,13,75,29,47""".split("\n\n")
}