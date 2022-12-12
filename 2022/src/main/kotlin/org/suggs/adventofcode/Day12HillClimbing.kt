package org.suggs.adventofcode

import org.slf4j.LoggerFactory

object Day12HillClimbing {
    private val log = LoggerFactory.getLogger(this::class.java)

    // ====== DEPTH FIRST
    fun findShortestDepthFirstRouteToEnd(grid: List<List<Char>>): Int {
        val startEnd = findStartAndEndFrom(grid)
        log.debug("start=${startEnd.first} end=${startEnd.second}")
        return countStepsToEndFrom(startEnd.first, grid, setOf(), 0).min()
    }

    private fun countStepsToEndFrom(start: CoOrdinate, grid: List<List<Char>>, visited: Set<CoOrdinate>, stepCount: Int): List<Int> {
        val neighbours = findHigherNeighboursFrom(start, grid, visited).sortedByDescending { it.x }
        val foo = mutableListOf<Int>()
        neighbours.forEach {
            foo.addAll(countStepsToEndFrom(it, grid, visited + start, stepCount + 1))
        }
        return when {
            gridValue(start, grid) == 'E' -> listOf(stepCount) + foo
            else -> foo
        }
    }

    // ======= BREADTH FIRST
    fun findShortestBreadthFirstRouteToEnd(grid: List<List<Char>>): Int {
        val startEnd = findStartAndEndFrom(grid).also { log.debug("start=${it.first} end=${it.second}") }
        return plotRoutesFor(setOf(startEnd.first), setOf(), grid, 0)
    }

    private fun plotRoutesFor(coordinates: Set<CoOrdinate>, visited: Set<CoOrdinate>, grid: List<List<Char>>, depth: Int): Int {
        return when {
            coordinates.isEmpty() -> throw IllegalStateException("No more routes found after step $depth")
            coordinates.contains(findInGrid('E', grid)) -> depth
            else ->
                plotRoutesFor(coordinates.flatMap { findHigherNeighboursFrom(it, grid, visited) }.toSet(), visited union coordinates, grid, depth + 1)
        }
    }

    private fun findHigherNeighboursFrom(start: CoOrdinate, grid: List<List<Char>>, visited: Set<CoOrdinate>): Set<CoOrdinate> {
        return if (gridValue(start, grid).code == 'S'.code)
            start.allNeighbours()
        else
            start.allNeighbours()
                .filter { it.x < grid[0].size && it.y < grid.size }
                .filter { gridValue(it, grid) - gridValue(start, grid) in 0..1 || (gridValue(start, grid) == 'z' && gridValue(it, grid) == 'E') }
                .filterNot { visited.contains(it) }
                .toSet()
    }

    private fun gridValue(coordinate: CoOrdinate, grid: List<List<Char>>) =
        grid[coordinate.y][coordinate.x]

    private fun findStartAndEndFrom(grid: List<List<Char>>): Pair<CoOrdinate, CoOrdinate> =
        findInGrid('S', grid) to findInGrid('E', grid)

    private fun findInGrid(char: Char, grid: List<List<Char>>): CoOrdinate {
        val y = grid.indexOfFirst { it.contains(char) }
        return CoOrdinate(grid[y].indexOf(char), y)
    }

    data class CoOrdinate(val x: Int, val y: Int) {
        fun allNeighbours(): Set<CoOrdinate> {
            return setOf(up(), left(), right(), down()).filterNot { it.x < 0 || it.y < 0 }.toSet()
        }

        private fun up() = CoOrdinate(x, y - 1)
        private fun left() = CoOrdinate(x - 1, y)
        private fun right() = CoOrdinate(x + 1, y)
        private fun down() = CoOrdinate(x, y + 1)

        override fun toString() = "($x/$y)"
    }
}
