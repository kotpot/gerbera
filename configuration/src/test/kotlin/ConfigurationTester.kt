import com.kotpot.configuration.Configuration
import java.io.File
import kotlin.test.Test

class ConfigurationTester {

    @Test
    fun read() {
        Configuration.initOnTest()
    }
}