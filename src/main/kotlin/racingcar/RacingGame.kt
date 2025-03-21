package racingcar

import racingcar.car.Car

class RacingGame(
    private val cars: List<Car>,
    private val rounds: Int,
) {
    constructor(
        numberOfCars: Int,
        rounds: Int,
    ) : this(
        List(numberOfCars) { Car() },
        rounds,
    )

    fun start(result: (List<Car>) -> Unit) {
        repeat(rounds) {
            cars.forEach { car ->
                car.move()
            }

            result(cars)
        }
    }
}
