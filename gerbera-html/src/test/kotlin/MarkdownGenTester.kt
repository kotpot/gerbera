
import org.kotpot.gerbera.html.markdown.MarkdownConstitute
import org.junit.jupiter.api.Test
import java.io.File

class MarkdownGenTester {

    private val curRoot: String = System.getProperty("user.dir")
    private val resourcesDir = "/src/test/resources"

    @Test
    fun genCommonMd() {
        val root = File(curRoot, resourcesDir)
        val md = File(root, "post.md")
        val post = MarkdownConstitute.parse(md)
        check(post.frontMatter.isNotEmpty())
        check(post.postContent.isNotEmpty())
    }
}