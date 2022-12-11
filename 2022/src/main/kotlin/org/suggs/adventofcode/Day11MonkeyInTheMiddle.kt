package org.suggs.adventofcode

import org.slf4j.LoggerFactory

object Day11MonkeyInTheMiddle {

    private val log = LoggerFactory.getLogger(this::class.java)

    fun countMonkeyInspectionsFrom(data: List<String>, times: Int, worryAction: (Long) -> Long): Long {
        val monkeys = data.map { buildMonkeyFrom(it) }
        val commonDenominator = monkeys.map { it.testDivisible }.reduce { acc, it -> it * acc }
        repeat(times) {
            monkeys.forEach { it.redistributeTo(monkeys, commonDenominator, worryAction) }
        }
        monkeys.map { log.debug("$it") }
        monkeys.map { it.debugInspections() }
        return monkeys.map { it.inspections }.sortedDescending().take(2).reduce { acc, it -> it * acc }
    }

    private fun buildMonkeyFrom(monkeyJuice: String): Monkey {
        val lines = monkeyJuice.split("\n")
        return Monkey(
            lines[0].substringBefore(":"),
            lines[1].substringAfter(":").filterNot { it.isWhitespace() }.split(",").map { it.toLong() },
            lines[2].substringAfter("=").trim().split(" ").drop(1),
            lines[3].substringAfter(":").split(" ").last().trim().toLong(),
            lines[4].split(" ").last().trim().toInt(),
            lines[5].split(" ").last().trim().toInt()
        )
    }
}

data class Monkey(
    private val name: String,
    private var items: List<Long>,
    private val formula: List<String>,
    val testDivisible: Long,
    private val trueMonkey: Int,
    private val falseMonkey: Int,
    var inspections: Long = 0
) {

    private val log = LoggerFactory.getLogger(this::class.java)

    fun redistributeTo(monkeys: List<Monkey>, commonDenominator: Long, worryAction: (Long) -> Long) {
        if (items.isEmpty())
            return
        else {
            inspections += 1
            val newWorry = worryValueOf(items.first(), commonDenominator, worryAction)
            monkeys[testIt(newWorry)].addNewItem(newWorry)
            items = items.drop(1)
            redistributeTo(monkeys, commonDenominator, worryAction)
        }
    }

    fun debugInspections() {
        log.debug("$name inspected items $inspections times.")
    }

    private fun addNewItem(newItem: Long) {
        items += newItem
    }

    private fun worryValueOf(item: Long, commonDenominator: Long, worryAction: (Long) -> Long): Long {
        val factor = if (formula[1] == "old") item else formula[1].toLong()
        val worry = when (formula[0]) {
            "*" -> item * factor
            "+" -> item + factor
            else -> throw IllegalStateException("oops no idea what to do with $formula")
        }
        return worryAction(worry) % commonDenominator
    }

    private fun testIt(item: Long): Int {
        return if (item % testDivisible == 0L) trueMonkey else falseMonkey
    }
}
