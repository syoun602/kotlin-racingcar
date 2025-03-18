package step2

class StringCalculator(
    private val input: String,
) {
    private var operands: List<Int> = emptyList()
    private var operator: List<ArithmeticOperator> = emptyList()

    init {
        require(input.isNotBlank()) {
            "Input must not be null or empty."
        }

        val splitInput = input.trim().split(DELIMITER)

        require(splitInput.size >= 3) {
            "Input is not a valid expression. Must have at least two operands and one operator."
        }
    }

    companion object {
        private const val DELIMITER = " "
    }
}
