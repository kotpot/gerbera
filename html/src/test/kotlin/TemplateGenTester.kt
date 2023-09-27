import com.kotpot.html.templates.HomeHeader
import kotlin.test.Test

class TemplateGenTester {
    @Test
    fun genHomeBody() {
        val body = HomeHeader()
        println(body)
    }
}