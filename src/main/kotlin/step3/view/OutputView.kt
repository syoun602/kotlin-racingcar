package step3.view

import step3.car.Car

object OutputView {
    fun printCarPosition(car: Car) {
        repeat(car.position) { print("-") }
        println()
    }

    fun printBlankLine() = println()
}
