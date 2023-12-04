package org.suggs.adventofcode

import org.slf4j.LoggerFactory

object Day04Scratchcards {

    private val log = LoggerFactory.getLogger(this::class.java)

    fun sumFibonacciScoreForEachCardFrom(smallData: List<String>) =
        smallData.fold(0) { sum, elem -> sum + addScoreForCard(elem) }

    private fun addScoreForCard(card: String) =
        powerUp(intersectCountFrom(splitSCardIntoTwoLists(card)))

    private fun splitSCardIntoTwoLists(card: String) =
        card.split(":").last().split("|").map { it.trim() }.map { it.split("\\s+".toRegex()) }

    private fun intersectCountFrom(cardLists: List<List<String>>) =
        cardLists.first().toSet().intersect(cardLists.last().toSet()).count()

    private fun powerUp(num: Int): Int {
        return if (num <= 1) num
        else 2 * powerUp(num - 1)
    }

}
