package org.suggs.aoc2024

import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test
import org.suggs.adventofcode.Util.readFileAsString
import org.suggs.aoc2024.Day02GiftShop.addAllInvalidIdsInRanges

class Day02GiftShopTest {

    @Test
    fun `adds up all invalid ids from small sample data`() {
        addAllInvalidIdsInRanges(smallData, false) shouldBe 1227775554L
    }

    @Test
    @Disabled
    fun `adds up all invalid ids from big sample data`() {
        addAllInvalidIdsInRanges(largeData, false) shouldBe 1234L
    }

    @Test
    fun `adds up all multiple invalid ids from small sample data`() {
        addAllInvalidIdsInRanges(smallData, true) shouldBe 4174379265L
    }

    @Test
    @Disabled
    fun `adds up all multiple invalid ids from large sample data`() {
        addAllInvalidIdsInRanges(largeData, true) shouldBe 1234L
    }

    private val smallData =
        "11-22,95-115,998-1012,1188511880-1188511890,222220-222224,1698522-1698528,446443-446449,38593856-38593862,565653-565659,824824821-824824827,2121212118-2121212124".split(
            ","
        )
    private val largeData = readFileAsString("day02-input.txt").split(",")
}