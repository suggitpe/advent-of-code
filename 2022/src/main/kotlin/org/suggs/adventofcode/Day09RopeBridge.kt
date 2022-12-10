package org.suggs.adventofcode

import org.slf4j.LoggerFactory

object Day09RopeBridge {

    private val log = LoggerFactory.getLogger(this::class.java)

    fun countTailPositionsFrom(data: List<String>): Int {
        val instructions = data.map { it.split(" ") }
        log.debug("$instructions")
        return 0
    }


}