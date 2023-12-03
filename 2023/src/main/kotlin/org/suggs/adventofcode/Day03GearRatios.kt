package org.suggs.adventofcode

import org.slf4j.LoggerFactory

object Day03GearRatios {
    private val log = LoggerFactory.getLogger(this::class.java)

    fun sumAllNumbersWithAdjacentSymbolsFrom(data: String) =
        sumNumbersWithAdjacentSymbols(createGridFromString(data), Coordinate(0, 0))

    private fun sumNumbersWithAdjacentSymbols(grid: Array<CharArray>, coordinate: Coordinate): Int {
        log.debug("Checking $coordinate")
        if (endOfGrid(grid, coordinate)) { // end of grid
            return 0
        } else if (endOfRow(grid, coordinate)) {
            return sumNumbersWithAdjacentSymbols(grid, Coordinate(coordinate.x + 1, 0))
        }

        return if (grid[coordinate.x][coordinate.y].isDigit()) {
            val numberLen = getLengthOfNumberFrom(grid, coordinate, 1)
            log.debug("found a digit and its $numberLen long")
            sumNumbersWithAdjacentSymbols(grid, Coordinate(coordinate.x, coordinate.y + numberLen))
        } else {
            sumNumbersWithAdjacentSymbols(grid, Coordinate(coordinate.x, coordinate.y + 1))
        }
    }

    private fun getLengthOfNumberFrom(grid: Array<CharArray>, coordinate: Coordinate, accumulator: Int): Int {
        return if (endOfRow(grid, Coordinate(coordinate.x, coordinate.y + 1)) || !grid[coordinate.x][coordinate.y + 1].isDigit())
            accumulator
        else
            getLengthOfNumberFrom(grid, Coordinate(coordinate.x, coordinate.y + 1), accumulator + 1)
    }

    private fun endOfRow(grid: Array<CharArray>, coordinate: Coordinate) =
        coordinate.y >= grid[coordinate.x].size

    private fun endOfGrid(grid: Array<CharArray>, coordinate: Coordinate) =
        coordinate.x >= grid.size

    private fun createGridFromString(data: String) =
        data.split("\n").map { it.toCharArray() }.toTypedArray()

}

data class Coordinate(val y: Int, val x: Int) {
    fun right() = Coordinate(y + 1, x)
    fun left() = Coordinate(y - 1, x)
    fun up() = Coordinate(y, x - 1)
    fun down() = Coordinate(y, x + 1)
}