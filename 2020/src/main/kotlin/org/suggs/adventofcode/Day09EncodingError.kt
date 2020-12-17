package org.suggs.adventofcode

import org.slf4j.LoggerFactory

class Day09EncodingError {

    companion object {
        private val log = LoggerFactory.getLogger(this::class.java)

        fun findFirstInvalidNumberAfterPreamble(transmittedNumbers: List<Long>, preambleSize: Int): Long {

            fun validateNumberWithPreamble(numberToValidate: Long, compareList: List<Long>): Boolean {
                return when {
                    compareList.isEmpty() -> false
                    compareList.contains(numberToValidate - compareList.first()) -> true
                    else -> validateNumberWithPreamble(numberToValidate, compareList.drop(1))
                }
            }

            fun validateLastNumberInListIsAddableFromMembers(numbers: List<Long>): Boolean {
                return validateNumberWithPreamble(numbers.last(), numbers.dropLast(1))
            }

            return when {
                transmittedNumbers.size < preambleSize + 1 -> throw IllegalStateException("Found no illegal numbers in the sequence")
                !validateLastNumberInListIsAddableFromMembers(transmittedNumbers.subList(0, preambleSize + 1)) -> transmittedNumbers[preambleSize]
                else -> findFirstInvalidNumberAfterPreamble(transmittedNumbers.drop(1), preambleSize)
            }
        }


    }
}
