package com.kotpot.command.parser

import com.kotpot.command.MainCommands
import com.kotpot.command.params.ServeParams

data object ServeParser : ParamsParser<ServeParams>() {

    override val name: String = MainCommands.SERVE

    override fun createEntity(parser: InnerParser): ServeParams = parser.run {
        return ServeParams()
    }

}