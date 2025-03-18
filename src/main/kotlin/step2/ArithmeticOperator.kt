package step2

enum class ArithmeticOperator(val symbol: String) {
    PLUS("+"),
    MINUS("-"),
    MULTIPLY("*"),
    DIVIDE("/"),
    ;

    companion object {
        fun from(symbol: String) =
            entries.find { it.symbol == symbol }
                ?: throw IllegalArgumentException("Unknown operator: $symbol. Use only +, -, *, /")
    }
}
