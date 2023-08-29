import com.kotpot.common.curRootOnModuleTest
import com.kotpot.common.testResourceDir
import com.kotpot.html.markdown.htmlFromMd
import org.junit.jupiter.api.Test
import java.io.File

class MarkdownGenTester {


    @Test
    fun genCommonMd() {
        val root = File(curRootOnModuleTest, testResourceDir)
        val md = File(root, "post.md")
        val html = htmlFromMd(md)
        println(html)
    }
}