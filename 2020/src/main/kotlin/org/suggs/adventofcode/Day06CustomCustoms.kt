package org.suggs.adventofcode

/**
 * @see https://adventofcode.com/2020/day/6
 */
class Day06CustomCustoms {

    companion object {
        fun countAllDiscreteQuestionsByGroup(answers: String): Int {
            return answers
                .split("\n\n")
                .map { it.replace("\n", "").toCharArray().toSet().count() }
                .sum()
        }

        fun countAllCommonlyAnsweredQuestionsByGroup(answers: String): Int {
            return answers
                .split("\n\n")
                .map {
                    it.split("\n")
                        .map { it.toCharArray().toList() }
                        .reduce { acc, next -> acc.intersect(next).toList() }
                }
                .flatten().count()
        }
    }
}