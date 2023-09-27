import org.kotpot.gerbera.command.params.BuildParams
import org.kotpot.gerbera.command.parser.BuildParser
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