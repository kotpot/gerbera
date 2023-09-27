
import org.kotpot.gerbera.html.markdown.MarkdownConstitute
import org.junit.jupiter.api.Test
import java.io.File

class MarkdownGenTester {

    private val curRootOnModuleTest: String = System.getProperty("user.dir") + "/.."
    private val testResourceDir: String = "test"

    @Test
    fun genCommonMd() {
        val root = File(curRootOnModuleTest, testResourceDir)
        val md = File(root, "post.md")
        val post = MarkdownConstitute.parse(md)
        println(post.frontMatter)
        println(post.postContent)
    }
}