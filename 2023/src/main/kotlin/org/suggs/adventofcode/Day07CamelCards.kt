package org.suggs.adventofcode

import org.slf4j.LoggerFactory

object Day07CamelCards {

    private val log = LoggerFactory.getLogger(this::class.java)

    private val typeValues = Type.entries.reversed().mapIndexed { idx, type -> Pair(type, idx) }.toMap()
    private val cardValues = "AKQJT98765432".reversed().mapIndexed { idx, card -> Pair(card, idx) }.toMap()

    fun calculateCamelCardsValueFrom(data: List<String>) =
        data.asSequence().map { it.split(" ") }
            .map { (cards, bid) -> HandOfCards(cards, bid.toInt()) }
            .sorted().mapIndexed { idx, elem -> (idx + 1) * elem.bidAmount }.sum()

    data class HandOfCards(val cards: List<Char>, val bidAmount: Int, val handType: Type) : Comparable<HandOfCards> {
        companion object {
            operator fun invoke(cards: String, bid: Int) =
                HandOfCards(cards.toCharArray().toList(), bid, figureOutHandTypeFrom(cards))

            private fun figureOutHandTypeFrom(cards: String): Type {
                val cardCounts = cards.toCharArray().toList().groupingBy { it }.eachCount().values
                return when {
                    5 in cardCounts && cardCounts.size == 1 -> Type.FIVE
                    4 in cardCounts && cardCounts.size == 2 -> Type.FOUR
                    3 in cardCounts && cardCounts.size == 2 -> Type.FULL
                    3 in cardCounts && cardCounts.size == 3 -> Type.THREE
                    2 in cardCounts && cardCounts.size == 3 -> Type.TWO_PAIR
                    2 in cardCounts && cardCounts.size == 4 -> Type.ONE_PAIR
                    cardCounts.size == 5 -> Type.HIGH_CARD
                    else -> throw IllegalStateException("No idea what this type of card type this is: $cards")
                }
            }
        }

        override fun compareTo(other: HandOfCards): Int {
            return when {
                typeValues[handType]!! > typeValues[other.handType]!! -> 1
                typeValues[handType]!! < typeValues[other.handType]!! -> -1
                else -> recurseCardValues(other)
            }
        }

        private fun recurseCardValues(other: HandOfCards): Int {
            fun recurseCardValues(other: HandOfCards, index: Int): Int {
                if (index == 0) return 0
                return when {
                    cardValues[cards.get(cards.size - index)]!! > cardValues[other.cards.get(cards.size - index)]!! -> 1
                    cardValues[cards.get(cards.size - index)]!! < cardValues[other.cards.get(cards.size - index)]!! -> -1
                    else -> recurseCardValues(other, index - 1)
                }
            }
            return recurseCardValues(other, other.cards.size)
        }
    }

    enum class Type {
        FIVE, FOUR, FULL, THREE, TWO_PAIR, ONE_PAIR, HIGH_CARD
    }

}