package org.suggs.aoc_sandbox

import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.slf4j.LoggerFactory
import org.suggs.aoc_sandbox.MontyHallSimulation.Strategy.STICK
import org.suggs.aoc_sandbox.MontyHallSimulation.Strategy.SWITCH
import org.suggs.aoc_sandbox.MontyHallSimulation.runMontyHallSimulationWithDoorCount

@DisplayName("Monty Hall Simulator")
class MontyHallSimulationTest {

    private val log = LoggerFactory.getLogger(this::class.java)

    @Test
    fun `run simulation for 10000 iterations`() {
        val stick = runMontyHallSimulationWithDoorCount(3).withStrategy(STICK)
        val switch = runMontyHallSimulationWithDoorCount(3).withStrategy(SWITCH)
        log.debug("Simulation for STICK yields ${stick}%, compared to ${switch}% for SWITCH")
    }
}
