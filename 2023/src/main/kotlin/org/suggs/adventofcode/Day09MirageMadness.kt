package org.suggs.adventofcode

import org.slf4j.LoggerFactory

object Day09MirageMadness {

    private val log = LoggerFactory.getLogger(this::class.java)

    fun sumIncrementsFrom(data: List<String>): Int {
        val foo = data.map { it.split("\\s+".toRegex()).map { foo -> foo.toInt() } }
        return foo.sumOf { calculateNextInSequenceFor(it) }
            .also { log.debug("Part 1: $it") }
    }

    private fun calculateNextInSequenceFor(sequence: List<Int>): Int {
        return if (sequence.sum() == 0) 0
        else calculateNextInSequenceFor(sequence.zipWithNext { a, b -> b - a }) + sequence.last()
    }
}