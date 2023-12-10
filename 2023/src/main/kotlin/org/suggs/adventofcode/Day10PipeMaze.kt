package org.suggs.adventofcode

import org.slf4j.LoggerFactory

object Day10PipeMaze {

    private val log = LoggerFactory.getLogger(this::class.java)

    private lateinit var grid: Grid
    private lateinit var start: Coordinate

    fun lengthOfMaze(gridData: String): Int {
        this.grid = Grid(gridData)
        this.start = grid.findStart()
        log.debug("starting from {}", start)
        return moveForwardFrom(start, listOf(), 0)
            .also { log.debug("Part 1: ${it / 2}") }
    }

    private tailrec fun moveForwardFrom(point: Coordinate, pointsBeen: List<Coordinate>, accum: Int): Int =
        if (point == start && pointsBeen.isNotEmpty()) accum
        else moveForwardFrom(grid.nextMoveFrom(point, pointsBeen), pointsBeen + point, accum + 1)

}

data class Grid(val grid: Array<CharArray>) {

    companion object {
        operator fun invoke(gridData: String): Grid {
            return Grid(gridData.split("\n").map { it.toCharArray() }.toTypedArray())
        }
    }

    fun nextMoveFrom(point: Coordinate, pointsBeen: List<Coordinate>): Coordinate {
        val possibleMoves = buildPossibleMovedFor(point).filterNot { pointsBeen.contains(it) }
        return if (possibleMoves.isEmpty()) // done a full maze loop
            pointsBeen.first() // start
        else
            possibleMoves.first() // next
    }

    private fun buildPossibleMovedFor(point: Coordinate): List<Coordinate> =
        when (valueOf(point)) {
            'S' -> listOf(firstMoveFrom(point))
            'J' -> listOf(point.left(), point.up())
            'F' -> listOf(point.right(), point.down())
            '7' -> listOf(point.left(), point.down())
            '|' -> listOf(point.up(), point.down())
            'L' -> listOf(point.right(), point.up())
            '-' -> listOf(point.left(), point.right())
            else -> throw IllegalStateException("No idea what to do with [${valueOf(point)}] at $point")
        }

    private fun firstMoveFrom(point: Coordinate): Coordinate {
        return if ("[|7F]".toRegex().containsMatchIn(valueOf(point.up()).toString()))
            point.up()
        else if ("[-J7]".toRegex().containsMatchIn(valueOf(point.right()).toString()))
            point.right()
        else if ("[|JL]".toRegex().containsMatchIn(valueOf(point.down()).toString()))
            point.down()
        else if ("[-FL]".toRegex().containsMatchIn(valueOf(point.left()).toString()))
            point.left()
        else
            throw java.lang.IllegalStateException("No idea how to start from $point")
    }

    fun findStart(): Coordinate {
        val y = grid.indexOfFirst { it.contains('S') }
        return Coordinate(grid[y].indexOf('S'), y)
    }

    private fun valueOf(point: Coordinate): Char {
        if (point.x < 0 || point.y < 0 || point.y >= grid.size || point.x >= grid.first().size) return '*'
        return grid[point.y][point.x]
    }
}

data class Coordinate(val x: Int, val y: Int) {

    override fun toString(): String {
        return "$x/$y"
    }

    fun up(): Coordinate = Coordinate(x, y - 1)
    fun down(): Coordinate = Coordinate(x, y + 1)
    fun left(): Coordinate = Coordinate(x - 1, y)
    fun right(): Coordinate = Coordinate(x + 1, y)
}

