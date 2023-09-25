import com.kotpot.configuration.Configuration
import java.io.File
import kotlin.test.Test

class ConfigurationTester {

    private val curRootOnModuleTest: String = System.getProperty("user.dir") + "/.."
    private val testResourceDir: String = "test"

    @Test
    fun read() {
        val file = File(curRootOnModuleTest, testResourceDir)
        Configuration.init(file.absolutePath)
        println(Configuration.project)
        println(Configuration.theme)
    }
}