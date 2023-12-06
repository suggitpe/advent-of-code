package org.suggs.adventofcode

import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.suggs.adventofcode.Day06WaitForIt.calculateMultipliedNumberOfWaysToWinRace
import org.suggs.adventofcode.Day06WaitForIt.calculateWinningRacesFromJoinedUpTimeDistance

@DisplayName("Wait for it")
class Day06WaitForItTest {

    @Test
    fun `calculate the number of ways you can wn the race from small dataset`() {
        calculateMultipliedNumberOfWaysToWinRace(smallData) shouldBe 288
    }

    @Test
    @Disabled
    fun `calculate the number of ways you can wn the race from large dataset`() {
        calculateMultipliedNumberOfWaysToWinRace(largeData) shouldBe 123
    }

    @Test
    fun `calc the number of ways you can do the huge race from small data`(){
        calculateWinningRacesFromJoinedUpTimeDistance(smallData) shouldBe 71503
    }

    @Test
    @Disabled
    fun `calc the number of ways you can do the huge race from large data`(){
        calculateWinningRacesFromJoinedUpTimeDistance(largeData) shouldBe 123
    }

    private val largeData = Util.getFileLinesFrom("day06-input.txt")
    private val smallData = """Time:      7  15   30
Distance:  9  40  200""".split("\n")

}