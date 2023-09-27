package org.kotpot.gerbera.command.parser

import org.kotpot.gerbera.command.params.ExecuteParams

sealed class ParamsParser<EP : ExecuteParams> {

    abstract val name: String

    protected abstract fun createEntity(parser: InnerParser): EP

    fun parse(args: Array<out String>): EP {
        val parser = InnerParser(args)
        val main = parser.consume()
        require(main == name) { "Un supported Parse named $name is matched by $main" }
        val entity = createEntity(parser)
        val remaining = parser.firstArgRemaining
        require(remaining == null) { "Unknown argument: $remaining" }
        return entity
    }


    /**
     * Command argument parser.
     * The convention formats which are supported include:
     * - Argument name directly, see [match]
     * - Key-Value Pair starting with `--`, like `--mode=debug`, see [pair]
     */
    protected class InnerParser(args: Array<out String>) {

        companion object {
            private const val PAIR_PREFIX = "--"
            private const val PAIR_SPLIT_CHAR = "="
        }

        private val arguments = args.toMutableList()

        val firstArgRemaining get() = arguments.firstOrNull()

        fun consume(): String {
            return arguments.removeFirst()
        }

        fun <T> match(arg: String, convert: (match: String?) -> T): T {
            val match = arguments.find { it == arg }
            arguments.remove(match)
            return convert(match)
        }

        fun <T> pair(key: String, convert: (value: String?) -> T): T {
            val matchPrefix = PAIR_PREFIX.plus(key).plus(PAIR_SPLIT_CHAR)
            val match = arguments.find { it.startsWith(matchPrefix) }
            arguments.remove(match)
            val value = match?.split(PAIR_SPLIT_CHAR)?.get(1)
            return convert(value)
        }

    }
}
