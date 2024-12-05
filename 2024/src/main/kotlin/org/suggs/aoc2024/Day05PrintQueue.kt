package org.suggs.aoc2024

import org.slf4j.LoggerFactory
import org.suggs.aoc2024.Day05PrintQueue.extractMiddleNumberFrom
import kotlin.math.abs

object Day05PrintQueue {

    fun sumMiddleNumbersFromValidPrintQueues(data: List<String>) =
        sumMiddleNumbersFromValidPrintQueuesFrom(readPrintJobsFrom(data.last().split("\n")))
            .using(createRulesListFrom(data.first().split(("\n"))))

    private fun sumMiddleNumbersFromValidPrintQueuesFrom(jobs: List<Set<Int>>) = QueueCounter(jobs)

    private fun createRulesListFrom(rules: List<String>) = rules.map { it.split("|").let { Pair(it[0].toInt(), it[1].toInt()) } }

    private fun readPrintJobsFrom(jobs: List<String>) = jobs.map { it.split(",").map { it.toInt() }.toSet() }

    internal fun extractMiddleNumberFrom(setOfPages: Set<Int>) = setOfPages.elementAt(abs(setOfPages.size / 2))

}

class QueueCounter(private val jobs: List<Set<Int>>) {

    fun using(rules: List<Pair<Int, Int>>) = jobs.filter { isValidPrintJob(it, rules) }.sumOf { extractMiddleNumberFrom(it) }

    private fun isValidPrintJob(job: Set<Int>, rules: List<Pair<Int, Int>>) =
        rules.filter { job.containsAll(listOf(it.first, it.second)) }.all { job.indexOf(it.first) < job.indexOf(it.second) }

}
