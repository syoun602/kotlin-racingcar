package step2

import io.kotest.assertions.throwables.shouldNotThrowAny
import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.ShouldSpec
import io.kotest.matchers.string.shouldContain

class StringCalculatorTest : ShouldSpec({
    context("InputValidation") {
        should("throw exception if null or empty") {
            shouldThrow<IllegalArgumentException> {
                StringCalculator("")
            }.message shouldContain "null or empty"
        }

        should("throw exception if split strings are less than 3") {
            listOf("12 34", "12 +", "+ +").forEach {
                shouldThrow<IllegalArgumentException> {
                    StringCalculator(it)
                }
            }
        }

        should("contain at least 3 split strings") {
            listOf("12 34 56", "12  34 56", "12 + 34", "12 34 +").forEach {
                shouldNotThrowAny {
                    StringCalculator(it)
                }
            }
        }
    }
})
