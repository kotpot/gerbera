package org.kotpot.gerbera.command.parser

import org.kotpot.gerbera.command.MainCommands
import org.kotpot.gerbera.command.params.ServeParams

data object ServeParser : ParamsParser<ServeParams>() {

    override val name: String = MainCommands.SERVE

    override fun createEntity(parser: InnerParser): ServeParams = parser.run {
        return ServeParams()
    }

}