package org.suggs.aoc2024

import kotlin.math.abs

object Day01SecretEntrance {

    fun countOfSecretEntranceZerosFrom(commands: List<String>): Int =
        countSecretZeros(commands, 50, 0)

    private tailrec fun countSecretZeros(commands: List<String>, dialPosition: Int, countOfZeros: Int): Int =
        if (commands.isEmpty()) {
            countOfZeros
        } else {
            val newDialPosition = nextDialPosition(dialPosition, commands.first())
            countSecretZeros(commands.drop(1), newDialPosition, if (newDialPosition == 0) countOfZeros + 1 else countOfZeros)
        }

    fun countOfSpindleZeroPassesFrom(commands: List<String>): Int =
        countSpindleZeroPasses(commands, 50, 0)

    private tailrec fun countSpindleZeroPasses(commands: List<String>, dialPosition: Int, spindleZeroPasseCount: Int): Int {
        return if (commands.isEmpty()) {
            spindleZeroPasseCount
        } else {
            val newDialPosition = nextDialPosition(dialPosition, commands.first())
            val countOfZerosPasses = countPassesOrLandsOfZeroFrom(dialPosition, commands.first(), newDialPosition)
            countSpindleZeroPasses(commands.drop(1), newDialPosition, spindleZeroPasseCount + countOfZerosPasses)
        }
    }

    fun countPassesOrLandsOfZeroFrom(dialPosition: Int, command: String, newDialPosition: Int): Int {
        val moves = movements(command)
        val fullSpins = abs(moves / 100)
        val touchZero = crossZero(dialPosition, command, newDialPosition).intValue
        return fullSpins + touchZero
    }

    private fun crossZero(dialPosition: Int, command: String, newDialPosition: Int): Boolean {
        if (dialPosition == 0 && newDialPosition == 0) return false
        if (nextDialPosition(dialPosition, command) == 0) return true
        if (dialPosition == 0) return false
        if (dialPosition == newDialPosition) return false
        return if (command.first() == 'R')
            (dialPosition + (movements(command) % 100)) > 99
        else {
            (dialPosition + (movements(command) % 100)) < 0
        }
    }

    val Boolean.intValue
        get() = if (this) 1 else 0

    private fun nextDialPosition(dialPosition: Int, command: String): Int {
        val newPos = (dialPosition + movements(command)).mod(100)
        return if (newPos < 0) (newPos + 100) else newPos
    }

    private fun movements(command: String): Int =
        if (command.first() == 'L') moveCount(command) * -1 else moveCount(command)

    private fun moveCount(command: String): Int =
        command.drop(1).toInt()

}