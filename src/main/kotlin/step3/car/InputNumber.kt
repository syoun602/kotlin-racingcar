package step3.car

class InputNumber(
    val value: Int,
) {
    init {
        require(value in MINIMUM_NUMBER_INPUT..MAXIMUM_NUMBER_INPUT) {
            throw IllegalArgumentException("Invalid input. Value must be between 0 and 10.")
        }
    }

    companion object {
        private const val MINIMUM_NUMBER_INPUT = 0
        private const val MAXIMUM_NUMBER_INPUT = 10
    }
}
