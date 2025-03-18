package step2

class StringCalculator(
    private val input: String,
) {
    init {
        require(input.isNotBlank()) {
            "Input must not be null or empty."
        }
    }
}
