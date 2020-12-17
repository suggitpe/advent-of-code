package org.suggs.adventofcode

class Day07HandyHaversacks {

    companion object {

        data class BagRule(val parent: String, val number: Int, val child: String)

        fun buildRulesFromRulesSet(rules: List<String>): List<BagRule> {

            fun createRuleFrom(parent: String, number: Int, contains: String): BagRule {
                return BagRule(parent, number, contains)
            }

            fun cleanBagRules(rules: List<String>): List<String> {
                return rules.filterNot { it.contains("no other bags") }.map { it.replace("""bags|bag|\.""".toRegex(), "") }
            }

            return cleanBagRules(rules).map { bagRule ->
                val (left, right) = bagRule.split(" contain ")
                right.split(", ").map { bags ->
                    val (num, bag) = bags.split(" ", limit = 2)
                    createRuleFrom(left.trim(), num.toInt(), bag.trim())
                }
            }.flatten()
        }

        fun calculateDiscreteParentBagsFrom(rules: List<String>, bagName: String): Int {

            fun buildMapOfRulesKeyedByChild(rules: List<String>) = buildRulesFromRulesSet(rules).groupBy { it.child }

            fun calculateDiscreteParentBagsFrom(rulesMap: Map<String, List<BagRule>>, bagName: String, acc: List<String>): List<String> {
                return if (!rulesMap.containsKey(bagName))
                    acc
                else
                    rulesMap.getValue(bagName).map {
                        calculateDiscreteParentBagsFrom(rulesMap, it.parent, acc + it.parent)
                    }.flatten()
            }

            return calculateDiscreteParentBagsFrom(buildMapOfRulesKeyedByChild(rules), bagName, listOf()).toSet().size
        }


        fun calculateTheTotalContainedBagsFrom(rules: List<String>, bagName: String): Int {

            fun buildMapOfRulesKeyedByParent(rules: List<String>) = buildRulesFromRulesSet(rules).groupBy { it.parent }

            fun calculateTheTotalContainedBagsFrom(rulesMap: Map<String, List<BagRule>>, bagName: String, number: Int): Int {
                return if (!rulesMap.containsKey(bagName)) {
                    number
                } else
                    number + rulesMap.getValue(bagName).map {
                        calculateTheTotalContainedBagsFrom(rulesMap, it.child, it.number) * number
                    }.sum()
            }

            // the -1 at the end is to remove itself from the count
            return calculateTheTotalContainedBagsFrom(buildMapOfRulesKeyedByParent(rules), bagName, 1) - 1
        }
    }
}
