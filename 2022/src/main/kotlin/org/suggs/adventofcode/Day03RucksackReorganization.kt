package org.suggs.adventofcode

import org.slf4j.LoggerFactory

object Day03RucksackReorganization {

    private val log = LoggerFactory.getLogger(this::class.java)

    fun findIntersectingCharacterValueFromString(data: String) =
        findIntersectingCharacterValueFrom(data.chunked(data.length / 2))

    // This is being a bit funky, it's reducing the list of strings using intersect
    fun findIntersectingCharacterValueFrom(data: List<String>) =
        charValueOf(data.map { it.toCharArray().toSet() }.reduce { acc, it -> acc.intersect(it) }.first())

    private fun charValueOf(char: Char): Int {
        return when (char.isLowerCase()) {
            true -> char.code - 'a'.code + 1
            else -> char.code - 'A'.code + 27
        }
    }
}