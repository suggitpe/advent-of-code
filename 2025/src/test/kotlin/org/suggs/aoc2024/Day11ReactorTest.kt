package org.suggs.aoc2024

import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Disabled
import org.suggs.adventofcode.Util.getFileLinesFrom
import org.suggs.aoc2024.Day11Reactor.countRoutesFrom
import kotlin.test.Test

class Day11ReactorTest {

    @Test
    fun `counts paths from you to out - small`() {
        countRoutesFrom(smallData) shouldBe 5
    }

    @Test
    @Disabled
    fun `counts paths from you to out - large`() {
        countRoutesFrom(largeData) shouldBe 1234
    }

    val largeData = getFileLinesFrom("day11-input.txt")
    val smallData = """aaa: you hhh
you: bbb ccc
bbb: ddd eee
ccc: ddd eee fff
ddd: ggg
eee: out
fff: out
ggg: out
hhh: ccc fff iii
iii: out""".split("\n")

}