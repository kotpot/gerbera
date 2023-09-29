import org.kotpot.gerbera.html.templates.HomeHeader
import org.kotpot.gerbera.html.templates.impl.ThymeleafParser
import java.io.File
import kotlin.test.Test

class TemplateGenTester {
    private val curRoot: String = System.getProperty("user.dir")
    private val resourcesDir = "/src/test/resources"

    @Test
    fun genHomeBody() {
        val body = HomeHeader()
        println(body)
    }


    @Test
    fun thymeleafGenTest() {
        val parser = ThymeleafParser()
        val model = mapOf(
            "name" to "Name",
            "num" to 123
        )
        val root = File(curRoot, resourcesDir)
        val md = File(root, "/templates/post.html")
        val html = parser.parse(md, model)
        println(html)
    }
}