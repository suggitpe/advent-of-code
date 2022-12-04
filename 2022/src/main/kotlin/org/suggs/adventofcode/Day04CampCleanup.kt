package org.suggs.adventofcode

import org.slf4j.LoggerFactory

object Day04CampCleanup {
    private val log = LoggerFactory.getLogger(this::class.java)

    fun testForFullRangeOverlap(rangePair: String) =
        testForFullRangeOverlap(createRangesFromString(rangePair))

    private fun testForFullRangeOverlap(rangePair: Pair<Set<Int>, Set<Int>>) =
        rangePair.first.containsAll(rangePair.second) || rangePair.second.containsAll(rangePair.first)

    fun testForPartialRangeOverlap(rangePair: String) =
        testForPartialRangeOverlap(createRangesFromString(rangePair))

    private fun testForPartialRangeOverlap(rangePair: Pair<Set<Int>, Set<Int>>) =
        rangePair.first.any { rangePair.second.contains(it) }

    private fun createRangesFromString(rangePair: String): Pair<Set<Int>, Set<Int>> {
        val strings = rangePair.split(",")
        return Pair(createSingleRangeFrom(strings.first()).toSortedSet(), createSingleRangeFrom(strings.last()).toSortedSet())
    }

    private fun createSingleRangeFrom(stringRange: String) =
        (stringRange.split("-").first().toInt())..(stringRange.split("-").last().toInt())

}