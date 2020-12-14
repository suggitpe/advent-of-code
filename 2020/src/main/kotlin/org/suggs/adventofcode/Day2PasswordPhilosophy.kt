package org.suggs.adventofcode

/**
 * @see https://adventofcode.com/2020/day/2
 */
data class Day2PasswordPhilosophy(
    private val range: Pair<Int, Int>,
    private val testCharacter: Char,
    private val password: String
) {

    companion object {
        fun createPhilosophyFrom(passwordString: String): Day2PasswordPhilosophy {
            val splits = passwordString.split(" ")
            return Day2PasswordPhilosophy(pairOfIntsFrom(splits[0]), splits[1][0], splits[2])
        }

        private fun pairOfIntsFrom(range: String): Pair<Int, Int> {
            val split = range.split("-")
            return Pair(split[0].toInt(), split[1].toInt())
        }
    }

    fun isValidByRange(): Boolean {
        fun rangeOf(range: Pair<Int, Int>): IntRange {
            return range.first.rangeTo(range.second)
        }

        return rangeOf(range).contains(password.filter { it == testCharacter }.count())
    }

    fun isValidByPosition(): Boolean {
        // note the use of xor to check only one of 
        return (password[range.first - 1] == testCharacter) xor (password[range.second - 1] == testCharacter)
    }

    override fun toString(): String {
        return "Day2PasswordPhilosophy(range=$range, testCharacter=$testCharacter, password='$password')"
    }


}