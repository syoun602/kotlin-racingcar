package step3

import step3.Car.Companion.MAXIMUM_POWER
import step3.Car.Companion.MINIMUM_POWER

fun main() {
    val numberOfCars = InputView.requestNumberOfCars()
    val cars = List(numberOfCars) { Car() }

    val rounds = InputView.requestNumberOfRounds()

    race(cars, rounds)
}

private fun race(
    cars: List<Car>,
    rounds: Int,
) {
    repeat(rounds) {
        cars.forEach { car ->
            car.move { (MINIMUM_POWER..MAXIMUM_POWER).random() }
            OutputView.printCarPosition(car)
        }
        OutputView.printBlankLine()
    }
}
