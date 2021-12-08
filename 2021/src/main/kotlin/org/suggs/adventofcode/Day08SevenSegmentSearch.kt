package org.suggs.adventofcode

import org.suggs.adventofcode.domain.DigitDecoder

object Day08SevenSegmentSearch {

    fun simpleDecodeAll(dataSet: List<Pair<String, String>>) =
        dataSet.map { it.second }.map { it.split(" ") }.flatten().groupingBy { it.length }.eachCount().filterKeys { listOf(2, 4, 3, 7).contains(it) }.values.sum()

    fun decodeAll(dataSet: List<Pair<String, String>>) =
        dataSet.sumOf { DigitDecoder(it.first.split(" ")).decode(it.second) }

}