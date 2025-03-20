package step3.car

class Car {
    var position = 0

    fun move(generate: () -> Int) {
        if (MOVE_THRESHOLD <= generate.invoke()) {
            position++
        }
    }

    companion object {
        const val MINIMUM_POWER = 1
        const val MAXIMUM_POWER = 9
        private const val MOVE_THRESHOLD = 4
    }
}
