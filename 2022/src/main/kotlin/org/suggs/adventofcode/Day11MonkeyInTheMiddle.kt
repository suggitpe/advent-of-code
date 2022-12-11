package org.suggs.adventofcode

import org.slf4j.LoggerFactory

object Day11MonkeyInTheMiddle {

    private val log = LoggerFactory.getLogger(this::class.java)

    fun countMonkeyInspectionsFrom(data: List<String>, times: Int, worryAction: (Long) -> Long): Long {
        val monkeys = data.map { buildMonkeyFrom(it.split("\n")) }
        val commonDenominator = monkeys.map { it.testDivisible }.reduce { acc, it -> it * acc }
        repeat(times) {
            monkeys.forEach { it.redistributeTo(monkeys, commonDenominator, worryAction) }
        }
        monkeys.map { log.debug("${it.name} inspected items ${it.inspections} times.") }
        return monkeys.map { it.inspections }.sortedDescending().take(2).reduce { acc, it -> it * acc }
    }

    private fun buildMonkeyFrom(monkeyJuice: List<String>) =
        Monkey(
            monkeyJuice[0].substringBefore(":"),
            monkeyJuice[1].substringAfter(":").filterNot { it.isWhitespace() }.split(",").map { it.toLong() },
            monkeyJuice[2].substringAfter("=").trim().split(" ").drop(1),
            monkeyJuice[3].substringAfter(":").split(" ").last().trim().toLong(),
            monkeyJuice[4].split(" ").last().trim().toInt(),
            monkeyJuice[5].split(" ").last().trim().toInt()
        )

}

data class Monkey(
    val name: String,
    var items: List<Long>,
    val formula: List<String>,
    val testDivisible: Long,
    val trueMonkey: Int,
    val falseMonkey: Int,
    var inspections: Long = 0
) {

    fun redistributeTo(monkeys: List<Monkey>, commonDenominator: Long, worryAction: (Long) -> Long) {
        items.forEach {
            val newWorry = worryValueOf(it, commonDenominator, worryAction)
            monkeys[destinationMonkey(newWorry)].addNewItem(newWorry)
        }
        items = listOf()
    }

    private fun addNewItem(newItem: Long) {
        items += newItem
    }

    private fun worryValueOf(item: Long, commonDenominator: Long, worryAction: (Long) -> Long): Long {
        inspections++
        val factor = if (formula[1] == "old") item else formula[1].toLong()
        val worry = when (formula[0]) {
            "*" -> item * factor
            "+" -> item + factor
            else -> throw IllegalStateException("oops no idea what to do with $formula")
        }
        return worryAction(worry) % commonDenominator
    }

    private fun destinationMonkey(item: Long) =
        if (item % testDivisible == 0L) trueMonkey else falseMonkey

}
