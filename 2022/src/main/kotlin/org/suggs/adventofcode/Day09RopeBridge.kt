package org.suggs.adventofcode

import org.slf4j.LoggerFactory

object Day09RopeBridge {

    private val log = LoggerFactory.getLogger(this::class.java)

    fun countTailPositionsFrom(data: List<String>): Int {
        val instructions = data.map { it.split(" ") }
        data.forEach {
            log.debug("Processing $it yields ${newPositionAfter(it, Pair(0,0))}")
        }
        return 0
    }

    private fun newPositionAfter(instruction: String, coordinates: Pair<Int, Int>): Pair<Int, Int> {
        return when (instruction.substringBefore(" ")) {
            "R" -> Pair(coordinates.first+1, coordinates.second)
            "L" -> Pair(coordinates.first-1, coordinates.second)
            "U" -> Pair(coordinates.first, coordinates.second+1)
            "D" -> Pair(coordinates.first, coordinates.second-1)
            else -> throw IllegalStateException("Cant process $instruction")
        }
    }


}