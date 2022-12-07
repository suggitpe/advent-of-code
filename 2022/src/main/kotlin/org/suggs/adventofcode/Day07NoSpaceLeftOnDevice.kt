package org.suggs.adventofcode

import org.slf4j.LoggerFactory

object Day07NoSpaceLeftOnDevice {

    private val log = LoggerFactory.getLogger(this::class.java)

    fun sumDirectoriesOver100KFrom(commands: List<String>): Long {
        val root = Dir(NullNode(), "/", listOf())
        buildTreeFrom(commands.map { it.trim() }, root)
        return sumValueOfTreeLessThan100k(root)
    }

    fun findDirectoryThatFreesUpSpaceForUpdateFrom(commands: List<String>): Long {
        val root = Dir(NullNode(), "/", listOf())
        buildTreeFrom(commands.map { it.trim() }, root)
        val spaceNeeded = 30000000 - (70000000 - sumValueOfTree(root))
        return findAllDirectorySizes(root).filter { it > spaceNeeded }.minOf { it }
    }

    private fun sumValueOfTreeLessThan100k(tree: Dir): Long =
        findAllDirectorySizes(tree).filter { it < 100000 }.sum()

    private fun findAllDirectorySizes(context: Dir): List<Long> =
        (listOf(sumValueOfTree(context)) + context.files.filterIsInstance<Dir>().flatMap { findAllDirectorySizes(it) })

    private fun sumValueOfTree(tree: Dir): Long =
        tree.files.filterIsInstance<File>().sumOf { (it).size } +
                tree.files.filterIsInstance<Dir>().sumOf { sumValueOfTree(it) }

    private fun buildTreeFrom(commands: List<String>, context: Dir): Dir =
        when {
            commands.isEmpty() -> context
            else -> buildTreeFrom(commands.drop(1), process(commands.first(), context))
        }

    private fun process(command: String, context: Dir): Dir {
        return when {
            command.isEmpty() -> context
            command.startsWith("cd /") -> context
            command.startsWith("cd ..") -> context.parent as Dir
            command.startsWith("cd ") -> context.files.filter { it.name() == command.split(" ")[1] }.first() as Dir
            command.startsWith("ls") -> addNodesTo(command.split("\n").drop(1), context)
            else -> throw IllegalStateException("I dont know how to process this one [$command]")
        }
    }

    private fun addNodesTo(files: List<String>, context: Dir): Dir {
        return when {
            files.isEmpty() -> context
            else -> {
                context.files = context.files + createNodeFrom(files.first(), context)
                addNodesTo(files.drop(1), context)
            }
        }
    }

    private fun createNodeFrom(node: String, parent: Dir): Node {
        return when {
            node.startsWith("dir") -> Dir(parent, node.split(" ")[1], listOf())
            else -> File(parent, node.split(" ")[1], node.split(" ")[0].toLong())
        }
    }

}

interface Node {
    fun parent(): Node
    fun name(): String
}

data class File(var parent: Node, var name: String, var size: Long) : Node {
    override fun parent() = parent
    override fun name() = name
}

data class Dir(var parent: Node, var name: String, var files: List<Node>) : Node {
    override fun parent() = parent
    override fun name() = name
}

class NullNode : Node {
    override fun parent(): Node {
        TODO("Not yet implemented")
    }

    override fun name(): String {
        TODO("Not yet implemented")
    }

}
