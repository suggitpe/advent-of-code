package org.suggs.aoc2024

import org.slf4j.LoggerFactory
import org.suggs.adventofcode.Coordinate
import kotlin.math.abs

object Day09MovieTheater {

    private val log = LoggerFactory.getLogger(this::class.java)

    fun findLargestRectangleFrom(coordinates: List<String>): Long =
        findLargestRectangleFrom(coordinates.map { it.split(",").let { xy -> Coordinate(xy[0].toInt(), xy[1].toInt()) } }, 0)

    private tailrec fun findLargestRectangleFrom(coordinates: List<Coordinate>, currentMax: Long): Long =
        if (coordinates.isEmpty()) currentMax
        else findLargestRectangleFrom(
            coordinates.drop(1),
            findMaxRectangleFrom(coordinates.first(), coordinates.drop(1), currentMax)
        )

    private fun findMaxRectangleFrom(topCoord: Coordinate, coordinates: List<Coordinate>, maxValue: Long): Long {
        var max = maxValue
        coordinates.forEach { coordinate ->
            rectangleSize(topCoord, coordinate).let {
                if (it > max) max = it
            }
        }
        return max
    }

    private fun rectangleSize(left: Coordinate, right: Coordinate): Long =
        abs(left.x - right.x + 1).toLong() * abs(left.y - right.y + 1).toLong()

}