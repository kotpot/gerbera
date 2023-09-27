package org.kotpot.gerbera

import org.kotpot.gerbera.command.Commands
import org.kotpot.gerbera.executor.CommandExecutor
import org.kotpot.gerbera.command.params.ExecuteParams
import org.kotpot.gerbera.command.parser.BuildParser
import org.kotpot.gerbera.command.parser.InitParser
import org.kotpot.gerbera.command.parser.ParamsParser
import org.kotpot.gerbera.command.parser.ServeParser
import org.kotpot.gerbera.executor.BuildExecutor
import org.kotpot.gerbera.executor.InitExecutor
import org.kotpot.gerbera.executor.ServeExecutor
import java.lang.IllegalArgumentException

/**
 * Command execute flow combination.
 *
 * It contains a [ExecuteParams] for parsing [Params] object,
 * and an [CommandExecutor] that executes command based on the [Params].
 *
 * @author korilin.dev@gmail.com
 */
class CommandCombination<Params : ExecuteParams, Parser : ParamsParser<Params>, Executor : CommandExecutor<Params>>
// Create by CommandCombination.get mapping.
private constructor(private val parser: Parser, private val executor: Executor) {

    fun prepareExecutor(args: Array<out String>): () -> Unit {
        val params = parser.parse(args)
        return { executor.execute(params) }
    }

    companion object {
        private infix fun <Params : ExecuteParams> ParamsParser<Params>.combine(executor: CommandExecutor<Params>) = CommandCombination(this, executor)

        operator fun get(main: String) = when (main) {
            Commands.INIT -> InitParser combine InitExecutor
            Commands.BUILD -> BuildParser combine BuildExecutor
            Commands.SERVE -> ServeParser combine ServeExecutor
            else -> throw IllegalArgumentException("Illegal command argument")
        }
    }

}
