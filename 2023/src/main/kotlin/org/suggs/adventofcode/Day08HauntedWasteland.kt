package org.suggs.adventofcode

import org.slf4j.LoggerFactory

object Day08HauntedWasteland {
    private val log = LoggerFactory.getLogger(this::class.java)

    fun countHopsInDataMap(data: List<String>) =
        countHopsToFinsh("AAA", data.first(), data.last().split("\n").associate { it.split(" ").first() to Hop(it) }, 0)
            .also { log.debug("Part 1: $it") }

    private tailrec fun countHopsToFinsh(key: String, indicator: String, hops: Map<String, Hop>, acum: Int): Int {
        return if (key == "ZZZ") acum
        else countHopsToFinsh(hops[key]!!.get(indicator.first()), shuffleIndicators(indicator), hops, acum + 1)
    }

    private fun shuffleIndicators(indicator: String) = indicator.drop(1) + indicator.first()

    data class Hop(val left: String, val right: String) {

        companion object {
            operator fun invoke(hopData: String): Hop {
                return Hop(
                    hopData.split("(")[1].split(",").first().trim(),
                    hopData.split("(")[1].split(",")[1].split(")").first().trim()
                )
            }
        }

        fun get(indicator: Char) = if (indicator == 'L') left else right
    }
}