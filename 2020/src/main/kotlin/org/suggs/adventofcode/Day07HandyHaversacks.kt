package org.suggs.adventofcode

import org.slf4j.LoggerFactory

class Day07HandyHaversacks {

    companion object {

        private val log = LoggerFactory.getLogger(this::class.java)

        private fun createRuleFrom(parent: String, number: Int, contains: String): BagRule {
            return BagRule(parent, number, contains)
        }

        private fun cleanBagRules(rules: List<String>): List<String> {
            return rules.filterNot { it.contains("no other bags") }.map { it.replace("""bags|bag|\.""".toRegex(), "") }
        }

        fun buildRulesFromRulesSet(rules: List<String>): List<BagRule> {
            return cleanBagRules(rules).map {
                val (left, right) = it.split(" contain ");
                right.split(", ").map {
                    val (num, bag) = it.split(" ", limit = 2)
                    createRuleFrom(left.trim(), num.toInt(), bag.trim())
                }
            }.flatten()
        }

        fun buildMapOfRulesKeyedByChild(rules: List<String>): Map<String, List<BagRule>> {
            return buildRulesFromRulesSet(rules).groupBy { it.child }
        }

        fun calculateDiscreteParentBagsFrom(rulesMap: Map<String, List<BagRule>>, bagName: String): Int {
            return calculateDiscreteParentBagsFrom(rulesMap, bagName, listOf()).toSet().size
        }

        private fun calculateDiscreteParentBagsFrom(rulesMap: Map<String, List<BagRule>>, bagName: String, acc: List<String>): List<String> {
            return if(!rulesMap.containsKey(bagName))
                acc
            else
                rulesMap.getValue(bagName).map {
                    calculateDiscreteParentBagsFrom(rulesMap, it.parent, acc + it.parent)
                }.flatten()
        }
    }

    data class BagRule(val parent: String, val number: Int, val child: String)
}
