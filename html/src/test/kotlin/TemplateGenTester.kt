import com.kotpot.configuration.Configuration
import com.kotpot.html.templates.HomeHeader
import kotlin.test.Test

class TemplateGenTester {

    @Test
    fun genHomeBody() {
        Configuration.initWhenModelTest()
        val body = HomeHeader()
        println(body)
    }
}