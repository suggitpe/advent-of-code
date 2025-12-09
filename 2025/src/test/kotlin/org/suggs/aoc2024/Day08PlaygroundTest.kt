package org.suggs.aoc2024

import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test
import org.slf4j.LoggerFactory
import org.suggs.adventofcode.Util.getFileLinesFrom
import org.suggs.aoc2024.Day08Playground.calculateCircuitsFrom

class Day08PlaygroundTest {
    private val log = LoggerFactory.getLogger(this::class.java)

    @Test
    fun `calculate circuits from - small data`() {
        calculateCircuitsFrom(smallData) shouldBe 0
    }

    @Test
    @Disabled
    fun `calculate circuits from - large data`() {
        calculateCircuitsFrom(largeData) shouldBe 1234
    }


    private val largeData = getFileLinesFrom("day03-input.txt")
    private val smallData = """162,817,812
57,618,57
906,360,560
592,479,940
352,342,300
466,668,158
542,29,236
431,825,988
739,650,466
52,470,668
216,146,977
819,987,18
117,168,530
805,96,715
346,949,466
970,615,88
941,993,340
862,61,35
984,92,344
425,690,689""".split("\n")
}