package org.suggs.adventofcode

import org.slf4j.LoggerFactory

object Day12 {
    private val log = LoggerFactory.getLogger(this::class.java)

    fun foo(smallData: List<String>): Int {
        smallData.map { log.debug("$it") }
        return 0
    }


}