package org.suggs.adventofcode

object Day03RucksackReorganization {

    fun findIntersectingCharacterValueFrom(data: List<String>) =
        charValueOf(data.map { it.toCharArray().toSet() }.reduce { acc, it -> acc.intersect(it) }.first())

    private fun charValueOf(char: Char): Int {
        return when (char.isLowerCase()) {
            true -> char.code - 'a'.code + 1
            else -> char.code - 'A'.code + 27
        }
    }
}