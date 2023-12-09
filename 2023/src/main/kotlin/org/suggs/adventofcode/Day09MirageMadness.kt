package org.suggs.adventofcode

import org.slf4j.LoggerFactory

object Day09MirageMadness {

    private val log = LoggerFactory.getLogger(this::class.java)

    fun sumIncrementsFrom(data: List<String>) =
        buildSequencesFrom(data).sumOf { calculateNextInSequenceFor(it) }.also { log.debug("Part 1: $it") }

    private fun calculateNextInSequenceFor(sequence: List<Int>): Int =
        if (sequence.all { it == 0 }) 0
        else (calculateNextInSequenceFor(sequence.zipWithNext { a, b -> b - a }) + sequence.last())

    fun sumPriorSequenceFrom(data: List<String>): Int =
        buildSequencesFrom(data).sumOf { calculateFirstInSequenceFor(it) }.also { log.debug("Part 2: $it") }

    private fun calculateFirstInSequenceFor(sequence: List<Int>): Int =
        if (sequence.all { it == 0 }) 0
        else sequence.first() - calculateFirstInSequenceFor(sequence.zipWithNext { a, b -> b - a })

    private fun buildSequencesFrom(data: List<String>): List<List<Int>> =
        data.map { it.split("\\s+".toRegex()).map { foo -> foo.toInt() } }
}