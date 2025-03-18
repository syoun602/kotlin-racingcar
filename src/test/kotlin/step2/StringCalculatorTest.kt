package step2

import io.kotest.assertions.throwables.shouldNotThrowAny
import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.ShouldSpec
import io.kotest.matchers.shouldBe

class StringCalculatorTest : ShouldSpec({
    context("InputValidation") {
        should("throw exception if null or empty") {
            shouldThrow<IllegalArgumentException> {
                StringCalculator("")
            }
        }

        should("throw exception if split strings are less than 3") {
            listOf("12 34", "12 +", "+ +").forEach {
                shouldThrow<IllegalArgumentException> {
                    StringCalculator(it)
                }
            }
        }

        should("contain at least 3 split strings") {
            listOf("12 + 56", "12  + 56", "12 + 34", "12 + 34").forEach {
                shouldNotThrowAny {
                    StringCalculator(it)
                }
            }
        }
    }

    context("ParseSplitInput") {
        should("not throw exception if expression is correct") {
            listOf(
                "1 + 2",
                "1 + 2 + 3",
                "1 + 2 / 2 * 5",
                "5 - 1 * 2 / 4",
            ).forEach {
                shouldNotThrowAny {
                    StringCalculator(it)
                }
            }
        }

        should("throw exception if expression is wrong") {
            listOf(
                "1 + 2 +",
                "+ 1 + 11 / 2",
                "10 - 5 * 2 +",
                "* 1 + 3 / 2 +",
            ).forEach {
                shouldThrow<IllegalArgumentException> {
                    StringCalculator(it)
                }
            }
        }
    }

    context("Addition") {
        xshould("add all input values") {
            listOf(
                "1 + 4",
                "2 + 3",
                "2 + 2 + 1",
                "4 + 1",
            ).forEach {
                StringCalculator(it) shouldBe 5
            }
        }
    }
})
