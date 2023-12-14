package org.suggs.adventofcode

import org.slf4j.LoggerFactory
import kotlin.math.abs

object Day11CosmicExpansion {

    private val log = LoggerFactory.getLogger(this::class.java)

    fun sumAllGalaxyDistancesIn(grid: Grid): Int =
        findAllDistancesFromDiscreteCoordinatesIn(grid.expand()).sum()
            .also { log.debug("Part 1: $it") }

    private fun findAllDistancesFromDiscreteCoordinatesIn(grid: Grid): List<Int> =
        createGalaxyRoutesFrom(grid.findAll('#'), listOf()).map { it.distance() }

    private fun createGalaxyRoutesFrom(coordinates: Set<Coordinate>, acc: List<GalaxyRoute>): List<GalaxyRoute> =
        if (coordinates.isEmpty()) acc
        else createGalaxyRoutesFrom(coordinates.drop(1).toSet(), acc + coordinates.drop(1).map { GalaxyRoute(coordinates.first(), it) }.toSet())

    fun Grid.expand(): Grid = expandRows().expandColumns()

    private fun Grid.expandRows(): Grid {
        var newGridForRows = Grid.emptyGrid()
        rows().forEach { row ->
            newGridForRows = Grid(newGridForRows.appendRow(row))
            if (row.all { it == '.' })
                newGridForRows = Grid(newGridForRows.appendRow(CharArray(row.size) { '.' }))
        }
        return newGridForRows
    }

    private fun Grid.expandColumns(): Grid {
        val expandedColumns = mutableListOf<CharArray>()
        columns().forEach { column ->
            expandedColumns.add(column)
            if (column.all { it == '.' })
                expandedColumns.add(CharArray(column.size) { '.' })
        }
        val foo = Grid(expandedColumns.toTypedArray())
        val newGrid = mutableListOf<CharArray>()
        expandedColumns[0].forEachIndexed { idx, _ ->
            newGrid.add(foo.getColumnAt(idx))
        }
        return Grid(newGrid.toTypedArray())
    }

    data class GalaxyRoute(val from: Coordinate, val to: Coordinate) {
        fun distance(): Int = abs(to.x - from.x) + abs(to.y - from.y)
    }

}