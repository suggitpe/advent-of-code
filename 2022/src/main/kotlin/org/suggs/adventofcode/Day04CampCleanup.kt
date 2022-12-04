package org.suggs.adventofcode

object Day04CampCleanup {

    fun testForFullRangeOverlap(rangePair: String) =
        testForFullRangeOverlap(createRangesFromString(rangePair.split(",")))

    private fun testForFullRangeOverlap(rangePair: Pair<Set<Int>, Set<Int>>) =
        rangePair.first.containsAll(rangePair.second) || rangePair.second.containsAll(rangePair.first)

    fun testForPartialRangeOverlap(rangePair: String) =
        testForPartialRangeOverlap(createRangesFromString(rangePair.split(",")))

    private fun testForPartialRangeOverlap(rangePair: Pair<Set<Int>, Set<Int>>) =
        rangePair.first.any { rangePair.second.contains(it) }

    private fun createRangesFromString(rangePair: List<String>) =
        Pair(createSingleRangeFrom(rangePair.first()).toSortedSet(), createSingleRangeFrom(rangePair.last()).toSortedSet())

    private fun createSingleRangeFrom(stringRange: String) =
        (stringRange.split("-").first().toInt())..(stringRange.split("-").last().toInt())

}