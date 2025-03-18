package step2

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.ShouldSpec
import io.kotest.matchers.shouldBe

class ArithmeticOperatorTest : ShouldSpec({
    context("Create") {
        should("create object from symbol") {
            listOf("+", "-", "*", "/").map {
                ArithmeticOperator.from(it)
            } shouldBe
                listOf(
                    ArithmeticOperator.PLUS,
                    ArithmeticOperator.MINUS,
                    ArithmeticOperator.MULTIPLY,
                    ArithmeticOperator.DIVIDE,
                )
        }

        should("throw exception if not a known symbol") {
            listOf("^", "%", "!", "@", "#", "$").forEach {
                shouldThrow<IllegalArgumentException> {
                    ArithmeticOperator.from(it)
                }
            }
        }
    }
})
