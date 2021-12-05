package org.suggs.adventofcode.domain

data class VentLine(private val startCoordinate: Pair<Int, Int>, private val endCoordinate: Pair<Int, Int>) {

    companion object {
        private fun createCoordinateFrom(textCoordinate: String): Pair<Int, Int> =
            Pair(textCoordinate.substringBefore(",").toInt(), textCoordinate.substringAfter(",").toInt())

        fun aVentLineFrom(startCoordinate: String, endCoordinate: String): VentLine =
            VentLine(createCoordinateFrom(startCoordinate), createCoordinateFrom(endCoordinate))
    }

    fun isDiagonal() = startCoordinate.first != endCoordinate.first && startCoordinate.second != endCoordinate.second
    fun isVertical() = !isDiagonal() && startCoordinate.first == endCoordinate.first
    fun isHorizontal() = !isDiagonal() && startCoordinate.second == endCoordinate.second

    fun getAllCoordinatesInLine(): List<Pair<Int, Int>> {
        return if (isVertical())
            getAllVerticalCoordinates()
        else if (isHorizontal())
            getAllHorizontalCoordinates()
        else
            throw IllegalArgumentException("We dont support diagonal ... yet")
    }

    private fun getAllHorizontalCoordinates() =
        minOf(startCoordinate.first, endCoordinate.first).rangeTo(maxOf(startCoordinate.first, endCoordinate.first)).toList().map { Pair(it, startCoordinate.second) }

    private fun getAllVerticalCoordinates(): List<Pair<Int, Int>> =
        minOf(startCoordinate.second, endCoordinate.second).rangeTo(maxOf(startCoordinate.second, endCoordinate.second)).toList().map { Pair(startCoordinate.first, it) }

}
