package org.kotpot.gerbera.command.parser

import org.kotpot.gerbera.command.Commands
import org.kotpot.gerbera.command.params.ServeParams

data object ServeParser : ParamsParser<ServeParams>() {

    override val name: String = Commands.SERVE

    override fun createEntity(parser: InnerParser): ServeParams = parser.run {
        return ServeParams()
    }

}