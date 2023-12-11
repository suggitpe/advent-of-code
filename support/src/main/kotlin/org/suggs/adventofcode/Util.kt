package org.suggs.adventofcode

import java.io.File
import java.lang.System.lineSeparator

object Util {

    private val doubleLineSeparator = listOf(lineSeparator(), lineSeparator()).joinToString("")

    fun createIntListFrom(fileName: String) =
        getFileLinesFrom(fileName).map { it.toInt() }

    fun createStringIntMapFrom(fileName: String) =
        getFileLinesFrom(fileName).map {
            val (left, right) = it.split(" ")
            left to right.toInt()
        }

    fun getTextBlocksFrom(fileName: String) =
        readFile(fileName).bufferedReader().readText().split(doubleLineSeparator)

    fun getFileLinesFrom(fileName: String) =
        readFile(fileName).bufferedReader().readLines()

    fun readFile(fileName: String) =
        File(ClassLoader.getSystemResource(fileName).file)

    fun readFileAsString(fileName: String) =
        readFile(fileName).bufferedReader().readText()

    fun createGridFromFileContent(fileName: String) =
        Grid(readFile(fileName).bufferedReader().readText())

    fun chunkFileIntoLinesOfThree(filename: String, chunkSize: Int = 3): List<List<String>> =
        getFileLinesFrom(filename).chunked(chunkSize)

    fun applyToEachLineForTotal(filename: String, action: (String) -> Int): Int {
        var total = 0
        File(ClassLoader.getSystemResource(filename).file).forEachLine { total += action(it) }
        return total
    }

}