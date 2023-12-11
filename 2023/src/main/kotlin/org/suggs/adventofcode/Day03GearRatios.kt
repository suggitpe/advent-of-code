package org.suggs.adventofcode

import org.slf4j.LoggerFactory

object Day03GearRatios {
    private val log = LoggerFactory.getLogger(this::class.java)

    fun sumAllNumbersWithAdjacentSymbolsFrom(data: String) =
        sumNumbersWithAdjacentSymbols(Grid(data), Coordinate(0, 0), 0)
            .also { log.debug("Part 1: $it") }

    private fun sumNumbersWithAdjacentSymbols(grid: Grid, coordinate: Coordinate, accumulator: Int = 0): Int {
        return if (grid.isEndOfGrid(coordinate)) accumulator
        else sumNumbersWithAdjacentSymbols(grid, coordinate.down(), accumulator + sumValuesForRow(grid, coordinate))
    }

    private fun sumValuesForRow(grid: Grid, coordinate: Coordinate, accumulator: Int = 0): Int {
        return if (grid.isEndOfRow(coordinate)) accumulator
        else if (grid.isNotDigit(coordinate)) sumValuesForRow(grid, coordinate.toTheRight(), accumulator)
        else {
            sumValuesForRow(grid, coordinate.toTheRight(grid.getLengthOfNumberFrom(coordinate)), accumulator + calculateValidPartNumber(grid, coordinate))
        }
    }

    private fun calculateValidPartNumber(grid: Grid, coordinate: Coordinate): Int {
        return if (!grid.isNumberAdjacentToSymbolAt(coordinate)) 0
        else grid.getNumberAt(coordinate)
    }

    fun sumAllGearRatios(data: String): Long {
        val coordinates = findAllNumbersWithGearSymbolFrom(Grid(data), Coordinate(0, 0), listOf<GearLocation>()).filter { it.gearCoordinates.size > 0 }
        val foo = coordinates.groupBy { it.gearCoordinates }.map { it.value }.filter { it.size > 1 }
        return foo.sumOf { it.map { oth -> oth.number }.reduce { acc, i -> acc * i } }.toLong()
            .also { log.debug("Part 2: $it") }
    }

    private fun findAllNumbersWithGearSymbolFrom(grid: Grid, coordinate: Coordinate, accumulator: List<GearLocation>): List<GearLocation> {
        return if (grid.isEndOfGrid(coordinate)) accumulator
        else findAllNumbersWithGearSymbolFrom(grid, coordinate.down(), accumulator + findAllGearedNumbersForRow(grid, coordinate, listOf()))
    }

    private fun findAllGearedNumbersForRow(grid: Grid, coordinate: Coordinate, accumulator: List<GearLocation>): List<GearLocation> {
        return if (grid.isEndOfRow(coordinate)) accumulator
        else if (grid.isNotDigit(coordinate)) findAllGearedNumbersForRow(grid, coordinate.toTheRight(), accumulator)
        else findAllGearedNumbersForRow(
            grid,
            coordinate.toTheRight(grid.getLengthOfNumberFrom(coordinate)),
            accumulator + createGearLocationFor(grid, coordinate)
        )
    }

    private fun createGearLocationFor(grid: Grid, coordinate: Coordinate): List<GearLocation> {
        val gearLocations = grid.gearLocationsForNumberAt(coordinate)
        return if (gearLocations.isEmpty()) listOf()
        else listOf(GearLocation(grid.getNumberAt(coordinate), gearLocations))
    }

    fun Grid.isDigit(coordinate: Coordinate) =
        grid[coordinate.y][coordinate.x].isDigit()

    fun Grid.isNotDigit(coordinate: Coordinate) =
        !isDigit(coordinate)

    fun Grid.isNotSymbol(coordinate: Coordinate) =
        isDigit(coordinate) || valueOf(coordinate) == '.'

    fun Grid.isSymbol(coordinate: Coordinate) =
        isNotDigit(coordinate) && valueOf(coordinate) != '.'

    fun Grid.isGear(coordinate: Coordinate): Boolean =
        valueOf(coordinate) == '*'

    fun Grid.getLengthOfNumberFrom(coordinate: Coordinate): Int {
        fun getLengthOfNumberFrom(coordinate: Coordinate, accumulator: Int): Int {
            return if (isEndOfRow(coordinate.toTheRight()) || isNotDigit(coordinate.toTheRight()))
                accumulator
            else
                getLengthOfNumberFrom(coordinate.toTheRight(), accumulator + 1)
        }
        return getLengthOfNumberFrom(coordinate, 1)
    }

    fun Grid.isNumberAdjacentToSymbolAt(coordinate: Coordinate): Boolean {
        return buildCoordinatesToTestFromNumberAt(coordinate).any { isOnGrid(it) && isSymbol(it) }
    }

    fun Grid.gearLocationsForNumberAt(coordinate: Coordinate): List<Coordinate> {
        return buildCoordinatesToTestFromNumberAt(coordinate).filter { isOnGrid(it) && isGear(it) }
    }

    private fun Grid.buildCoordinatesToTestFromNumberAt(coordinate: Coordinate) =
        coordinate.buildCoordinatesAround(coordinate, getLengthOfNumberFrom(coordinate))

    fun Grid.getNumberAt(coordinate: Coordinate): Int {
        fun getNumberAt(coordinate: Coordinate, length: Int): String {
            return if (length == 1)
                valueOf(coordinate).toString()
            else
                valueOf(coordinate).toString() + getNumberAt(coordinate.toTheRight(), length - 1)
        }
        return getNumberAt(coordinate, getLengthOfNumberFrom(coordinate)).toInt()
    }

    fun Coordinate.buildCoordinatesAround(coordinate: Coordinate, length: Int): List<Coordinate> {
        return listOf(coordinate.toTheLeft(), coordinate.toTheLeft().up(), coordinate.toTheLeft().down()) +
                listOf(coordinate.toTheRight(length), coordinate.toTheRight(length).up(), coordinate.toTheRight(length).down()) +
                buildListCoordinatesFrom(coordinate.up(), length) +
                buildListCoordinatesFrom(coordinate.down(), length)
    }

    fun Coordinate.buildListCoordinatesFrom(coordinate: Coordinate, length: Int = 1): List<Coordinate> {
        return if (length == 1)
            listOf(coordinate)
        else
            listOf(coordinate) + buildListCoordinatesFrom(coordinate.toTheRight(), length - 1)
    }

    fun Coordinate.toTheLeft(by: Int = 1) = Coordinate(x - by, y)
    fun Coordinate.toTheRight(by: Int = 1) = Coordinate(x + by, y)
    fun Coordinate.rowBelow() = Coordinate(0, y + 1)

}

data class GearLocation(val number: Int, val gearCoordinates: List<Coordinate>)

