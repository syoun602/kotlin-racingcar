package step3

object InputView {
    fun requestNumberOfCars(): Int {
        println("How many cars are in the race?")
        return readlnOrNull()?.toInt()
            ?: throw IllegalStateException("No car names were provided.")
    }

    fun requestNumberOfRounds(): Int {
        println("How many rounds will be played?")
        return readlnOrNull()?.toInt()
            ?: throw IllegalStateException("No rounds were provided.")
    }
}
