package org.suggs.aoc2024

import org.slf4j.LoggerFactory
import org.suggs.adventofcode.Coordinate
import org.suggs.adventofcode.Grid

object Day04PrintingDepartment {
    private val log = LoggerFactory.getLogger(this::class.java)

    fun countPaperRollsWithFewerThanFourSpaces(grid: Grid): Int =
        grid.findAll('@').count { coordinateHasFewerThanFour(it, grid) }

    private fun coordinateHasFewerThanFour(coordinate: Coordinate, grid:Grid): Boolean =
        coordinateFreeSpaceCount(coordinate, grid) < 4

    private fun coordinateFreeSpaceCount(coordinate: Coordinate, grid: Grid): Int {
        return coordinatePaper(coordinate.up(), grid) +
                coordinatePaper(coordinate.down(), grid) +
                coordinatePaper(coordinate.left(), grid) +
                coordinatePaper(coordinate.right(), grid) +
                coordinatePaper(coordinate.upright(), grid) +
                coordinatePaper(coordinate.upleft(), grid) +
                coordinatePaper(coordinate.downleft(), grid) +
                coordinatePaper(coordinate.downright(), grid)
    }

    private fun coordinatePaper(coordinate: Coordinate, grid: Grid): Int{
        return if(!grid.isOnGrid(coordinate)) 0
        else if(grid.valueOf(coordinate) == '@') 1
        else 0
    }


}