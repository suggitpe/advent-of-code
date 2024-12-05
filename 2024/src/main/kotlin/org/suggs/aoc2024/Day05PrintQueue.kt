package org.suggs.aoc2024

import org.slf4j.LoggerFactory
import org.suggs.aoc2024.Day05PrintQueue.extractMiddleNumberFrom
import org.suggs.aoc2024.Day05PrintQueue.isValidPrintJob
import kotlin.math.abs

object Day05PrintQueue {

    fun sumMiddleNumbersFromValidPrintQueues(data: List<String>): Int =
        sumMiddleNumbersFromValidPrintQueuesFrom(readPrintJobsFrom(data.last().split("\n")))
            .using(createRulesListFrom(data.first().split(("\n"))))

    private fun sumMiddleNumbersFromValidPrintQueuesFrom(jobs: List<List<Int>>): QueueCounter = QueueCounter(jobs)

    fun correctIncorrectlyOrderedPrintJobsThenSumMedium(data: List<String>): Int =
        correctIncorrectlyOrderedPrintJobsThenSumMediumFrom(readPrintJobsFrom(data.last().split("\n")))
            .using(createRulesListFrom(data.first().split(("\n"))))

    private fun correctIncorrectlyOrderedPrintJobsThenSumMediumFrom(jobs: List<List<Int>>): QueueCorrector = QueueCorrector(jobs)

    internal fun isValidPrintJob(job: List<Int>, rules: List<Pair<Int, Int>>): Boolean =
        rules.filter { job.containsAll(listOf(it.first, it.second)) }.all { job.indexOf(it.first) < job.indexOf(it.second) }

    internal fun extractMiddleNumberFrom(setOfPages: List<Int>): Int = setOfPages.elementAt(abs(setOfPages.size / 2))

    internal fun createRulesListFrom(rules: List<String>) = rules.map { it.split("|").let { Pair(it[0].toInt(), it[1].toInt()) } }
    internal fun readPrintJobsFrom(jobs: List<String>) = jobs.map { it.split(",").map { it.toInt() }.toList() }

}

class QueueCorrector(private val jobs: List<List<Int>>) {

    fun using(rules: List<Pair<Int, Int>>) = jobs.filterNot { isValidPrintJob(it, rules) }.map { fixBrokenPrintJob(it.toMutableList(), rules) }.sumOf { extractMiddleNumberFrom(it) }

    fun fixBrokenPrintJob(job: MutableList<Int>, rules: List<Pair<Int, Int>>): List<Int> {
        val brokenRules = rules.filter { job.containsAll(listOf(it.first, it.second)) }.filterNot{job.indexOf(it.first) < job.indexOf(it.second)}
        brokenRules.reversed().forEach { rule ->
            job.removeElemValue(rule.first)
            job.insertElemAfter(rule.second, rule.first)
            if(isValidPrintJob(job, rules))
                return job
        }
        return job
    }

    private fun MutableList<Int>.removeElemValue(value: Int){
        this.remove(elementAt(indexOf(value)))
    }

    private fun MutableList<Int>.insertElemAfter(search: Int, value: Int){
        val location = indexOf(search)
        add(location, value)
    }

}

class QueueCounter(private val jobs: List<List<Int>>) {

    fun using(rules: List<Pair<Int, Int>>) = jobs.filter { isValidPrintJob(it, rules) }.sumOf { extractMiddleNumberFrom(it) }

}
