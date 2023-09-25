import com.kotpot.configuration.Configuration
import com.kotpot.html.templates.HomeHeader
import java.io.File
import kotlin.test.Test

class TemplateGenTester {
    private val curRootOnModuleTest: String = System.getProperty("user.dir") + "/.."
    private val testResourceDir: String = "test"

    @Test
    fun genHomeBody() {
        val file = File(curRootOnModuleTest, testResourceDir)
        Configuration.init(file.absolutePath)
        println(Configuration.project)
        println(Configuration.theme)
        val body = HomeHeader()
        println(body)
    }
}