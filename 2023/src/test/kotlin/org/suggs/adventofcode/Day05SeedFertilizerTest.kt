package org.suggs.adventofcode

import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.suggs.adventofcode.Day05SeedFertilizer.RangePair
import org.suggs.adventofcode.Day05SeedFertilizer.RangePairSet
import org.suggs.adventofcode.Day05SeedFertilizer.calculateLowestLocationNumber
import org.suggs.adventofcode.Util.getTextBlocksFrom

@DisplayName("Seed Fertilizer")
class Day05SeedFertilizerTest {

    @Test
    fun `calculates lowest location number from small data`() {
        calculateLowestLocationNumber(smallData) shouldBe 35
    }

    @Test
    @Disabled
    fun `calculates lowest location number from large data`() {
        calculateLowestLocationNumber(largeData) shouldBe 123
    }

    @Test
    fun `creates ranges from text block`() {
        RangePairSet(encodedRangesBlock) shouldBe RangePairSet(
            listOf(
                RangePair(98L.rangeTo(99L), 50L.rangeTo(51L)),
                RangePair(50L..97L, 52L..99L)
            )
        )
    }

    @Test
    fun `maps sources to destinations through ranges`() {
        RangePairSet(encodedRangesBlock).mapSrcToDest(14) shouldBe 14
        RangePairSet(encodedRangesBlock).mapSrcToDest(13) shouldBe 13
        RangePairSet(encodedRangesBlock).mapSrcToDest(79) shouldBe 81
        RangePairSet(encodedRangesBlock).mapSrcToDest(55) shouldBe 57
    }


    private val largeData = getTextBlocksFrom("day05-input.txt")

    private val encodedRangesBlock = """seed-to-soil map:
50 98 2
52 50 48"""

    private val smallData = """seeds: 79 14 55 13

seed-to-soil map:
50 98 2
52 50 48

soil-to-fertilizer map:
0 15 37
37 52 2
39 0 15

fertilizer-to-water map:
49 53 8
0 11 42
42 0 7
57 7 4

water-to-light map:
88 18 7
18 25 70

light-to-temperature map:
45 77 23
81 45 19
68 64 13

temperature-to-humidity map:
0 69 1
1 0 69

humidity-to-location map:
60 56 37
56 93 4""".split("\n\n")

}