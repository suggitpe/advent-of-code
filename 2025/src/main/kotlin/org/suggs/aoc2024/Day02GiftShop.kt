package org.suggs.aoc2024

import org.slf4j.LoggerFactory

object Day02GiftShop {

    private val log = LoggerFactory.getLogger(this::class.java)

    fun addAllInvalidIdsInRanges(smallData: List<String>, multiSplit: Boolean): Long =
        smallData.sumOf { addAllInvalidIdsFrom(buildRangeFrom(it), multiSplit) }

    fun addAllInvalidIdsFrom(range: LongRange, multiSplit: Boolean): Long =
        addAllInvalidIdsFrom(range.toList(), 0L, multiSplit)

    private tailrec fun addAllInvalidIdsFrom(range: List<Long>, accu: Long, multiSplit: Boolean): Long =
        if (range.isEmpty()) accu
        else addAllInvalidIdsFrom(range.drop(1), accu + dodgyId(range.first(), multiSplit), multiSplit)

    private fun dodgyId(number: Long, multiSplit: Boolean): Long {
        return if (multiSplit) {
            if (dodgyId(number.toString())) number else 0
        } else {
            val num = number.toString()
            if (num.length % 2 != 0) return 0
            if (dodgyIdCheckByChunk(num, num.length / 2)) number else 0
        }
    }

    private fun dodgyId(num: String): Boolean =
        (1..5).any { dodgyIdCheckByChunk(num, it) }

    private fun dodgyIdCheckByChunk(num: String, chunkSize: Int): Boolean {
        if (num.length < chunkSize) return false
        val chunks = num.chunked(chunkSize)
        if (chunks.size == 1) return false
        if (chunks.last().length != chunkSize) return false
        val firstChunk = chunks.first()
        return chunks.all { it == firstChunk }
    }

    private fun buildRangeFrom(rangeData: String) =
        rangeData
            .split("-", limit = 2)
            .takeIf { it.size == 2 }
            .let { it!![0].toLong()..it[1].trim().toLong() }


}