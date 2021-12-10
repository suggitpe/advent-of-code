package org.suggs.adventofcode

import org.slf4j.LoggerFactory

object Day10SyntaxScoring {

    private val log = LoggerFactory.getLogger(this::class.java)
    private val charMap: Map<Char, Char> = mapOf('{' to '}', '<' to '>', '[' to ']', '(' to ')')
    private val valueMap: Map<Char, Int> = mapOf(')' to 3, ']' to 57, '}' to 1197, '>' to 25137)
    private val closeValueMap: Map<Char, Int> = mapOf(')' to 1, ']' to 2, '}' to 3, '>' to 4)

    fun calculateScoreOfRemainder(dataSet: List<String>): Long {
        val foo = dataSet.asSequence().map { removeNestedPairs(it) }.filter { isValid(it) }.map { createClosingSyntaxFrom(it) }.map { calculateValueOf(it) }.map { it }.sorted().toList()
        return foo[foo.size / 2]
    }

    private fun calculateValueOf(switchedSyntax: String): Long {
        fun calculateValueOf(switchedSyntax: CharArray, aggregate: Long): Long {
            return when {
                switchedSyntax.isEmpty() -> aggregate
                else -> calculateValueOf(switchedSyntax.drop(1).toCharArray(), (aggregate * 5) + closeValueMap[switchedSyntax.first()]!!)
            }
        }
        return calculateValueOf(switchedSyntax.toCharArray(), 0L)
    }

    private fun createClosingSyntaxFrom(remainder: String): String =
        remainder.reversed().map { charMap[it]!! }.joinToString("")

    private fun isValid(syntax: String) =
        syntax.filterNot { charMap.contains(it) }.isEmpty()

    fun calculateSyntaxScoreFrom(dataSet: List<String>) =
        dataSet.sumOf { calculateSyntaxScoreFrom(removeNestedPairs(it)) }

    private fun calculateSyntaxScoreFrom(pairlessSyntax: String): Int {
        val remainder = pairlessSyntax.filterNot { charMap.contains(it) }
        return when {
            remainder.isEmpty() -> 0
            else -> valueMap[remainder.first()]!!
        }
    }

    private fun removeNestedPairs(original: String): String {
        fun removePairsFrom(syntax: String) =
            syntax.replace("<>", "").replace("()", "").replace("[]", "").replace("{}", "")

        val cleaned = removePairsFrom(original)
        return when (cleaned.length) {
            original.length -> cleaned
            else -> removeNestedPairs(cleaned)
        }

    }


}