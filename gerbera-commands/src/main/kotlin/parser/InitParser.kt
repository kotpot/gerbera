package org.kotpot.gerbera.command.parser

import org.kotpot.gerbera.command.Commands
import org.kotpot.gerbera.command.params.InitParams
import org.kotpot.gerbera.common.def.Config

data object InitParser : ParamsParser<InitParams>() {

    override val name: String = Commands.INIT

    override fun createEntity(parser: InnerParser): InitParams = parser.run {
        InitParams(
            projectName = pair("name") { it ?: Config.PROJECT_NAME }
        )
    }
}