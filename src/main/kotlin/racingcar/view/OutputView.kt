package racingcar.view

import racingcar.car.Car

object OutputView {
    fun printCarPosition(car: Car) {
        repeat(car.position) { print("-") }
        println()
    }

    fun printBlankLine() = println()
}
