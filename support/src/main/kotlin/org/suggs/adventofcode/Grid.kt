package org.suggs.adventofcode

import org.slf4j.LoggerFactory

data class Grid(val grid: Array<CharArray>) {

    private val log = LoggerFactory.getLogger(this::class.java)

    companion object {
        operator fun invoke(gridData: String): Grid {
            return Grid(gridData.split("\n").map { it.toCharArray() }.toTypedArray())
        }
    }

    fun visualise() = grid.mapIndexed { idx, it -> log.debug("$idx: {}", it.joinToString("")) }


    fun updateGrid(point: Coordinate, char: Char) {
        grid[point.y][point.x] = char
    }

    fun valueOf(point: Coordinate): Char =
        if (point.x < 0 || point.y < 0 || point.y >= grid.size || point.x >= grid.first().size) '*'
        else grid[point.y][point.x]

    fun isEndOfGrid(coordinate: Coordinate) = coordinate.y >= grid.size

    fun isEndOfRow(coordinate: Coordinate) = coordinate.x >= grid[coordinate.y].size

    fun isOnGrid(coordinate: Coordinate): Boolean {
        return coordinate.x >= 0 &&
                coordinate.y >= 0 &&
                coordinate.x < grid[0].size &&
                coordinate.y < grid.size
    }
}