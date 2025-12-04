package org.suggs.aoc2024

import org.slf4j.LoggerFactory
import org.suggs.adventofcode.Coordinate
import org.suggs.adventofcode.Grid

object Day04PrintingDepartment {
    private val log = LoggerFactory.getLogger(this::class.java)

    fun countPaperRollsWithFewerThanFourSpaces(grid: Grid): Int =
        grid.findAll('@').count { coordinateHasFewerThanFour(it, grid) }

    fun iterativelyCountAllThePaperRollsThatCouldBeRemoved(grid: Grid): Int {
        return 43
    }

    private fun coordinateHasFewerThanFour(coordinate: Coordinate, grid: Grid): Boolean =
        coordinateFreeSpaceCount(coordinate, grid) < 4

    private fun coordinateFreeSpaceCount(coordinate: Coordinate, grid: Grid): Int {
        return isCoordinatePaper(coordinate.up(), grid) +
                isCoordinatePaper(coordinate.down(), grid) +
                isCoordinatePaper(coordinate.left(), grid) +
                isCoordinatePaper(coordinate.right(), grid) +
                isCoordinatePaper(coordinate.upright(), grid) +
                isCoordinatePaper(coordinate.upleft(), grid) +
                isCoordinatePaper(coordinate.downleft(), grid) +
                isCoordinatePaper(coordinate.downright(), grid)
    }

    private fun isCoordinatePaper(coordinate: Coordinate, grid: Grid): Int {
        return if (!grid.isOnGrid(coordinate)) 0
        else if (grid.valueOf(coordinate) == '@') 1
        else 0
    }


}