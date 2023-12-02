package org.suggs.adventofcode

import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.suggs.adventofcode.Day02CubeConundrum.sumIdsOfValidGamesFrom
import org.suggs.adventofcode.Util.getFileLinesFrom

@DisplayName("Cube Conundrum")
class Day02CubeConundrumTest {

    @Test
    fun `sums the games ids of valid games from small data set`() {
        sumIdsOfValidGamesFrom(smallData) shouldBe 8
    }

    @Test
    @Disabled
    fun `sums the game ids of valid games using a large data set`() {
        sumIdsOfValidGamesFrom(largeData) shouldBe 123
    }

    private val largeData = getFileLinesFrom("day02-input.txt")

    private val smallData = """Game 1: 3 blue, 4 red; 1 red, 2 green, 6 blue; 2 green
Game 2: 1 blue, 2 green; 3 green, 4 blue, 1 red; 1 green, 1 blue
Game 3: 8 green, 6 blue, 20 red; 5 blue, 4 red, 13 green; 5 green, 1 red
Game 4: 1 green, 3 red, 6 blue; 3 green, 6 red; 3 green, 15 blue, 14 red
Game 5: 6 red, 1 blue, 3 green; 2 blue, 1 red, 2 green""".split("\n")

}