package step3

class Car {
    var position = 0

    fun move(generate: () -> Int) {
        if (MOVE_THRESHOLD <= generate.invoke()) {
            position++
        }
    }

    companion object {
        private const val MOVE_THRESHOLD = 4
    }
}
