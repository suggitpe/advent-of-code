package org.suggs.adventofcode

import org.slf4j.LoggerFactory

class Day09EncodingError {

    companion object {
        private val log = LoggerFactory.getLogger(this::class.java)

        fun findFirstInvalidNumberAfterPreamble(preambleSize: Int, transmittedNumbers: List<Long>): Long {

            fun validateNumberWithPreamble(numberToValidate: Long, compareList: List<Long>): Boolean {
                return when {
                    compareList.isEmpty() -> false
                    compareList.contains(numberToValidate - compareList.first()) -> true
                    else -> validateNumberWithPreamble(numberToValidate, compareList.drop(1))
                }
            }

            fun validateLastNumberInListIsAddableFromMembers(numbers: List<Long>) = validateNumberWithPreamble(numbers.last(), numbers.dropLast(1))

            return when {
                transmittedNumbers.size < preambleSize + 1 -> throw IllegalStateException("Found no illegal numbers in the sequence")
                !validateLastNumberInListIsAddableFromMembers(transmittedNumbers.subList(0, preambleSize + 1)) -> transmittedNumbers[preambleSize]
                else -> findFirstInvalidNumberAfterPreamble(preambleSize, transmittedNumbers.drop(1))
            }
        }


        fun findEncryptionWeaknessFor(invalidNumber: Long, xmasCode: List<Long>): Long {

            fun addContiguousListFrom(end: Int, xmasCode: List<Long>) = xmasCode.subList(0, end).sum()

            fun findContiguousListSizeMatchingExactly(invalidNumber: Long, startingWith: Int, xmasCode: List<Long>): Int {
                return when {
                    startingWith > xmasCode.size -> return 0
                    addContiguousListFrom(startingWith, xmasCode) == invalidNumber -> startingWith
                    else -> findContiguousListSizeMatchingExactly(invalidNumber, startingWith + 1, xmasCode)
                }
            }

            fun findContiguousNumbersFor(invalidNumber: Long, xmasCode: List<Long>): List<Long> {
                val sizeOfContiguousList = findContiguousListSizeMatchingExactly(invalidNumber, 1, xmasCode)
                return if (sizeOfContiguousList > 0) {
                    xmasCode.subList(0, sizeOfContiguousList)
                } else
                    findContiguousNumbersFor(invalidNumber, xmasCode.drop(1))
            }

            val contiguousNumbers = findContiguousNumbersFor(invalidNumber, xmasCode).sorted()

            return contiguousNumbers.first() + contiguousNumbers.last()
        }


    }
}
