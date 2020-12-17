package org.suggs.adventofcode

import org.slf4j.LoggerFactory
import org.suggs.adventofcode.Day08HandheldHalting.InstructionType.*
import java.lang.IllegalStateException

class Day08HandheldHalting {

    enum class InstructionType { JMP, ACC, NOP }

    data class Instruction(var instruction: InstructionType, val amount: Int) {
        fun nextLine(fromLine: Int): Int {
            return when (instruction) {
                JMP -> fromLine + amount
                else -> fromLine + 1
            }
        }

        fun accumulation(currentAccumulator: Int): Int {
            return when (instruction) {
                ACC -> currentAccumulator + amount
                else -> currentAccumulator
            }
        }

        fun flipInstruction(){
            instruction = when(instruction){
                NOP -> JMP
                JMP -> NOP
                ACC -> ACC
            }
        }
    }

    companion object {

        private val log = LoggerFactory.getLogger(this::class.java)

        fun instructionSetFrom(listOfInstructions: List<String>): List<Instruction> {
            return listOfInstructions.map {
                val (left, right) = it.split(" ")
                Instruction(InstructionType.valueOf(left.toUpperCase()), right.toInt())
            }
        }

        fun processInstructions(instructions: List<Instruction>): Pair<Int, Int>{
            var accumulator: Int = 0
            var currentPosition = 0
            val visited = mutableListOf<Int>()
            while(!visited.contains(currentPosition) && currentPosition < instructions.size){
                visited.add(currentPosition)
                accumulator = instructions[currentPosition].accumulation(accumulator)
                currentPosition = instructions[currentPosition].nextLine(currentPosition)
            }
            return Pair(currentPosition, accumulator)
        }

        fun findFlippableInstructionToCompleteTheRun(instructions: List<Instruction>): Int{
            instructions.forEachIndexed(){ index, instruction ->
                instruction.flipInstruction()
                val result = processInstructions(instructions)
                if(result.first == instructions.size){
                    log.info("found it $instruction at $index wth accumulator ${result.second}")
                    return result.second
                }
                instruction.flipInstruction()
            }
            throw IllegalStateException("we failed to find a flippable instruction")
        }
    }


}