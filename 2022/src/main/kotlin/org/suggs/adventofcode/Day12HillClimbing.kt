package org.suggs.adventofcode

import org.slf4j.LoggerFactory

object Day12HillClimbing {
    private val log = LoggerFactory.getLogger(this::class.java)

    fun findShortestRouteToEnd(grid: List<List<Char>>): Int {
        val startEnd = findStartAndEndFrom(grid)
        log.debug("start=${startEnd.first} end=${startEnd.second}")
        return countStepsToEndFrom(startEnd.first, grid, listOf(), 0).min()
    }

    private fun countStepsToEndFrom(start: CoOrdinate, grid: List<List<Char>>, visited: List<CoOrdinate>, stepCount: Int): List<Int> {
        val neighbours = findHigherNeighboursFrom(start, grid).filterNot { visited.contains(it) }.sortedByDescending { it.x }
        var foo = mutableListOf<Int>()
        neighbours.forEach {
            foo.addAll(countStepsToEndFrom(it, grid, visited + start, stepCount + 1))
        }
        if(gridValue(start, grid) == 'E')
            log.debug("Found a route in $stepCount")
        return when {
            gridValue(start, grid) == 'E' -> listOf(stepCount) + foo
            else -> foo
        }
    }

    private fun findHigherNeighboursFrom(start: CoOrdinate, grid: List<List<Char>>): List<CoOrdinate> {
        return if (gridValue(start, grid).code == 'S'.code)
            start.allNeighbours()
        else
            start.allNeighbours()
                .filter { it.x < grid[0].size && it.y < grid.size }
                .filter { gridValue(it, grid) - gridValue(start, grid) in 0..1 || (gridValue(start, grid) == 'z' && gridValue(it, grid) == 'E') }
    }

    private fun gridValue(coord: CoOrdinate, grid: List<List<Char>>) =
        grid[coord.y][coord.x]

    private fun findStartAndEndFrom(grid: List<List<Char>>): Pair<CoOrdinate, CoOrdinate> =
        findInGrid('S', grid) to findInGrid('E', grid)

    private fun findInGrid(char: Char, grid: List<List<Char>>): CoOrdinate {
        val y = grid.indexOfFirst { it.contains(char) }
        return CoOrdinate(grid[y].indexOf(char), y)
    }

    data class CoOrdinate(val x: Int, val y: Int) {
        fun allNeighbours(): List<CoOrdinate> {
            return listOf(up(), left(), right(), down()).filterNot { it.x < 0 || it.y < 0 }
        }

        private fun up() = CoOrdinate(x, y - 1)
        private fun left() = CoOrdinate(x - 1, y)
        private fun right() = CoOrdinate(x + 1, y)
        private fun down() = CoOrdinate(x, y + 1)

        override fun toString() = "($x/$y)"
    }
}
