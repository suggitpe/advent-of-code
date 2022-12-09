package org.suggs.adventofcode

import java.io.File
import java.lang.System.lineSeparator

object Util {

    val doubleLineSeparator = listOf(lineSeparator(), lineSeparator()).joinToString("")

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

    fun chunkFileIntoLinesOfThree(filename: String): List<List<String>> =
        getFileLinesFrom(filename).chunked(3)

    fun applyToEachLineForTotal(filename: String, action: (String) -> Int): Int {
        var total = 0
        File(ClassLoader.getSystemResource(filename).file).forEachLine { total += action(it) }
        return total
    }

}