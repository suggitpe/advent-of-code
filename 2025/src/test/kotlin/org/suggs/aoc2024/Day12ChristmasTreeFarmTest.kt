package org.suggs.aoc2024

import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test
import org.suggs.adventofcode.Util.getTextBlocksFrom
import org.suggs.aoc2024.Day12ChristmasTreeFarm.countRegionsThatFitPresentsFrom

class Day12ChristmasTreeFarmTest {

    @Test
    fun `count regions that fit presents - small`(){
        countRegionsThatFitPresentsFrom(smallData) shouldBe 0
    }

    @Test
    @Disabled
    fun `count regions that fit presents - large`(){
        countRegionsThatFitPresentsFrom(largeData) shouldBe 0
    }

    val largeData = getTextBlocksFrom("day12-input.txt")
    val smallData = """0:
###
##.
##.

1:
###
##.
.##

2:
.##
###
##.

3:
##.
###
##.

4:
###
#..
###

5:
###
.#.
###

4x4: 0 0 0 0 2 0
12x5: 1 0 1 0 2 2
12x5: 1 0 1 0 3 2""".split("\n\n")

}