package org.kotpot.gerbera.command.params

data class BuildParams(
    var level: Level
) : ExecuteParams() {

    enum class Level(val argValue: String) {
        Debug("debug"), Release("release");
    }

}