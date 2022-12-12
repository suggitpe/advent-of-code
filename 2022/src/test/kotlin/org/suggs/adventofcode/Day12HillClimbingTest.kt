package org.suggs.adventofcode

import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.suggs.adventofcode.Day12HillClimbing.findShortestRouteToEnd
import org.suggs.adventofcode.Util.getFileLinesFrom

@DisplayName("")
class Day12HillClimbingTest {

    @Test
    fun `finds shortest path from start to end in large data`() =
        findShortestRouteToEnd(smallData) shouldBe 31

    @Test
    fun `finds shortest path from start to end in small data`() =
        findShortestRouteToEnd(largeData) shouldBe 1234


    private val largeData = getFileLinesFrom("day12-input.txt").map { it.toList()}
    private val smallData = """Sabqponm
abcryxxl
accszExk
acctuvwj
abdefghi""".split("\n").map { it.toList()}
}