package org.suggs.adventofcode

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.suggs.adventofcode.Day09EncodingError.Companion.findFirstInvalidNumberAfterPreamble
import java.io.File

class Day09EncodingErrorTest {

    @Test
    fun `finds the first invalid number after a preamble for a short list`() {
        assertThat(findFirstInvalidNumberAfterPreamble(shortXmasCodeExample, 5)).isEqualTo(127L)
    }

    @Test
    fun `finds the first invalid number after a preamble for a longer list`() {
        assertThat(findFirstInvalidNumberAfterPreamble(longXmasCodeExample, 25)).isEqualTo(90433990L)
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