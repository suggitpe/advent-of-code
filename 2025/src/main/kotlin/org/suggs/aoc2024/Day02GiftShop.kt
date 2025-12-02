package org.suggs.aoc2024

import org.slf4j.LoggerFactory

object Day02GiftShop {

    private val log = LoggerFactory.getLogger(this::class.java)

    fun addAllInvalidIdsInRanges(smallData: List<String>, multiSplit: Boolean): Long =
        smallData.sumOf { addAllInvalidIdsFrom(buildRangeFrom(it), multiSplit) }

    fun addAllInvalidIdsFrom(range: LongRange, multiSplit: Boolean): Long {
        return addAllInvalidIdsFrom(range.toList(), 0L, multiSplit)
    }

    private tailrec fun addAllInvalidIdsFrom(range: List<Long>, accu: Long, multiSplit: Boolean): Long {
        return if (range.isEmpty()) {
            accu
        } else {
            addAllInvalidIdsFrom(range.drop(1), accu + dodgyId(range.first(), multiSplit), multiSplit)
        }
    }

    private fun dodgyId(number: Long, multiSplit: Boolean): Long {
        return if(multiSplit) {
            if (dodgyMultipleSplitId(number.toString())) number else 0
        } else
            if (dodgySingleSplitId(number.toString())) number else 0
    }

    private fun dodgyMultipleSplitId(num: String): Boolean {
        return false
    }

    private fun dodgySingleSplitId(number: String): Boolean {
        val mid = number.length / 2
        return number.length >= 2 && number.length % 2 == 0 &&
                number.take(mid) == number.substring(mid)
    }

    private fun buildRangeFrom(rangeData: String) =
        rangeData
            .split("-", limit = 2)
            .takeIf { it.size == 2 }
            .let { it!![0].toLong()..it[1].trim().toLong() }


}