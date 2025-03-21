package racingcar

import racingcar.car.InputNumber
import racingcar.view.InputView
import racingcar.view.OutputView

fun main() {
    val inputNumberOfCars = InputNumber(InputView.requestNumberOfCars())
    val inputRounds = InputNumber(InputView.requestNumberOfRounds())

    RacingGame(inputNumberOfCars, inputRounds)
        .start { cars ->
            cars.forEach {
                OutputView.printCarPosition(it)
            }
            OutputView.printBlankLine()
        }
}
