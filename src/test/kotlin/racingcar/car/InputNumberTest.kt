package racingcar.car

import io.kotest.assertions.throwables.shouldNotThrowAny
import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.ShouldSpec
import io.kotest.inspectors.forAll

class InputNumberTest : ShouldSpec({
    context("Create") {
        should("create object") {
            listOf(0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10).forAll {
                shouldNotThrowAny {
                    InputNumber(it)
                }
            }
        }

        should("throw IllegalArgumentException") {
            listOf(-2, -1, 11, 12).forAll {
                shouldThrow<IllegalArgumentException> {
                    InputNumber(it)
                }
            }
        }
    }
})
