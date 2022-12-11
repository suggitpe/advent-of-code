package org.suggs.adventofcode

import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.slf4j.LoggerFactory
import org.suggs.adventofcode.Day11MonkeyInTheMiddle.countMonkeyInspectionsFrom
import org.suggs.adventofcode.Util.getTextBlocksFrom

@DisplayName("Monkey business with worrying of items")
class Day11MonkeyInTheMiddleTest {

    private val log = LoggerFactory.getLogger(this::class.java)

    @Test
    fun `counts the number of times monkeys inspect things from a small data with a worry divisor`() =
        countMonkeyInspectionsFrom(smallData, 20) { it / 3 } shouldBe 10605

    @Test
    @Disabled
    fun `counts the number of times monkeys inspect things from a large data with a worry divisor`() =
        countMonkeyInspectionsFrom(largeData, 10000) { it / 3 } shouldBe 1234

    @Test
    fun `counts the number of times monkeys inspect things from a small data with no worry divisor`() =
        countMonkeyInspectionsFrom(smallData, 10000) { it / 1 } shouldBe 2713310158

    @Test
    @Disabled
    fun `counts the number of times monkeys inspect things from a large data with no worry divisor`() =
        countMonkeyInspectionsFrom(largeData, 10000) { it / 1 } shouldBe 1234

    private val largeData = getTextBlocksFrom("day11-input.txt")
    private val smallData = """Monkey 0:
  Starting items: 79, 98
  Operation: new = old * 19
  Test: divisible by 23
    If true: throw to monkey 2
    If false: throw to monkey 3

Monkey 1:
  Starting items: 54, 65, 75, 74
  Operation: new = old + 6
  Test: divisible by 19
    If true: throw to monkey 2
    If false: throw to monkey 0

Monkey 2:
  Starting items: 79, 60, 97
  Operation: new = old * old
  Test: divisible by 13
    If true: throw to monkey 1
    If false: throw to monkey 3

Monkey 3:
  Starting items: 74
  Operation: new = old + 3
  Test: divisible by 17
    If true: throw to monkey 0
    If false: throw to monkey 1""".split("\n\n")
}