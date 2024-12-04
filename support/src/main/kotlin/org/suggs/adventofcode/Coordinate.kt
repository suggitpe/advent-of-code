package org.suggs.adventofcode

data class Coordinate(val x: Int, val y: Int) {

    override fun toString(): String = "$x/$y"
    fun up(by: Int = 1): Coordinate = Coordinate(x, y - by)
    fun down(by: Int = 1): Coordinate = Coordinate(x, y + by)
    fun left(by: Int = 1): Coordinate = Coordinate(x - by, y)
    fun right(by: Int = 1): Coordinate = Coordinate(x + by, y)

    fun upright(by: Int = 1): Coordinate = Coordinate(x + by, y - by)
    fun upleft(by: Int = 1): Coordinate = Coordinate(x - by, y - by)
    fun downright(by: Int = 1): Coordinate = Coordinate(x + by, y + by)
    fun downleft(by: Int = 1): Coordinate = Coordinate(x - by, y + by)
}