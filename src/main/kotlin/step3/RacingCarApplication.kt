package step3

import step3.car.InputNumber
import step3.view.InputView
import step3.view.OutputView

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
