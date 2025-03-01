package org.suggs.aoc2024

import org.slf4j.LoggerFactory
import org.suggs.adventofcode.Coordinate
import org.suggs.adventofcode.Direction
import org.suggs.adventofcode.Direction.UP
import org.suggs.adventofcode.Grid

object Day06GuardGallivant {

    private val log = LoggerFactory.getLogger(this::class.java)

    fun countStepsToReachEdgeOfGrid(grid: Grid): Int {
        grid.visualise()
        return countStepsToEdgeOfGrid(Pair(grid.findAll('^').first(), UP), grid, 1)
    }

    fun countStepsToEdgeOfGrid(current: Pair<Coordinate, Direction>, grid: Grid, accu: Int): Int {
        if (!grid.isOnGrid(current.first)) return accu
        return countStepsToEdgeOfGrid(grid.getNext(current), grid, accu + 1)
    }

    fun Grid.getNext(current: Pair<Coordinate, Direction>): Pair<Coordinate, Direction> {

    }


}