package org.kotpot.gerbera.command.parser

import org.kotpot.gerbera.Config
import org.kotpot.gerbera.command.MainCommands
import org.kotpot.gerbera.command.params.InitParams

data object InitParser : ParamsParser<InitParams>() {

    override val name: String = MainCommands.INIT

    override fun createEntity(parser: InnerParser): InitParams = parser.run {
        InitParams(
            projectName = pair("name") { it ?: Config.PROJECT_NAME }
        )
    }
}