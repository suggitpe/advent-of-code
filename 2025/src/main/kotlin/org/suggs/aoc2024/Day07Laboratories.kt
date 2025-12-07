package org.suggs.aoc2024

import org.slf4j.LoggerFactory
import org.suggs.adventofcode.Coordinate
import org.suggs.adventofcode.Grid

object Day07Laboratories {
    private val log = LoggerFactory.getLogger(this::class.java)

    private var splitters = mutableSetOf<Coordinate>()
    private var coordinatesBeen = mutableSetOf<Coordinate>()

    fun countSplitterEncountersFrom(grid: Grid): Int {
        findSplittersFrom(grid, grid.findAll('S').first())
        return splitters.count()
    }

    private fun findSplittersFrom(grid: Grid, coord: Coordinate) {
        when {
            splitters.contains(coord) -> return
            grid.isNotOnGrid(coord) -> return
            grid.valueOf(coord) == 'S' -> findSplittersFrom(grid, coord.down())
            grid.valueOf(coord) == '.' -> findSplittersFrom(grid, coord.down())
            grid.valueOf(coord) == '^' -> {
                splitters.add(coord)
                findSplittersFrom(grid, coord.downleft())
                findSplittersFrom(grid, coord.downright())
            }

            else -> throw IllegalStateException()
        }
    }


    @JvmStatic
    fun findUniqueRoutesFor(grid: Grid): Long {
        val history = hashMapOf<Coordinate, Long>()
        return countUnique(grid, grid.findAll('S').first(), history)
    }

    fun countUnique(grid: Grid, pos: Coordinate, history: HashMap<Coordinate, Long>): Long {
        history[pos]?.let { return it }

        val next = pos.down()
        val result = when (grid.valueOf(next)) {
            '.' -> countUnique(grid, next, history)
            '^' -> countUnique(grid, pos.downleft(), history) + countUnique(grid, pos.downright(), history)
            else -> 1L
        }

        history[pos] = result
        return result
    }


}