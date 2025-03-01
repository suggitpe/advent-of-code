package org.suggs.adventofcode

enum class Direction {
    UP, DOWN, LEFT, RIGHT;

    fun next(current: Direction): Direction {
        return when (current) {
            UP -> RIGHT
            RIGHT -> DOWN
            DOWN -> LEFT
            LEFT -> UP
        }
    }
}