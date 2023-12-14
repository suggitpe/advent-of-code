package org.suggs.adventofcode

import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.suggs.adventofcode.Day11CosmicExpansion.GalaxyRoute
import org.suggs.adventofcode.Day11CosmicExpansion.sumAllGalaxyDistancesIn

@DisplayName("Cosmic Expansion")
class Day11CosmicExpansionTest {

    @Test
    fun `sum shortest paths between galaxies from small grid`() {
        sumAllGalaxyDistancesIn(smallGrid) shouldBe 374
    }

    @Test
    @Disabled
    fun `sum shortest paths between galaxies from large grid`() {
        sumAllGalaxyDistancesIn(largeGrid) shouldBe 123
    }

    @Test
    fun `calculates distances between coordinates`() {
        GalaxyRoute(Coordinate(0, 0), Coordinate(1, 1)).distance(listOf(), listOf()) shouldBe 2
        GalaxyRoute(Coordinate(1, 1), Coordinate(0, 0)).distance(listOf(), listOf()) shouldBe 2
        GalaxyRoute(Coordinate(1, 6), Coordinate(5, 11)).distance(listOf(), listOf()) shouldBe 9
        GalaxyRoute(Coordinate(6, 1), Coordinate(11, 5)).distance(listOf(), listOf()) shouldBe 9
    }

//    @Test
//    fun `can expand grid`() {
//        smallGrid.expand().toString() shouldBe """....#........
//.........#...
//#............
//.............
//.............
//........#....
//.#...........
//............#
//.............
//.............
//.........#...
//#....#......."""
//    }

    private val largeGrid = Util.createGridFromFileContent("day11-input.txt")

    private val smallGrid = Grid(
        """...#......
.......#..
#.........
..........
......#...
.#........
.........#
..........
.......#..
#...#....."""
    )

}