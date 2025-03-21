package racingcar

import racingcar.car.Car
import racingcar.car.Car.Companion.MAXIMUM_POWER
import racingcar.car.Car.Companion.MINIMUM_POWER
import racingcar.car.InputNumber

class RacingGame(
    private val cars: List<Car>,
    private val rounds: InputNumber,
) {
    constructor(
        numberOfCars: InputNumber,
        rounds: InputNumber,
    ) : this(
        List(numberOfCars.value) { Car() },
        rounds,
    )

    fun start(result: (List<Car>) -> Unit) {
        repeat(rounds.value) {
            cars.forEach { car ->
                val power = (MINIMUM_POWER..MAXIMUM_POWER).random()
                car.move { power }
            }

            result(cars)
        }
    }
}
