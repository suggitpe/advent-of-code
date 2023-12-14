package org.suggs.adventofcode

import org.slf4j.LoggerFactory
import kotlin.math.abs

object Day11CosmicExpansion {

    private val log = LoggerFactory.getLogger(this::class.java)

    fun sumAllGalaxyDistancesIn(grid: Grid): Int =
        findAllDistancesFromDiscreteCoordinatesIn(grid, grid.listRowsWithAllSameChar('.'), grid.listColumnsWithAllSameChar('.')).sum()
            .also { log.debug("Part 1: $it") }

    private fun findAllDistancesFromDiscreteCoordinatesIn(grid: Grid, rowsWithAllSameChar: List<Int>, columnsWithAllSameChar: List<Int>): List<Int> =
        createGalaxyRoutesFrom(grid.findAll('#'), listOf()).map { it.distance(rowsWithAllSameChar, columnsWithAllSameChar) }

    private fun createGalaxyRoutesFrom(coordinates: Set<Coordinate>, acc: List<GalaxyRoute>): List<GalaxyRoute> =
        if (coordinates.isEmpty()) acc
        else createGalaxyRoutesFrom(coordinates.drop(1).toSet(), acc + coordinates.drop(1).map { GalaxyRoute(coordinates.first(), it) }.toSet())

    private fun Grid.listRowsWithAllSameChar(char: Char): List<Int> {
        val rows = mutableListOf<Int>()
        rows().forEachIndexed { idx, row ->
            if (row.all { it == char })
                rows.add(idx)
        }
        return rows
    }

    private fun Grid.listColumnsWithAllSameChar(char: Char): List<Int> {
        val cols = mutableListOf<Int>()
        columns().forEachIndexed { idx, col ->
            if (col.all { it == '.' })
                cols.add(idx)
        }
        return cols
    }

    data class GalaxyRoute(val from: Coordinate, val to: Coordinate) {

        fun distance(rowsWithAllSameChar: List<Int>, columnsWithAllSameChar: List<Int>): Int {
            val xRange = if(from.x > to.x) to.x..from.x else from.x..to.x
            val yRange = if(from.y > to.y) to.y..from.y else from.y..to.y
            return (xRange.last - xRange.first) + xRange.filter { columnsWithAllSameChar.contains(it) }.size +
                    (yRange.last - yRange.first) + yRange.filter { rowsWithAllSameChar.contains(it) }.size
        }

    }

}