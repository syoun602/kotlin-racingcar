package racingcar

import racingcar.car.Car
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
                car.move()
            }

            result(cars)
        }
    }
}
