package org.suggs.adventofcode

import org.slf4j.LoggerFactory

object Day07CamelCards {

    private val log = LoggerFactory.getLogger(this::class.java)

    private val typeValues = Type.entries.reversed().mapIndexed { idx, type -> Pair(type, idx) }.toMap()
    private val cardValues = "AKQJT98765432".reversed().mapIndexed { idx, card -> Pair(card, idx) }.toMap()
    private val jokerCardValues = "AKQT98765432J".reversed().mapIndexed { idx, card -> Pair(card, idx) }.toMap()

    fun calculateCamelCardsValueFrom(data: List<String>) =
        data.asSequence().map { it.split(" ") }
            .map { (cards, bid) -> HandOfCards(cards, bid.toInt()) }
            .sorted().mapIndexed { idx, elem -> (idx + 1) * elem.bidAmount }.sum()

    fun calculateCamelCardsWithJokersValueFrom(data: List<String>): Int {
        return data.asSequence().map { it.split(" ") }
            .map { (cards, bid) -> HandOfCards(cards, bid.toInt(), true) }
            .sorted().mapIndexed { idx, elem -> (idx + 1) * elem.bidAmount }.sum()
    }

    data class HandOfCards(val cards: List<Char>, val bidAmount: Int, val handType: Type, val jokersAllowed: Boolean = false) : Comparable<HandOfCards> {
        companion object {
            operator fun invoke(cards: String, bid: Int, jokersAllowed: Boolean = false) =
                HandOfCards(cards.toCharArray().toList(), bid, figureOutHandTypeFrom(cards, jokersAllowed), jokersAllowed)

            private fun figureOutHandTypeFrom(cards: String, jokersAllowed: Boolean): Type {
                val cardCounts = cards.toCharArray().toList().groupingBy { it }.eachCount()
                return if (jokersAllowed) handTypeWithJokersFor(cardCounts)
                else handTypeNoJokersFor(cardCounts)
            }

            private fun handTypeNoJokersFor(cardCounts: Map<Char, Int>): Type {
                return when {
                    5 in cardCounts.values && cardCounts.size == 1 -> Type.FIVE
                    4 in cardCounts.values && cardCounts.size == 2 -> Type.FOUR
                    3 in cardCounts.values && cardCounts.size == 2 -> Type.FULL
                    3 in cardCounts.values && cardCounts.size == 3 -> Type.THREE
                    2 in cardCounts.values && cardCounts.size == 3 -> Type.TWO_PAIR
                    2 in cardCounts.values && cardCounts.size == 4 -> Type.ONE_PAIR
                    cardCounts.size == 5 -> Type.HIGH_CARD
                    else -> throw IllegalStateException("No idea what this type of card type this is: $cardCounts")
                }
            }

            private fun handTypeWithJokersFor(cardCounts: Map<Char, Int>): Type {
                // manipulate the cards
                return if (cardCounts.containsKey('J')) {
                    val jokerCount = cardCounts['J']!!
                    if (jokerCount == 5) return Type.FIVE
                    val highestCard = cardCounts.filter { it.key != 'J' }.maxBy { it.value }.key
                    val foo = cardCounts.filter { it.key != 'J' && it.key != highestCard } + mapOf(highestCard to (jokerCount + cardCounts[highestCard]!!))
                    return handTypeNoJokersFor(foo)
                } else handTypeNoJokersFor(cardCounts)
            }
        }

        override fun compareTo(other: HandOfCards): Int {
            val cardValuesToUse = if (jokersAllowed) jokerCardValues else cardValues
            return when {
                typeValues[handType]!! > typeValues[other.handType]!! -> 1
                typeValues[handType]!! < typeValues[other.handType]!! -> -1
                else -> recurseCardValues(other, cardValuesToUse)
            }
        }

        private fun recurseCardValues(other: HandOfCards, values: Map<Char, Int>): Int {
            fun recurseCardValues(other: HandOfCards, index: Int): Int {
                if (index == 0) return 0
                return when {
                    values[cards.get(cards.size - index)]!! > values[other.cards.get(cards.size - index)]!! -> 1
                    values[cards.get(cards.size - index)]!! < values[other.cards.get(cards.size - index)]!! -> -1
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