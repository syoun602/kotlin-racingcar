package step3

object OutputView {
    fun printCarPosition(car: Car) {
        repeat(car.position) { print("-") }
        println()
    }

    fun printBlankLine() = println()
}
