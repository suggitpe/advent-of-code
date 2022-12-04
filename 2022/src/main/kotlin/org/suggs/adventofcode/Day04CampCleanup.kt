package org.suggs.adventofcode

object Day04CampCleanup {

    fun testForFullRangeOverlap(rangePair: String): Boolean =
        testForFullRangeOverlap(createRangesFromString(rangePair.split(",")))

    private fun testForFullRangeOverlap(rangePair: Pair<Set<Int>, Set<Int>>): Boolean =
        rangePair.first.containsAll(rangePair.second) || rangePair.second.containsAll(rangePair.first)

    fun testForPartialRangeOverlap(rangePair: String): Boolean =
        testForPartialRangeOverlap(createRangesFromString(rangePair.split(",")))

    private fun testForPartialRangeOverlap(rangePair: Pair<Set<Int>, Set<Int>>): Boolean =
        rangePair.first.any { rangePair.second.contains(it) }

    private fun createRangesFromString(rangePair: List<String>): Pair<Set<Int>, Set<Int>> =
        Pair(createSingleRangeFrom(rangePair.first()).toSortedSet(), createSingleRangeFrom(rangePair.last()).toSortedSet())

    private fun createSingleRangeFrom(stringRange: String): IntProgression =
        (stringRange.split("-").first().toInt())..(stringRange.split("-").last().toInt())

}