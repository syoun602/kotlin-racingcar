package racingcar

import racingcar.view.InputView
import racingcar.view.OutputView

fun main() {
    val inputNumberOfCars = InputView.requestNumberOfCars()
    val inputNumberOfRounds = InputView.requestNumberOfRounds()

    RacingGame(inputNumberOfCars, inputNumberOfRounds)
        .start { cars ->
            cars.forEach {
                OutputView.printCarPosition(it)
            }
            OutputView.printBlankLine()
        }
}
