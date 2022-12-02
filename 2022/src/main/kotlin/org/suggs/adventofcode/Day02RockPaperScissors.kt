package org.suggs.adventofcode

import org.slf4j.LoggerFactory

object Day02RockPaperScissors {

    private val log = LoggerFactory.getLogger(this::class.java)
    private val scores = mapOf<String, Int>(
        "A X" to 4, // 1 + 3
        "A Y" to 8, // 2 + 6
        "A Z" to 3, // 3 + 0
        "B X" to 1, // 1 + 0
        "B Y" to 5, // 2 + 3
        "B Z" to 9, // 3 + 6
        "C X" to 7, // 1 + 6
        "C Y" to 2, // 2 + 0
        "C Z" to 6  // 3 + 3
    )

    fun playRockPaperScissorsWith(data: List<String>) =
        data.sumOf { scores[it]!! }
}
