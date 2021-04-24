package chapter1.section1

import com.github.blindpirate.extensions.CaptureSystemOutput
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class Exercise22KtTest {

    @Test
    @CaptureSystemOutput
    fun rank(outputCapture: CaptureSystemOutput.OutputCapture) {
        rank(3, intArrayOf(1, 2, 3, 4, 5, 6, 7))

        assertEquals(
            """
            *0, 6
            **0, 2
            ***2, 2
        """.trimIndent(), outputCapture.toString())
    }
}
