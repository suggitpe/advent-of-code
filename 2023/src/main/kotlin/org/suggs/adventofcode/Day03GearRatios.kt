package org.suggs.adventofcode

import org.slf4j.LoggerFactory

object Day03GearRatios {
    private val log = LoggerFactory.getLogger(this::class.java)

    fun sumAllNumbersWithAdjacentSymbolsFrom(data: String) =
        sumNumbersWithAdjacentSymbols(Grid(data), Coordinate(0, 0))

    private fun sumNumbersWithAdjacentSymbols(grid: Grid, coordinate: Coordinate): Int {

        if (grid.isEndOfGrid(coordinate)) {
            return 0
        } else if (grid.isEndOfRow(coordinate)) {
            return sumNumbersWithAdjacentSymbols(grid, Coordinate(0, coordinate.y + 1))
        }

        return if (grid.isNotDigit(coordinate)) {
            sumNumbersWithAdjacentSymbols(grid, coordinate.toTheRight())
        } else {
            sumNumbersWithAdjacentSymbols(grid, Coordinate(coordinate.x + grid.getLengthOfNumberFrom(coordinate), coordinate.y)) +
                    calculateValidPartNumber(grid, coordinate)
        }
    }

    private fun calculateValidPartNumber(grid: Grid, coordinate: Coordinate): Int {
        return if (grid.isNumberAdjacentToSymbolAt(coordinate))
            grid.getNumberAt(coordinate)
        else
            0
    }
}

data class Coordinate(val x: Int, val y: Int) {

    fun toTheLeft(by: Int = 1) = Coordinate(x - by, y)
    fun toTheRight(by: Int = 1) = Coordinate(x + by, y)
    fun above() = Coordinate(x, y - 1)
    fun below() = Coordinate(x, y + 1)
    fun buildCoordinatesAround(coordinate: Coordinate, length: Int): List<Coordinate> {
        return listOf(coordinate.toTheLeft(), coordinate.toTheLeft().above(), coordinate.toTheLeft().below()) +
                listOf(coordinate.toTheRight(length), coordinate.toTheRight(length).above(), coordinate.toTheRight(length).below()) +
                buildListCoordinatesFrom(coordinate.above(), length) +
                buildListCoordinatesFrom(coordinate.below(), length)
    }

    fun buildListCoordinatesFrom(coordinate: Coordinate, length: Int = 1): List<Coordinate> {
        return if (length == 1)
            listOf(coordinate)
        else
            listOf(coordinate) + buildListCoordinatesFrom(coordinate.toTheRight(), length -1)
    }

    override fun toString(): String {
        return "$x/$y"
    }
}

data class Grid(val grid: Array<CharArray>) {
    companion object {
        operator fun invoke(gridData: String): Grid {
            return Grid(gridData.split("\n").map { it.toCharArray() }.toTypedArray())
        }
    }

    fun isNumberAdjacentToSymbolAt(coordinate: Coordinate): Boolean {
        return buildCoordinatesToTestFromNumberAt(coordinate).any { isOnGrid(it) && isSymbol(it) }
    }

    private fun buildCoordinatesToTestFromNumberAt(coordinate: Coordinate) =
        coordinate.buildCoordinatesAround(coordinate, getLengthOfNumberFrom(coordinate))

    fun getNumberAt(coordinate: Coordinate): Int {
        fun getNumberAt(coordinate: Coordinate, length: Int): String {
            return if (length == 1)
                get(coordinate).toString()
            else
                get(coordinate).toString() + getNumberAt(coordinate.toTheRight(), length - 1)
        }
        return getNumberAt(coordinate, getLengthOfNumberFrom(coordinate)).toInt()
    }

    fun getLengthOfNumberFrom(coordinate: Coordinate): Int {
        fun getLengthOfNumberFrom(coordinate: Coordinate, accumulator: Int): Int {
            return if (isEndOfRow(coordinate.toTheRight()) || isNotDigit(coordinate.toTheRight()))
                accumulator
            else
                getLengthOfNumberFrom(coordinate.toTheRight(), accumulator + 1)
        }
        return getLengthOfNumberFrom(coordinate, 1)
    }

    fun get(coordinate: Coordinate) =
        grid[coordinate.y][coordinate.x]

    fun isOnGrid(coordinate: Coordinate): Boolean {
        return coordinate.x >= 0 &&
                coordinate.y >= 0 &&
                coordinate.x < grid[0].size &&
                coordinate.y < grid.size
    }

    fun isEndOfGrid(coordinate: Coordinate) =
        coordinate.y >= grid.size

    fun isEndOfRow(coordinate: Coordinate) =
        coordinate.x >= grid[coordinate.y].size

    fun isDigit(coordinate: Coordinate) =
        grid[coordinate.y][coordinate.x].isDigit()

    fun isNotDigit(coordinate: Coordinate) =
        !isDigit(coordinate)

    fun isNotSymbol(coordinate: Coordinate) =
        isDigit(coordinate) || get(coordinate) == '.'

    fun isSymbol(coordinate: Coordinate) =
        isNotDigit(coordinate) && get(coordinate) != '.'


}