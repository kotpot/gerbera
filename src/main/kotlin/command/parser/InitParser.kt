package com.kotpot.command.parser

import com.kotpot.Config
import com.kotpot.command.MainCommands
import com.kotpot.command.params.InitParams

data object InitParser : ParamsParser<InitParams>() {

    override val name: String = MainCommands.INIT

    override fun createEntity(parser: InnerParser): InitParams = parser.run {
        InitParams(
            projectName = pair("name") { it ?: Config.PROJECT_NAME }
        )
    }
}