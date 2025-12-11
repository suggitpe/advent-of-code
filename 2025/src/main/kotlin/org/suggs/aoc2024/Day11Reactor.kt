package org.suggs.aoc2024

import org.slf4j.LoggerFactory

object Day11Reactor {

    private val log = LoggerFactory.getLogger(this::class.java)

    fun countRoutesFrom(startingPosition: String, devices: List<String>): Int =
        countRoutesFrom(startingPosition, buildRoutesFrom(devices), listOf(startingPosition))

    private fun countRoutesFrom(position: String, devices: Map<String, List<String>>, routeTaken: List<String>): Int =
        if (position == "out") 1
        else devices[position]?.map { countRoutesFrom(it, devices, routeTaken + it) }!!.sum()

    private fun buildRoutesFrom(devices: List<String>): Map<String, List<String>> =
        devices
            .map { device -> device.split(':') }
            .associate { it[0].trim() to it[1].trim().split(" ") }


}