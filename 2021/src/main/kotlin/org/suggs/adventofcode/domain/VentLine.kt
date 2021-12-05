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
        return when {
            isVertical() -> createRangeFrom(startCoordinate.second, endCoordinate.second).map { Pair(startCoordinate.first, it) }
            isHorizontal() -> createRangeFrom(startCoordinate.first, endCoordinate.first).map { Pair(it, startCoordinate.second) }
            else -> createRangeFrom(startCoordinate.first, endCoordinate.first) zip createRangeFrom(startCoordinate.second, endCoordinate.second)
        }
    }

    private fun createRangeFrom(start: Int, end: Int) =
        when {
            (start < end) -> start.rangeTo(end).toList()
            else -> end.rangeTo(start).toList().reversed()
        }
}
