package step2

enum class ArithmeticOperator(
    val symbol: String,
    val operate: (Int, Int) -> Int,
) {
    PLUS("+", Int::plus),
    MINUS("-", Int::minus),
    MULTIPLY("*", Int::times),
    DIVIDE("/", Int::div),
    ;

    companion object {
        fun from(symbol: String) =
            entries.find { it.symbol == symbol }
                ?: throw IllegalArgumentException("Invalid operator: $symbol. Use only +, -, *, /.")
    }
}
