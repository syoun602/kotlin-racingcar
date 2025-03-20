package step3

import io.kotest.assertions.throwables.shouldNotThrowAny
import io.kotest.core.spec.style.ShouldSpec
import io.kotest.inspectors.forAll
import io.kotest.matchers.shouldBe

class CarTest : ShouldSpec({
    context("Create") {
        should("create a car") {
            shouldNotThrowAny {
                Car()
            }
        }

        should("position of the car be 0") {
            Car().position shouldBe 0
        }
    }

    context("Move") {
        should("move a car") {
            listOf(4, 5, 6, 7, 8, 9).forAll {
                val car = Car()
                car.move { it }

                car.position shouldBe 1
            }
        }

        should("not move a car") {
            listOf(0, 1, 2, 3).forAll {
                val car = Car()
                car.move { it }

                car.position shouldBe 0
            }
        }
    }
})
