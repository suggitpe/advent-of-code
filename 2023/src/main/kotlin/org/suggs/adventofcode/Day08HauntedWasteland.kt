package org.suggs.adventofcode

import org.slf4j.LoggerFactory

object Day08HauntedWasteland {
    private val log = LoggerFactory.getLogger(this::class.java)

    fun countHopsInDataMap(data: List<String>) =
        countHopsToFinsh("AAA", data.first(), buildHopsDataMapFrom(data), 0)
            .also { log.debug("Part 1: $it") }

    private tailrec fun countHopsToFinsh(key: String, indicator: String, hopMap: Map<String, Hop>, accumulator: Long): Long {
        return if (key == "ZZZ") accumulator
        else countHopsToFinsh(hopMap[key]!!.get(indicator.first()), shuffleIndicators(indicator), hopMap, accumulator + 1L)
    }

    fun countHopsInDataMapForMultiHop(data: List<String>): Long {
        val hopMap = buildHopsDataMapFrom(data)
        return hopMap.keys.filter { it.endsWith("A") }
            .map { countHopsToFinshEndingZ(it, data.first(), buildHopsDataMapFrom(data), 0) }
            .reduce { acc, next -> lcm(acc, next) }
            .also { log.debug("Part 2: $it") }
    }

    private fun lcm(a: Long, b: Long) = a / gcd(a, b) * b

    private fun gcd(a: Long, b: Long): Long {
        return if (b == 0L) a
        else gcd(b, a % b)
    }

    private tailrec fun countHopsToFinshEndingZ(key: String, indicator: String, hopMap: Map<String, Hop>, accumulator: Long): Long {
        return if (key.endsWith("Z")) accumulator
        else countHopsToFinshEndingZ(hopMap[key]!!.get(indicator.first()), shuffleIndicators(indicator), hopMap, accumulator + 1L)
    }

    private fun shuffleIndicators(indicator: String) = indicator.drop(1) + indicator.first()

    private fun buildHopsDataMapFrom(data: List<String>) =
        data.last().split("\n").associate { it.split(" ").first() to Hop(it) }
}

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
