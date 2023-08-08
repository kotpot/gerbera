package com.kotpot.command.parser

import com.kotpot.command.MainCommands
import com.kotpot.command.params.BuildParams

data object BuildParser : ParamsParser<BuildParams>() {

    override val name: String = MainCommands.BUILD

    override fun createEntity(parser: InnerParser): BuildParams = parser.run {
        BuildParams(
            level = pair("level") { it.convertToLevel() }
        )
    }

}


private fun String?.convertToLevel(): BuildParams.Level {
    if (this == null) return BuildParams.Level.Release
    val level = BuildParams.Level.entries.find { it.argValue == this }
    require(level != null) {
        "Illegal build argument level=$this"
    }
    return level
}