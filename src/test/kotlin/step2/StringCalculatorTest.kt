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

    context("Calculation") {
        context("Addition") {
            should("add all input values") {
                listOf(
                    "1 + 4",
                    "2 + 3",
                    "2 + 2 + 1",
                    "4 + 1",
                ).forEach {
                    StringCalculator(it).calculate() shouldBe 5
                }
            }
        }

        context("Subtraction") {
            should("subtract all input values") {
                listOf(
                    "15 - 14",
                    "6 - 2 - 3",
                    "10 - 2 - 7",
                ).forEach {
                    StringCalculator(it).calculate() shouldBe 1
                }
            }
        }

        context("Multiplication") {
            should("multiply all input values") {
                listOf(
                    "2 * 3",
                    "6 * 2 * 4",
                    "1 * 23 * 5 * 0",
                ).map {
                    StringCalculator(it).calculate()
                } shouldBe listOf(6, 48, 0)
            }
        }

        context("Division") {
            should("divide all input values") {
                listOf(
                    "36 / 6",
                    "100 / 5 / 20",
                    "72 / 8 / 3",
                ).map {
                    StringCalculator(it).calculate()
                } shouldBe listOf(6, 1, 3)
            }
        }

        context("ComplexExpression") {
            should("calculate complex expressions") {
                listOf(
                    "2 + 6 / 2",
                    "36 / 6 * 2 + 3",
                    "88 / 22 + 3 * 6",
                ).map {
                    StringCalculator(it).calculate()
                } shouldBe listOf(4, 15, 42)
            }
        }
    }
})
