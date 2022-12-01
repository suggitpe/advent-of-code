package org.suggs.adventofcode

import java.io.File

object Util {

    fun createIntListFrom(fileName: String) =
        getFileLinesFrom(fileName).map { it.toInt() }


    fun createStringIntMapFrom(fileName: String): List<Pair<String, Int>> {
        return getFileLinesFrom(fileName).map {
            val (left, right) = it.split(" ")
            left to right.toInt()
        }
    }

    fun getTextBlocksFrom(fileName: String) = readFile(fileName).bufferedReader().readText().split("\n\n")

    fun getFileLinesFrom(fileName: String) = readFile(fileName).bufferedReader().readLines()

    fun readFile(fileName: String) = File(ClassLoader.getSystemResource(fileName).file)

}