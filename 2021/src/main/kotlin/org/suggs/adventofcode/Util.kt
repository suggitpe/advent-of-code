package org.suggs.adventofcode

import java.io.File

object Util {

    fun createIntListFrom(fileName: String): List<Int> {
        return getFileLinesFrom(fileName).map { it.toInt() }
    }

    fun createStringIntMapFrom(fileName: String): List<Pair<String, Int>> {
        return getFileLinesFrom(fileName).map {
            val (left, right) = it.split(" ")
            left to right.toInt()
        }
    }

    private fun getFileLinesFrom(fileName: String): List<String> {
        return File(ClassLoader.getSystemResource(fileName).file).readLines()
    }
}