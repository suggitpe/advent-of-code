package org.suggs.aoc2024

import org.slf4j.LoggerFactory

object Day11Reactor {

    private val log = LoggerFactory.getLogger(this::class.java)

    fun countRoutesFrom(devices: List<String>): Int =
        countRoutesFrom("you", buildRoutesFrom(devices))

    private fun countRoutesFrom(position: String, devices: Map<String, List<String>>): Int =
        if (position == "out") 1
        else devices[position]?.map { countRoutesFrom(it, devices) }!!.sum()

    private fun buildRoutesFrom(devices: List<String>): Map<String, List<String>> =
        devices
            .map { device -> device.split(':') }
            .associate { it[0].trim() to it[1].trim().split(" ") }


}