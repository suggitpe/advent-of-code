package org.suggs.adventofcode

import org.slf4j.LoggerFactory

object Day10PipeMaze {

    private val log = LoggerFactory.getLogger(this::class.java)

    private lateinit var grid: Grid
    private lateinit var start: Coordinate

    fun lengthOfMaze(gridData: String): Int {
        this.grid = Grid(gridData)
        this.start = grid.findStart()
        return mapMazeLoopFrom(start, listOf()).size
            .also { log.debug("Part 1: ${it / 2}") }
    }

    private tailrec fun mapMazeLoopFrom(point: Coordinate, pointsBeen: List<Coordinate>): List<Coordinate> =
        if (point == start && pointsBeen.isNotEmpty()) pointsBeen
        else mapMazeLoopFrom(grid.nextMoveFrom(point, pointsBeen), pointsBeen + point)

    /*
     * TODO: To solve this, you can follow simple algo of
     * 1. Clean out all points that are not part of the maze (delete the noise)
     * 2. Update the maze to track direction of vertical nodes
     * 3. Then you can track on a line by line basis the how deep into the maze you are
     *  - if you find a '.' at depth zero then you know you are outside
     *  - if you find a . at depth >0 then you know you are inner
     */
    fun findInnerArea(gridData: String): Int {
        this.grid = Grid(gridData)
        this.start = grid.findStart()
        val mazeLoop = mapMazeLoopFrom(start, listOf())
        log.debug("${mazeLoop.size}")
        grid.visualise()
        grid.removeAllNoiseFromGrid(mazeLoop)
        grid.visualise()
        grid.markAllInnerPoints()
        grid.visualise()
        return -1
    }

}

data class Grid(val grid: Array<CharArray>) {

    private val log = LoggerFactory.getLogger(this::class.java)

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

    private fun firstMoveFrom(point: Coordinate): Coordinate =
        if ("[|7F]".toRegex().containsMatchIn(valueOf(point.up()).toString())) point.up()
        else if ("[-J7]".toRegex().containsMatchIn(valueOf(point.right()).toString())) point.right()
        else if ("[|JL]".toRegex().containsMatchIn(valueOf(point.down()).toString())) point.down()
        else if ("[-FL]".toRegex().containsMatchIn(valueOf(point.left()).toString())) point.left()
        else throw java.lang.IllegalStateException("No idea how to start from $point")


    fun findStart(): Coordinate {
        val y = grid.indexOfFirst { it.contains('S') }
        return Coordinate(grid[y].indexOf('S'), y)
    }

    private fun valueOf(point: Coordinate): Char =
        if (point.x < 0 || point.y < 0 || point.y >= grid.size || point.x >= grid.first().size) '*'
        else grid[point.y][point.x]

    fun visualise() {
        grid.mapIndexed { idx, it -> log.debug("$idx: {}", it.joinToString("")) }
    }

    fun updateGrid(point: Coordinate, char: Char) {
        grid[point.y][point.x] = char
    }

    fun removeAllNoiseFromGrid(mazeLoop: List<Coordinate>) {
        grid.forEachIndexed { lineIdx, line ->
            line.forEachIndexed { rowIdx, _ ->
                val point = Coordinate(rowIdx, lineIdx)
                if (!mazeLoop.contains(point))
                    updateGrid(point, '.')
            }
        }
    }

    fun markAllInnerPoints() {
        grid.forEachIndexed { lineIdx, line ->
            var insideDepth = 0
            line.forEachIndexed { rowIdx, _ ->
                val point = Coordinate(rowIdx, lineIdx)
                if (valueOf(point) == '.') {
                    if (insideDepth == 0) updateGrid(point, 'O')
                    else updateGrid(point, 'I')
                }
                else if(listOf('|', 'F', 'L').contains(valueOf(point)))
                    insideDepth ++
                else if (listOf('|', 'J', '7').contains(valueOf(point)))
                    insideDepth--
            }
        }
    }

}

data class Coordinate(val x: Int, val y: Int) {

    override fun toString(): String = "$x/$y"
    fun up(): Coordinate = Coordinate(x, y - 1)
    fun down(): Coordinate = Coordinate(x, y + 1)
    fun left(): Coordinate = Coordinate(x - 1, y)
    fun right(): Coordinate = Coordinate(x + 1, y)
}

