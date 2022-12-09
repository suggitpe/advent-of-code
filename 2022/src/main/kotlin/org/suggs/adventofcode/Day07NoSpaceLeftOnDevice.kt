package org.suggs.adventofcode

object Day07NoSpaceLeftOnDevice {

    fun sumDirectoriesOver100KFrom(commands: List<String>): Long =
        findAllDirectorySizes(buildTreeFrom(commands)).filter { it < 100000 }.sum()

    fun findDirectoryThatFreesUpSpaceForUpdateFrom(commands: List<String>): Long {
        val root = buildTreeFrom(commands)
        return findAllDirectorySizes(root).filter { it > spaceNeededFrom(root) }.minOf { it }
    }

    private fun spaceNeededFrom(root: Dir) =
        (30000000 - (70000000 - sumValueOfTree(root)))

    private fun findAllDirectorySizes(context: Dir): List<Long> =
        (listOf(sumValueOfTree(context)) + context.files.filterIsInstance<Dir>().flatMap { findAllDirectorySizes(it) })

    private fun sumValueOfTree(tree: Dir): Long =
        tree.files.filterIsInstance<File>().sumOf { (it).size } +
                tree.files.filterIsInstance<Dir>().sumOf { sumValueOfTree(it) }

    private fun buildTreeFrom(commands: List<String>): Dir {
        fun buildTreeFrom(commands: List<String>, context: Dir): Dir =
            when {
                commands.isEmpty() -> context
                else -> buildTreeFrom(commands.drop(1), process(commands.first(), context))
            }
        return buildTreeFrom(commands, Dir(NullNode(), "/", listOf())).findRoot()
    }

    private fun process(command: String, context: Dir): Dir =
        when {
            command.isEmpty() -> context
            command.startsWith("cd /") -> context
            command.startsWith("cd ..") -> context.parent as Dir
            command.startsWith("cd ") -> context.files.filter { it.name() == command.split(" ")[1] }.first() as Dir
            command.startsWith("ls") -> addNodesTo(command.split("\n").drop(1), context)
            else -> throw IllegalStateException("I dont know how to process this one [$command]")
        }

    private fun addNodesTo(files: List<String>, context: Dir): Dir =
        when {
            files.isEmpty() -> context
            else -> {
                context.files = context.files + createNodeFrom(files.first(), context)
                addNodesTo(files.drop(1), context)
            }
        }

    private fun createNodeFrom(node: String, parent: Dir): Node =
        when {
            node.startsWith("dir") -> Dir(parent, node.split(" ")[1], listOf())
            else -> File(parent, node.split(" ")[1], node.split(" ")[0].toLong())
        }
}

interface Node {
    fun parent(): Node
    fun name(): String
}

data class File(val parent: Node, val name: String, val size: Long) : Node {
    override fun parent() = parent
    override fun name() = name
}

data class Dir(val parent: Node, val name: String, var files: List<Node>) : Node {
    override fun parent() = parent
    override fun name() = name
    fun findRoot(): Dir {
        return when {
            parent is Dir -> parent.findRoot()
            parent is NullNode -> this
            else -> throw IllegalStateException("shit or bust")
        }
    }
}

class NullNode : Node {
    override fun parent(): Node {
        TODO("Not yet implemented")
    }

    override fun name(): String {
        TODO("Not yet implemented")
    }

}
