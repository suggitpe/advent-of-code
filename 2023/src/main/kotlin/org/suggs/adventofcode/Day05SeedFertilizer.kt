package org.suggs.adventofcode

import org.slf4j.LoggerFactory

object Day05SeedFertilizer {

    private val log = LoggerFactory.getLogger(this::class.java)

    fun calculateLowestLocationNumber(data: List<String>) =
        extractSeedsFrom(data).minOf { calculateLocationValueFor(it, extractDataRangesFrom(data)) }

    private fun extractSeedsFrom(data: List<String>): List<Long> = data.first().split(":").last().trim().split(" ").map { it.toLong() }

    private fun extractDataRangesFrom(data: List<String>) = data.drop(1).map { RangePairSet(it) }

    private fun calculateLocationValueFor(seedValue: Long, ranges: List<RangePairSet>): Long {
        if (ranges.isEmpty()) return seedValue
        return calculateLocationValueFor(ranges.first().mapSrcToDest(seedValue), ranges.drop(1))
    }

    data class RangePairSet(val rangePairs: List<RangePair>) {
        fun mapSrcToDest(num: Long): Long {
            rangePairs.forEach {
                if (it.src.contains(num))
                    return it.getDestValueFor(num)
            }
            return num
        }

        companion object {
            operator fun invoke(rangeBlock: String): RangePairSet {
                return RangePairSet(rangeBlock.split("\n").drop(1).fold(listOf<RangePair>()) { sum, elem -> sum + RangePair(elem) })
            }
        }
    }

    data class RangePair(val src: LongRange, val dest: LongRange) {

        fun getDestValueFor(num: Long) = dest.first + (num - src.first)

        companion object {
            operator fun invoke(rangeCode: String): RangePair {
                val data = rangeCode.trim().split(" ")
                return RangePair(
                    data[1].toLong().rangeTo(data[1].toLong() + (data[2].toLong() - 1L)),
                    data[0].toLong().rangeTo(data[0].toLong() + (data[2].toLong() - 1L))
                )

            }
        }

    }

}