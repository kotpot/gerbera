package com.kotpot

import com.kotpot.command.MainCommands
import com.kotpot.executor.CommandExecutor
import com.kotpot.command.params.ExecuteParams
import com.kotpot.command.parser.BuildParser
import com.kotpot.command.parser.InitParser
import com.kotpot.command.parser.ParamsParser
import com.kotpot.command.parser.ServeParser
import com.kotpot.executor.BuildExecutor
import com.kotpot.executor.InitExecutor
import com.kotpot.executor.ServeExecutor
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

private constructor(private val parser: Parser,private val executor: Executor) {

    fun execute(args: Array<out String>) {
        val params = parser.parse(args)
        executor.execute(params)
    }

    companion object {

        fun get(main: String) = when (main) {
            MainCommands.INIT -> CommandCombination(InitParser, InitExecutor)
            MainCommands.BUILD -> CommandCombination(BuildParser, BuildExecutor)
            MainCommands.SERVE -> CommandCombination(ServeParser, ServeExecutor)
            else -> throw IllegalArgumentException("Illegal command argument")
        }
    }

}
