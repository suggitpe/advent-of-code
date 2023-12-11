package org.suggs.adventofcode

data class Coordinate(val x: Int, val y: Int) {

    override fun toString(): String = "$x/$y"
    fun up(): Coordinate = Coordinate(x, y - 1)
    fun down(): Coordinate = Coordinate(x, y + 1)
    fun left(): Coordinate = Coordinate(x - 1, y)
    fun right(): Coordinate = Coordinate(x + 1, y)
}