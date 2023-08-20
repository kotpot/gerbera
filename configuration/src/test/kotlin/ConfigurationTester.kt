import com.kotpot.configuration.Configuration
import java.io.File
import kotlin.test.Test

class ConfigurationTester {

    @Test
    fun read() {
        val file = File(System.getProperty("user.dir"), "src/test/kotlin")
        Configuration.init(file.absolutePath)
        println(Configuration.project)
        println(Configuration.theme)
    }
}