package org.suggs.aoc_sandbox

import org.slf4j.LoggerFactory
import java.math.RoundingMode
import kotlin.random.Random

object MontyHallSimulation {

    private val log = LoggerFactory.getLogger(this::class.java)

    const val NUM_TRIALS = 10000

    enum class Strategy {
        STICK,
        SWITCH
    }

    class SimulationRunner(val doorCount: Int) {
        fun withStrategy(strategy: Strategy): Double {

            val wins = (0..NUM_TRIALS)
                .map { runMontyHallSimulation(strategy) }
                .groupingBy { it }
                .eachCount()[true]
            return ((wins!!.toDouble() / NUM_TRIALS) * 100)
                .toBigDecimal().setScale(2, RoundingMode.UP)
                .toDouble()
        }

        fun runMontyHallSimulation(strategy: Strategy): Boolean {
            require(doorCount >= 3)
            val doors = (1..doorCount).toSet()
            val prizeDoor = Random.nextInt(doorCount)
            val initialChoice = Random.nextInt(doorCount)

            val finalUnopenedDoors: List<Int> = when (initialChoice) {
                prizeDoor -> listOf(initialChoice, doors.filter { it != initialChoice }.random())
                else -> listOf(initialChoice, prizeDoor)
            }

            return when (strategy) {
                Strategy.STICK -> initialChoice == prizeDoor
                Strategy.SWITCH -> finalUnopenedDoors.first { it != initialChoice } == prizeDoor
            }
        }
    }

    fun runMontyHallSimulationWithDoorCount(doorCount: Int): SimulationRunner {
        return SimulationRunner(doorCount)
    }
}
