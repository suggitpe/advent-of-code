package org.suggs.adventofcode

import org.suggs.adventofcode.domain.VentLine

object Day05HydrothermalVenture {

    fun countNumberOfPointsThatIntersectMoreThanOnce(lineOfVents: List<VentLine>) =
        collectAllCoordinatesFrom(lineOfVents, listOf()).groupingBy { it }.eachCount().filter { it.value > 1 }.count()


    private fun collectAllCoordinatesFrom(lineOfVents: List<VentLine>, allCoordinates: List<Pair<Int, Int>>): List<Pair<Int, Int>> {
        return if (lineOfVents.isEmpty())
            allCoordinates
        else
            collectAllCoordinatesFrom(lineOfVents.drop(1), allCoordinates + lineOfVents.first().getAllCoordinatesInLine())
    }


}

