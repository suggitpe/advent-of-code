package org.suggs.adventofcode

import org.slf4j.LoggerFactory

object Day10SyntaxScoring {

    private val log = LoggerFactory.getLogger(this::class.java)
    private val charMap: Map<Char, Char> = mapOf('{' to '}', '<' to '>', '[' to ']', '(' to ')')
    private val valueMap: Map<Char, Int> = mapOf(')' to 3, ']' to 57, '}' to 1197, '>' to 25137)

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
        return if (cleaned.length == original.length)
            return cleaned
        else
            removeNestedPairs(cleaned)
    }


}