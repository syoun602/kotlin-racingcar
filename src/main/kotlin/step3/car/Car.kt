package step3.car

class Car {
    var position = START_POSITION
        private set

    fun move(generatePower: () -> Int) {
        if (ENGINE_THRESHOLD <= generatePower.invoke()) {
            position++
        }
    }

    companion object {
        const val MINIMUM_POWER = 1
        const val MAXIMUM_POWER = 9

        private const val START_POSITION = 0
        private const val ENGINE_THRESHOLD = 4
    }
}
