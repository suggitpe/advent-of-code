package org.suggs.aoc2024

import org.slf4j.LoggerFactory
import org.suggs.adventofcode.Extensions.combinationsOf

object Day10Factory {

    private val log = LoggerFactory.getLogger(this::class.java)

    fun countMinimumButtonPressesFrom(buttonCodes: List<String>): Int =
        buttonCodes
            .sumOf {
                it.split(" ")
                    .let { code -> countMinimumButtonPressesFrom(code[0], code.drop(1).dropLast(1)) }
            }

    private fun countMinimumButtonPressesFrom(target: String, codes: List<String>): Int =
        countMinimumButtonPressesFrom(createIndicatorLightsFrom(target), codes.map { createButtonPressesFrom(it) })

    private fun countMinimumButtonPressesFrom(target: Int, codes: List<Int>): Int {
        for (i in 1..codes.size) {
            if (codes.combinationsOf(i).any { matchXor(target, it) }) {
                return i
            }
        }
        throw IllegalStateException("could not find a match to the target")
    }

    fun matchXor(target: Int, codes: List<Int>): Boolean =
        codes.fold(0) { acc, num ->
            acc xor num
        } == target

    fun createIndicatorLightsFrom(target: String): Int {
        val bits = target.toCharArray().filterNot { it in setOf('[', ']') }
        var lights = 0
        for (bit in bits.indices) {
            if (bits[bit] == '#') {
                lights = lights or (1 shl bit)
            }
        }
        return lights
    }

    fun createButtonPressesFrom(code: String): Int =
        code
            .filterNot { it in setOf('(', ')') }
            .trim()
            .split(',')
            .map { it -> it.toInt() }.sumOf { 1 shl it }
}