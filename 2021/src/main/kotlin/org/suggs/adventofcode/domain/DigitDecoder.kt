package org.suggs.adventofcode.domain

import org.slf4j.LoggerFactory

class DigitDecoder(cypher: List<String>) {

    private val log = LoggerFactory.getLogger(this::class.java)
    private val digits: MutableMap<Int, String> = mutableMapOf()

    init {
        digits[1] = cypher.first { it.length == 2 }
        digits[4] = cypher.first { it.length == 4 }
        digits[7] = cypher.first { it.length == 3 }
        digits[8] = cypher.first { it.length == 7 }
        digits[2] = cypher.filterNot { digits.values.contains(it) }.first { it.length == 5 && it.removeCharsFrom(digits.getOrDefault(4, "")).length == 3 }
        digits[3] = cypher.filterNot { digits.values.contains(it) }.first { it.length == 5 && it.removeCharsFrom(digits.getOrDefault(7, "")).length == 2 }
        digits[5] = cypher.filterNot { digits.values.contains(it) }.first { it.length == 5 && it.removeCharsFrom(digits.getOrDefault(7, "")).length == 3 }
        digits[6] = cypher.filterNot { digits.values.contains(it) }.first { it.length == 6 && it.removeCharsFrom(digits.getOrDefault(7, "")).length == 4 }
        digits[9] = cypher.filterNot { digits.values.contains(it) }.first { it.length == 6 && it.removeCharsFrom(digits.getOrDefault(5, "")).length == 1 }
        digits[0] = cypher.filterNot { digits.values.contains(it) }.first { it.length == 6 && it.removeCharsFrom(digits.getOrDefault(5, "")).length == 2 }
    }

    fun decode(codedDigits: String) =
        codedDigits.split(" ").flatMap { digits.filter { inner -> inner.value.hasSameCharactersAs(it) }.keys }.joinToString("") { it.toString() }.toInt()

    private fun String.removeCharsFrom(otherString: String) =
        this.toCharArray().toList().filterNot { otherString.contains(it) }.joinToString("")

    private fun String.hasSameCharactersAs(otherString: String): Boolean =
        this.toCharArray().sorted().toString() == otherString.toCharArray().sorted().toString()

}