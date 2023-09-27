package org.kotpot.gerbera.executor

import org.kotpot.gerbera.command.params.ExecuteParams

sealed class CommandExecutor<EP: ExecuteParams> {

    abstract fun execute(params: EP)

}