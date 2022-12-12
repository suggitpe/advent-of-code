package org.suggs.adventofcode

import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.suggs.adventofcode.Day12HillClimbing.findShortestBreadthFirstRouteToEnd
import org.suggs.adventofcode.Day12HillClimbing.findShortestDepthFirstRouteToEnd
import org.suggs.adventofcode.Util.getFileLinesFrom

@DisplayName("Hill climbing fiasco")
class Day12HillClimbingTest {

    @Test
    fun `finds shortest path in small data using depth first algo`() =
        findShortestDepthFirstRouteToEnd(smallData) shouldBe 31

    @Test
    fun `finds shortest path in small data using breadth first algo`() =
        findShortestBreadthFirstRouteToEnd(smallData) shouldBe 31

    @Test
    @Disabled
    fun `finds shortest path in large data using breadth first algo`() =
        findShortestBreadthFirstRouteToEnd(largeData) shouldBe 31


    private val largeData = getFileLinesFrom("day12-input.txt").map { it.toList() }
    private val smallData = """Sabqponm
abcryxxl
accszExk
acctuvwj
abdefghi""".split("\n").map { it.toList() }
}