package step2

enum class ArithmeticOperator(
    val symbol: String,
    val operate: (Int, Int) -> Int,
) {
    PLUS("+", { a, b -> a + b }),
    MINUS("-", { a, b -> a - b }),
    MULTIPLY("*", { a, b -> a * b }),
    DIVIDE("/", { a, b -> a / b }),
    ;

    companion object {
        fun from(symbol: String) =
            entries.find { it.symbol == symbol }
                ?: throw IllegalArgumentException("Invalid operator: $symbol. Use only +, -, *, /.")
    }
}
