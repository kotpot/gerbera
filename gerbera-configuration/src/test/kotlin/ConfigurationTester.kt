import org.kotpot.gerbera.configuration.Configuration
import java.io.File
import kotlin.test.Test

class ConfigurationTester {

    private val curRoot: String = System.getProperty("user.dir")
    private val resourcesDir = "/src/test/resources"

    @Test
    fun read() {
        val file = File(curRoot, resourcesDir)
        val config = Configuration.init(file.absolutePath)
        check(config.project.isNotEmpty())
        check(config.theme.isNotEmpty())
    }
}