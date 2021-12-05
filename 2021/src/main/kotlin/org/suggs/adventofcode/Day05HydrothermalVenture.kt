package org.suggs.adventofcode

import org.slf4j.LoggerFactory
import org.suggs.adventofcode.domain.VentLine

object Day05HydrothermalVenture {

    private val log = LoggerFactory.getLogger(this::class.java)

    fun countNumberOfPointThatIntersectMoreThanOnce(lineOfVents: List<VentLine>): Int {
        return collectAllCoordinatesFrom(lineOfVents.filter { !it.isDiagonal() }, listOf()).groupingBy { it }.eachCount().filter { it.value > 1 }.count()
    }

    private fun collectAllCoordinatesFrom(lineOfVents: List<VentLine>, allCordinadtes: List<Pair<Int, Int>>): List<Pair<Int, Int>> {
        return if (lineOfVents.isEmpty())
            allCordinadtes
        else
            collectAllCoordinatesFrom(lineOfVents.drop(1), allCordinadtes + lineOfVents.first().getAllCoordinatesInLine())
    }

}

