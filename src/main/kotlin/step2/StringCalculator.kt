package step2

class StringCalculator(
    private val input: String,
) {
    private var operands: MutableList<Int> = mutableListOf()
    private var operators: MutableList<ArithmeticOperator> = mutableListOf()

    init {
        require(input.isNotBlank()) {
            "Input must not be null or empty."
        }

        parseInput(input)
    }

    private fun parseInput(input: String) {
        val splitInput =
            input.trim()
                .split(DELIMITER)
                .filter { it.isNotBlank() }

        require(splitInput.size >= MINIMUM_SPLIT_LENGTH) {
            "Input is not a valid expression. Must have at least two operands and one operator."
        }

        createExpression(splitInput)

        require(operands.size == operators.size + 1) {
            "Input is not a valid expression. Check the number of operators."
        }
    }

    private fun createExpression(splitInput: List<String>) {
        splitInput.chunked(2).forEach { pair ->
            val operand = pair[0]
            val operator = pair.getOrNull(1)

            parseOperand(operand)
            operator?.let {
                parseOperator(it)
            }
        }
    }

    private fun parseOperand(input: String) {
        runCatching {
            val value = input.toInt()
            operands.add(value)
        }.onFailure {
            throw IllegalArgumentException("Invalid operand: $input.")
        }
    }

    private fun parseOperator(input: String) {
        val operator = ArithmeticOperator.from(input)
        operators.add(operator)
    }

    companion object {
        private const val DELIMITER = " "
        private const val MINIMUM_SPLIT_LENGTH = 3
    }
}
