package dev.eury.advancedui.models

data class Question(
    val text: String,
    val answers: List<Answer>
) {
    companion object
}

data class Answer(
    val text: String,
    val isCorrect: Boolean
)


