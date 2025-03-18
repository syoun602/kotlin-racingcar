package step2

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.matchers.string.shouldContain
import org.junit.jupiter.api.Test

class StringCalculatorTest {
    @Test
    fun `input must not be null or empty`() {
        shouldThrow<IllegalArgumentException> {
            StringCalculator("")
        }.message shouldContain "null or empty"
    }
}
