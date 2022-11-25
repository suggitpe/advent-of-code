package org.suggs.adventofcode

import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test
import org.suggs.adventofcode.Day08HandheldHalting.Companion.findFlippableInstructionToCompleteTheRun
import org.suggs.adventofcode.Day08HandheldHalting.Companion.instructionSetFrom
import org.suggs.adventofcode.Day08HandheldHalting.Companion.processInstructions
import org.suggs.adventofcode.Util.getFileLinesFrom
import java.io.File

class Day08HandheldHaltingTest {

    @Test
    fun `exits an infinite loop when repeating instruction executed in small set`() {
        val instructionExecution = processInstructions(instructionSetFrom(setInstructions))
        instructionExecution shouldBe Pair(1, 5)
    }

    @Test
    fun `exits an infinite loop when repeating instruction executed in large set`() {
        val instructionExecution = processInstructions(instructionSetFrom(readInstructions))
        instructionExecution shouldBe Pair(596, 1217)
    }

    @Test
    fun `finds flippable instructions from a failing instruction set`() {
        val accumulatorAfterCompletion = findFlippableInstructionToCompleteTheRun(instructionSetFrom(setInstructions))
        accumulatorAfterCompletion shouldBe 8
    }

    @Test
    fun `finds flippable instructions from a large failing instruction set`() {
        val accumulatorAfterCompletion = findFlippableInstructionToCompleteTheRun(instructionSetFrom(readInstructions))
        accumulatorAfterCompletion shouldBe 501
    }

    private val readInstructions: List<String> = getFileLinesFrom("day08-input.txt")

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