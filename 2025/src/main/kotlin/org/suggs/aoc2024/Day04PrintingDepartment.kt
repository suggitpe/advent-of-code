package org.suggs.aoc2024

import org.suggs.adventofcode.Coordinate
import org.suggs.adventofcode.Grid

object Day04PrintingDepartment {

    fun countPaperRollsWithFewerThanFourSpaces(grid: Grid): Int =
        grid.findAll('@').count { coordinateHasFewerThanFour(it, grid) }

    fun iterativelyCountAllThePaperRollsThatCouldBeRemoved(grid: Grid): Int =
        countTotalPossiblePaperRollsToRemove(grid, 999999, 0)

    private tailrec fun countTotalPossiblePaperRollsToRemove(grid: Grid, lastRemovalCount: Int, totalRemovalCount: Int): Int =

        if (lastRemovalCount == 0) totalRemovalCount
        else {
            val coordinatesToRemove = grid.findAll('@').filter { coordinateHasFewerThanFour(it, grid) }
            val updatedGrid = updateGrid(grid, coordinatesToRemove)
            countTotalPossiblePaperRollsToRemove(updatedGrid, coordinatesToRemove.count(), totalRemovalCount + coordinatesToRemove.count())
        }

    private fun updateGrid(grid: Grid, coordinatesToRemove: List<Coordinate>): Grid {
        val newGrid = grid.copy()
        coordinatesToRemove.forEach { grid.updateGrid(it, '.') }
        return newGrid
    }

    private fun coordinateHasFewerThanFour(coordinate: Coordinate, grid: Grid): Boolean =
        coordinateFreeSpaceCount(coordinate, grid) < 4

    private fun coordinateFreeSpaceCount(coordinate: Coordinate, grid: Grid): Int =
        isCoordinatePaper(coordinate.up(), grid) +
                isCoordinatePaper(coordinate.down(), grid) +
                isCoordinatePaper(coordinate.left(), grid) +
                isCoordinatePaper(coordinate.right(), grid) +
                isCoordinatePaper(coordinate.upright(), grid) +
                isCoordinatePaper(coordinate.upleft(), grid) +
                isCoordinatePaper(coordinate.downleft(), grid) +
                isCoordinatePaper(coordinate.downright(), grid)

    private fun isCoordinatePaper(coordinate: Coordinate, grid: Grid): Int =
        if (!grid.isOnGrid(coordinate)) 0
        else if (grid.valueOf(coordinate) == '@') 1
        else 0
}