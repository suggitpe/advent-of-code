package org.suggs.adventofcode

import org.slf4j.LoggerFactory

object Day04Scratchcards {

    private val log = LoggerFactory.getLogger(this::class.java)

    fun sumPowerUpScoreForEachCardFrom(smallData: List<String>) =
        smallData.fold(0) { sum, elem -> sum + addScoreForCard(elem) }

    fun addTotalWinningCardsFrom(smallData: List<String>) =
        calculateNumberOfWinningCardsFrom(smallData.mapIndexed { i, str -> Wins(i, intersectCountFrom(str), 1) })

    private fun calculateNumberOfWinningCardsFrom(wins: List<Wins>): Int {
        wins.forEach { win -> incrementNextWins(wins, win.idx, win.wins, win.cardCount) }
        return wins.sumOf { it.cardCount }
    }

    private fun incrementNextWins(wins: List<Wins>, idx: Int, number: Int, cardCount: Int) {
        if (number == 0) return
        wins[idx + number].cardCount += cardCount
        incrementNextWins(wins, idx, number - 1, cardCount)
    }

    private fun addScoreForCard(card: String) =
        powerUp(intersectCountFrom(card))

    private fun intersectCountFrom(card: String): Int {

        fun intersectCountFrom(cardLists: List<List<String>>) =
            cardLists.first().toSet().intersect(cardLists.last().toSet()).count()

        return intersectCountFrom(card.split(":").last().split("|").map { it.trim() }.map { it.split("\\s+".toRegex()) })
    }

    private fun powerUp(num: Int): Int {
        return if (num <= 1) num
        else 2 * powerUp(num - 1)
    }

    data class Wins(val idx: Int, val wins: Int, var cardCount: Int)

}
