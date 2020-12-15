package org.suggs.adventofcode

data class Day04PassportProcessing(private val data: Map<String, String>) {

    private val validationFunctions: Map<String, (String) -> Boolean> = mapOf(
        "byr" to { it.length == 4 && it.toInt() in 1920..2002 },
        "iyr" to { it.length == 4 && it.toInt() in 2010..2020 },
        "eyr" to { it.length == 4 && it.toInt() in 2020..2030 },
        "hgt" to {
            val unit = it.drop(it.length - 2)
            val digit = it.dropLast(2)
            listOf("in", "cm").contains(unit)
                    && (if (unit == "in") digit.toInt() in 59..76 else digit.toInt() in 150..193)
        },
        "hcl" to { Regex("^(#[0-9a-f]{6})$").matches(it) },
        "ecl" to { listOf("amb", "blu", "brn", "gry", "grn", "hzl", "oth").contains(it) },
        "pid" to { Regex("^(\\d{9})$").matches(it) }
    )

    companion object {
        fun createPassportFrom(data: Map<String, String>): Day04PassportProcessing {
            return Day04PassportProcessing(data)
        }
    }

    fun isValid(): Boolean {
        return data.keys.containsAll(validationFunctions.keys)
    }

    fun isStrictlyValid(): Boolean {
        return isValid()
                && validationFunctions.keys.all { validationFunctions.getValue(it).invoke(data.getValue(it)) }
    }
}