package org.suggs.adventofcode

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.slf4j.LoggerFactory
import org.suggs.adventofcode.Day08HandheldHalting.Companion.instructionSetFrom
import org.suggs.adventofcode.Day08HandheldHalting.Companion.processInstructions
import java.io.File

class Day08HandheldHaltingTest {

    @Test
    fun `exits an infinite loop when repeating instruction executed in small set`() {
        val instructionExecution = processInstructions(instructionSetFrom(setInstructions))
        assertThat(instructionExecution).isEqualTo(Pair(1, 5))
    }

    @Test
    fun `exits an infinite loop when repeating instruction executed in large set`() {
        val instructionExecution = processInstructions(instructionSetFrom(readInstructions))
        assertThat(instructionExecution).isEqualTo(Pair(596, 1217))
    }

    @Test
    fun `finds flippable instructions from a failing instruction set`(){
        assertThat(Day08HandheldHalting.findFlippableInstructionToCompleteTheRun(instructionSetFrom(setInstructions))).isEqualTo(8)
    }

    @Test
    fun `finds flippable instructions from a large failing instruction set`(){
        assertThat(Day08HandheldHalting.findFlippableInstructionToCompleteTheRun(instructionSetFrom(readInstructions))).isEqualTo(501)
    }

    private val readInstructions: List<String> = File(ClassLoader.getSystemResource("day08-input.txt").file).readLines()

    private val setInstructions: List<String> = """nop +0
acc +1
jmp +4
acc +3
jmp -3
acc -99
acc +1
jmp -4
acc +6""".split("\n")
}