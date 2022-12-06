package org.suggs.adventofcode

import java.util.*

/**
 * Hate this solution ...
 */
object Day05SupplyStacks {

    fun calculateStackTopsFrom(data: List<String>, treatAsStack: Boolean): String {
        val stacks = createInitialStacksFrom(data.first())
        return applyMovesToStacks(stacks, data.last().split("\n"), treatAsStack)
    }

    private fun applyMovesToStacks(stacks: List<Stack<Char>>, moves: List<String>, treatAsStack: Boolean): String {
        if (moves.isEmpty()) {
            return stacks.map { it.peek() }.joinToString("")
        }

        val (amount, src, dest) = moves.first().split(" ").filter { it.contains(Regex("^\\d+\$")) }.map { it.toInt() }

        if (treatAsStack && amount > 1) {
            repeat(amount) {
                stacks[dest - 1].push(stacks[src - 1].pop())
            }
        } else {
            var tempStack = Stack<Char>()
            repeat(amount) {
                tempStack.push(stacks[src - 1].pop())
            }
            repeat(amount) {
                stacks[dest - 1].push(tempStack.pop())
            }
        }

        return applyMovesToStacks(stacks, moves.drop(1), treatAsStack)
    }

    private fun createInitialStacksFrom(rawStacks: String): List<Stack<Char>> {

        val stackData = rawStacks
            .split("\n")
            .filter { !it.contains("1") && !it.contains("2") }
            .reversed()
            .map { " $it" }
            .map { it.chunked(4).map { chunk -> chunk[2] } }

        val stacks = mutableListOf<Stack<Char>>()

        stackData.forEach {
            it.forEachIndexed { index, elem ->
                if (stacks.size <= index) {
                    stacks.add(index, Stack<Char>())
                }
                if (elem.isLetter()) {
                    stacks[index].add(elem)
                }
            }
        }
        return stacks
    }
}