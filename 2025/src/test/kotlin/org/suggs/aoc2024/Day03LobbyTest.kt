package org.suggs.aoc2024

import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test
import org.suggs.adventofcode.Util.getFileLinesFrom
import org.suggs.aoc2024.Day03Lobby.calculateTotalJoltageFrom

class Day03LobbyTest {

    @Test
    fun `calculates joltage from battery banks`() {
        calculateTotalJoltageFrom(smallData, 2) shouldBe 357
    }

    @Test
    @Disabled
    fun `calculates joltage from many battery banks`() {
        calculateTotalJoltageFrom(largeData, 2) shouldBe 1234L
    }

    @Test
    fun `calculates longer joltage from battery banks`() {
        calculateTotalJoltageFrom(smallData, 12) shouldBe 3121910778619
    }

    @Test
    @Disabled
    fun `calculates longer joltage from many battery banks`() {
        calculateTotalJoltageFrom(largeData, 12) shouldBe 1234L
    }

    private val largeData = getFileLinesFrom("day03-input.txt")
    private val smallData = """987654321111111
811111111111119
234234234234278
818181911112111""".split("\n")

}