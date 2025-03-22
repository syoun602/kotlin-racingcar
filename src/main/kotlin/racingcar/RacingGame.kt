package racingcar

import racingcar.car.Car

class RacingGame(
    private val cars: List<Car>,
    private val rounds: Int,
) {
    private val gameResult = mutableListOf<RaceResult>()

    constructor(
        numberOfCars: Int,
        rounds: Int,
    ) : this(
        List(numberOfCars) { Car() },
        rounds,
    )

    fun start() {
        repeat(rounds) {
            cars.forEach { it.move() }
            val roundResult = RaceResult(cars.map { it.position })
            gameResult.add(roundResult)
        }
    }

    fun getResult() = gameResult.toList()
}
