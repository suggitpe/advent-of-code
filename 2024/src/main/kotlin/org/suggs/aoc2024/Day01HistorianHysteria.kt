package org.suggs.aoc2024

import org.slf4j.LoggerFactory
import kotlin.math.abs

object Day01HistorianHysteria {

    private val log = LoggerFactory.getLogger(this::class.java)

    fun addListDistancesFor(smallData: List<String>): Int =
        addDistancesOfTwoLists(
            smallData.map { it.split("   ").first().toInt() }.sorted(),
            smallData.map { it.split("   ").last().toInt() }.sorted(),
            0
        )

    private fun addDistancesOfTwoLists(left: List<Int>, right: List<Int>, accu: Int): Int {
        return if (left.isEmpty())
            accu
        else
            addDistancesOfTwoLists(left.drop(1), right.drop(1), accu + abs(left.first() - right.first()))
    }

    fun addSimilarityScoresFor(smallData: List<String>): Int {
        return calculateAllSimilarityScores(
            smallData.map { it.split(" ").first().toInt() },
            smallData.map { it.split(" ").last().toInt() }.sorted(), 0
        )
    }

    private fun calculateAllSimilarityScores(left: List<Int>, right: List<Int>, accu: Int): Int {
        return if (left.isEmpty())
            accu
        else
            return calculateAllSimilarityScores(
                left.drop(1),
                right,
                accu + (left.first() * countOccurrencesOf(left.first(), right))
            )
    }

    private fun countOccurrencesOf(check: Int, list: List<Int>) = list.count { it == check }


}
