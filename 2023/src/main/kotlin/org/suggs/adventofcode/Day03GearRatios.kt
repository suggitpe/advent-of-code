package org.suggs.adventofcode

import org.slf4j.LoggerFactory

object Day03GearRatios {
    private val log = LoggerFactory.getLogger(this::class.java)

    fun sumAllNumbersWithAdjacentSymbolsFrom(data: String) =
        sumNumbersWithAdjacentSymbols(createGridFromString(data), Coordinate(0, 0))

    private fun sumNumbersWithAdjacentSymbols(grid: Array<CharArray>, coordinate: Coordinate): Int {
        if (endOfGrid(grid, coordinate)) {
            return 0
        } else if (endOfRow(grid, coordinate)) {
            return sumNumbersWithAdjacentSymbols(grid, Coordinate(0, coordinate.y + 1))
        }

        return if (!grid[coordinate.y][coordinate.x].isDigit()) {
            sumNumbersWithAdjacentSymbols(grid, coordinate.toTheRight())
        } else {
            val numberLen = getLengthOfNumberFrom(grid, coordinate, 1)
            sumNumbersWithAdjacentSymbols(grid, Coordinate(coordinate.x + numberLen, coordinate.y)) +
                    calculateValidPartNumber(grid, coordinate, numberLen)
        }
    }

    private fun calculateValidPartNumber(grid: Array<CharArray>, coordinate: Coordinate, length: Int): Int {
        return if (symbolAdjacentTo(coordinate, grid, length))
            createNumberFromArrayCharsAt(grid, coordinate, length).toInt()
        else
            0
    }

    private fun symbolAdjacentTo(coordinate: Coordinate, grid: Array<CharArray>, length: Int): Boolean {
        return true
    }

    private fun isSymbol(coordinate: Coordinate, grid: Array<CharArray>): Boolean{
        return !(grid[coordinate.y][coordinate.x].isDigit() || grid[coordinate.y][coordinate.x] == '.')
    }

    private fun createNumberFromArrayCharsAt(grid: Array<CharArray>, coordinate: Coordinate, numberLen: Int): String {
        return if (numberLen == 1)
            grid[coordinate.y][coordinate.x].toString()
        else
            grid[coordinate.y][coordinate.x].toString() + createNumberFromArrayCharsAt(grid, coordinate.toTheRight(), numberLen - 1)
    }

    private fun getLengthOfNumberFrom(grid: Array<CharArray>, coordinate: Coordinate, accumulator: Int): Int {
        return if (endOfRow(grid, coordinate.toTheRight()) || !grid[coordinate.y][coordinate.x + 1].isDigit())
            accumulator
        else
            getLengthOfNumberFrom(grid, coordinate.toTheRight(), accumulator + 1)
    }

    private fun endOfRow(grid: Array<CharArray>, coordinate: Coordinate) =
        coordinate.x >= grid[coordinate.y].size

    private fun endOfGrid(grid: Array<CharArray>, coordinate: Coordinate) =
        coordinate.y >= grid.size

    private fun createGridFromString(data: String) =
        data.split("\n").map { it.toCharArray() }.toTypedArray()

}

data class Coordinate(val x: Int, val y: Int) {
    fun toTheRight() = Coordinate(x + 1, y)
}

data class Grid(val grid: Array<CharArray>){
    companion object {
        operator fun invoke(gridData: String): Grid {
            return Grid(gridData.split("\n").map { it.toCharArray() }.toTypedArray())
        }
    }

}