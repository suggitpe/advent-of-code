package org.suggs.adventofcode

import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test
import org.suggs.adventofcode.Day09EncodingError.Companion.findEncryptionWeaknessFor
import org.suggs.adventofcode.Day09EncodingError.Companion.findFirstInvalidNumberAfterPreamble
import java.io.File

class Day09EncodingErrorTest {

    @Test
    fun `finds the first invalid number after a preamble for a short list`() {
        val firstInvalid = findFirstInvalidNumberAfterPreamble(5, shortXmasCodeExample)
        firstInvalid shouldBe 127L
    }

    @Test
    fun `finds the first invalid number after a preamble for a longer list`() {
        val firstInvalid = findFirstInvalidNumberAfterPreamble(25, longXmasCodeExample)
        firstInvalid shouldBe 90433990L
    }

    @Test
    fun `find addition of low and high from contiguous list that adds up to an invalid number`() {
        val addition: Long = findEncryptionWeaknessFor(127L, shortXmasCodeExample)
        addition shouldBe 62L
    }

    @Test
    fun `find addition of low and high from a really large contiguous list that adds up to an invalid number`() {
        val addition: Long = findEncryptionWeaknessFor(90433990L, longXmasCodeExample)
        addition shouldBe 11691646L
    }

    private val longXmasCodeExample: List<Long> = File(ClassLoader.getSystemResource("day09-input.txt").file).readLines().map { it.toLong() }

    private val shortXmasCodeExample: List<Long> = """35
20
15
25
47
40
62
55
65
95
102
117
150
182
127
219
299
277
309
576""".split("\n").map { it.toLong() }
}