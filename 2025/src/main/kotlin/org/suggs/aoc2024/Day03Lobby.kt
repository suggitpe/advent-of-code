package org.suggs.aoc2024

import org.slf4j.LoggerFactory

object Day03Lobby {
    private val log = LoggerFactory.getLogger(this::class.java)

    fun calculateTotalJoltageFrom(batteryBanks: List<String>, digitCount: Int): Long =
        batteryBanks.sumOf { findLargestBatteryBankFrom(it, digitCount, "") }

    private tailrec fun findLargestBatteryBankFrom(batteries: String, digitCount: Int, numberString: String): Long {
        return if(digitCount==0)
            numberString.toLong()
        else{
            val maxValue = highesCharIn(batteries.dropLast(digitCount-1))
            findLargestBatteryBankFrom(batteries.substringAfter(maxValue), digitCount-1, numberString+maxValue )
        }
    }

    fun highesCharIn(bank: String): Char=
        bank.toList().sortedDescending().take(1).first()

}