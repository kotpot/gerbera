package com.kotpot.executor

import com.kotpot.command.params.ExecuteParams

sealed class CommandExecutor<EP: ExecuteParams> {

    abstract fun execute(params: EP)

}