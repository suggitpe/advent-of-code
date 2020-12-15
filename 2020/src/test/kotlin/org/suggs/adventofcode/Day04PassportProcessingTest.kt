package org.suggs.adventofcode

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.slf4j.LoggerFactory
import java.io.File

/**
 * @see https://adventofcode.com/2020/day/4
 */
class Day04PassportProcessingTest {

    private val log = LoggerFactory.getLogger(this::class.java)

    @Test
    fun `read passports from the fixed text`() {
        val passports = extractPassportsFromText(setTextPassportList())
        assertThat(passports.size).isEqualTo(4)
    }

    @Test
    fun `read passports from the input file`() {
        val passports = extractPassportsFromText(readPassportDataFromFile("day04-input.txt"))
        assertThat(passports.size).isEqualTo(282)
    }

    @Test
    fun `read passports from the set text and filter out all the invalid ones`() {
        val validPassports = extractPassportsFromText(setTextPassportList())
            .filter { it.isValid() }
        assertThat(validPassports.size).isEqualTo(2)
    }

    @Test
    fun `read passports from the file input and filter out all the invalid ones`() {
        val validPassports = extractPassportsFromText(readPassportDataFromFile("day04-input.txt"))
            .filter { it.isValid() }
        assertThat(validPassports.size).isEqualTo(250)
    }

    @Test
    fun `read passports from the set text and filter out all the strictly invalid ones`() {
        val validPassports = extractPassportsFromText(setTextPassportList())
            .filter { it.isStrictlyValid() }
        assertThat(validPassports.size).isEqualTo(2)
    }

    @Test
    fun `read passports from the file input and filter out all the strictly invalid ones`() {
        val validPassports = extractPassportsFromText(readPassportDataFromFile("day04-input.txt"))
            .filter { it.isStrictlyValid() }
        log.info("total number of passports that are strictly valid is ${validPassports.size}")
        assertThat(validPassports.size).isEqualTo(161)
    }


    private fun extractPassportsFromText(passportData: String): List<Day04PassportProcessing> {
        return passportData
            .split("\n\n")
            .map { it.replace("\n", " ") }
            .map { it.split(" ") }
            .map { it.map { val (left, right) = it.split(":"); left to right }.toMap() }
            .map { Day04PassportProcessing.createPassportFrom(it) }
    }

    private fun readPassportDataFromFile(nameOfFile: String): String {
        return File(ClassLoader.getSystemResource(nameOfFile).file).readText()
    }

    private fun setTextPassportList(): String {
        return """ecl:gry pid:860033327 eyr:2020 hcl:#fffffd
byr:1937 iyr:2017 cid:147 hgt:183cm

iyr:2013 ecl:amb cid:350 eyr:2023 pid:028048884
hcl:#cfa07d byr:1929

hcl:#ae17e1 iyr:2013
eyr:2024
ecl:brn pid:760753108 byr:1931
hgt:179cm

hcl:#cfa07d eyr:2025 pid:166559648
iyr:2011 ecl:brn hgt:59in"""
    }


}
