package org.suggs.adventofcode

import java.io.File

object Util {
    fun createIntListFrom(fileName: String): List<Int> {
        return File(ClassLoader.getSystemResource(fileName).file).readLines().map { it.toInt() }
    }
}