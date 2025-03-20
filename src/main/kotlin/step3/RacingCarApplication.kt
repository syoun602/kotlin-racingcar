package step3

import step3.car.Car
import step3.car.Car.Companion.MAXIMUM_POWER
import step3.car.Car.Companion.MINIMUM_POWER
import step3.car.InputNumber
import step3.view.InputView
import step3.view.OutputView

fun main() {
    val inputNumberOfCars = InputNumber(InputView.requestNumberOfCars())
    val inputRounds = InputNumber(InputView.requestNumberOfRounds())

    val cars = List(inputNumberOfCars.value) { Car() }

    race(cars, inputRounds)
}

private fun race(
    cars: List<Car>,
    rounds: InputNumber,
) {
    repeat(rounds.value) {
        cars.forEach { car ->
            car.move { (MINIMUM_POWER..MAXIMUM_POWER).random() }
            OutputView.printCarPosition(car)
        }
        OutputView.printBlankLine()
    }
}
