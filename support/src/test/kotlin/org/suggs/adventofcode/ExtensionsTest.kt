package org.suggs.adventofcode

import io.kotest.matchers.shouldBe
import org.suggs.adventofcode.Extensions.combinationsOf
import kotlin.test.Test

class ExtensionsTest {

    @Test
    fun `creates combinations of numbers from a list`() {
        listOf(0, 1, 2).combinationsOf(1) shouldBe listOf(listOf(0), listOf(1), listOf(2))
        listOf(0, 1, 2).combinationsOf(2) shouldBe listOf(listOf(0, 1), listOf(0, 2), listOf(1, 2))
        listOf(0, 1, 2).combinationsOf(3) shouldBe listOf(listOf(0, 1, 2))

        listOf(0, 1, 2, 3).combinationsOf(1) shouldBe listOf(listOf(0), listOf(1), listOf(2), listOf(3))
        listOf(0, 1, 2, 3).combinationsOf(2) shouldBe listOf(listOf(0, 1), listOf(0, 2), listOf(0, 3), listOf(1, 2), listOf(1, 3), listOf(2, 3))
        listOf(0, 1, 2, 3).combinationsOf(3) shouldBe listOf(listOf(0, 1, 2), listOf(0, 1, 3), listOf(0, 2, 3), listOf(1, 2, 3))
    }
}