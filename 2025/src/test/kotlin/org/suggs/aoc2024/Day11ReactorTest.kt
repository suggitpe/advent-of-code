package org.suggs.aoc2024

import io.kotest.matchers.shouldBe
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runTest
import org.junit.jupiter.api.Disabled
import org.suggs.adventofcode.Util.getFileLinesFrom
import org.suggs.aoc2024.Day11Reactor.countRoutesFrom
import kotlin.test.Test

@OptIn(ExperimentalCoroutinesApi::class)
class Day11ReactorTest {

    @Test
    fun `counts paths from you to out - small`() = runTest {
        countRoutesFrom("you", "out", listOf(), smallData) shouldBe 5
    }

    @Test
    @Disabled
    fun `counts paths from you to out - large`() = runTest {
        countRoutesFrom("you", "out", listOf(), largeData) shouldBe 1234
    }

    @Test
    fun `counts svr routes to out - small`() = runTest {
        countRoutesFrom("svr", "out", listOf("dac", "fft"), smallSvrData) shouldBe 2
    }

    @Test
    @Disabled
    fun `counts svr routes to out - large`() = runTest {
        countRoutesFrom("svr", "out", listOf("dac", "fft"), largeData) shouldBe 2
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

    val smallSvrData = """svr: aaa bbb
aaa: fft
fft: ccc
bbb: tty
tty: ccc
ccc: ddd eee
ddd: hub
hub: fff
eee: dac
dac: fff
fff: ggg hhh
ggg: out
hhh: out""".split("\n")
}