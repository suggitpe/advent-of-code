package org.suggs.adventofcode

import io.kotest.matchers.ints.shouldBeLessThanOrEqual
import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test
import org.slf4j.LoggerFactory
import org.suggs.adventofcode.Day10AdapterArray.Companion.countNumberOfValidCombinationsOfJoltAdaptersIn
import org.suggs.adventofcode.Day10AdapterArray.Companion.getMapOfJoltDifferences
import java.io.File

internal class Day10AdapterArrayTest {

    companion object {
        private val log = LoggerFactory.getLogger(this::class.java)
    }

    @Test
    fun `counts the number of jolt differences in really small set`() {
        val mapOfJoltDifferences = getMapOfJoltDifferences(verySmallArray)
        log.info("we have found $mapOfJoltDifferences")
        mapOfJoltDifferences.size shouldBeLessThanOrEqual 3
        mapOfJoltDifferences.values.reduce { acc, it -> it * acc } shouldBe 35
    }

    @Test
    fun `counts the number of jolt differences in small set`() {
        val mapOfJoltDifferences = getMapOfJoltDifferences(setArray)
        mapOfJoltDifferences.values.reduce { acc, it -> it * acc } shouldBe 220
    }

    @Test
    fun `counts the number of jolt differences in a large set`() {
        val mapOfJoltDifferences = getMapOfJoltDifferences(readArray)
        mapOfJoltDifferences.values.reduce { acc, it -> it * acc } shouldBe 2244
    }

    @Disabled
    @Test
    fun `counts number of discrete jolt adapter combinations from really small set`() {
        val numberOfCombinations = countNumberOfValidCombinationsOfJoltAdaptersIn(verySmallArray)
        numberOfCombinations shouldBe 8
    }

    @Disabled
    @Test
    fun `counts number of discrete jolt adapter combinations from small set`() {
        val numberOfCombinations = countNumberOfValidCombinationsOfJoltAdaptersIn(setArray)
        numberOfCombinations shouldBe 19208
    }

    private val readArray = File(ClassLoader.getSystemResource("day10-input.txt").file).readLines().map { it.toInt() }

    private val verySmallArray = """16
10
15
5
1
11
7
19
6
12
4""".split("\n").map { it.toInt() }

    private val setArray = """28
33
18
42
31
14
46
20
48
47
24
23
49
45
19
38
39
11
1
32
25
35
8
17
7
9
4
2
34
10
3""".split("\n").map { it.toInt() }
}