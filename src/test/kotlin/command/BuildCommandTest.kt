package command

import com.kotpot.command.params.BuildParams
import com.kotpot.command.parser.BuildParser
import org.junit.jupiter.api.Test


class BuildCommandTest {

    private fun String.toArgs() = split(" ").toTypedArray()

    @Test
    fun build() {
        val args = "build".toArgs()
        val entity = BuildParser.parse(args)
        check(entity.level == BuildParams.Level.Release)
    }

}