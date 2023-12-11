package dev.eury.advancedui.questionScreen

import androidx.annotation.RawRes
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import dev.eury.advancedui.R
import dev.eury.advancedui.data.mockList
import dev.eury.advancedui.models.Answer
import dev.eury.advancedui.models.Question
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.ensureActive
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class KaheetQuestionViewModel @Inject constructor() : ViewModel() {


    var viewState by mutableStateOf(ViewState())
        private set

    private var timerJob: Job? = null

    private var correctAnswers: Int = 0

    init {
        startTimer()
    }

    fun processEvent(event: ViewEvent) {
        when (event) {
            is ViewEvent.AnswerSelected -> onAnswerSelected(event.answer)
            ViewEvent.ShowNextQuestion -> showNextQuestion()
            ViewEvent.ShowResultDialog -> {
                viewState = viewState.copy(
                    isGameWon = correctAnswers >= MIN_RIGHT_ANSWERS,
                    showResultsDialog = true
                )
            }
        }
    }

    private fun onAnswerSelected(answer: Answer) {
        if (answer.isCorrect) correctAnswers += 1

        val animationRes = if(answer.isCorrect) R.raw.correct else R.raw.wrong
        viewState = viewState.copy(animationRes = animationRes)

        timerJob?.cancel()
    }

    private fun startTimer() {
        timerJob = viewModelScope.launch {
            while (true) {
                ensureActive()

                delay(1000)

                val updatedSecondsLeft = viewState.timeLeftInSeconds - 1

                viewState = viewState.copy(
                    timeLeftInSeconds = updatedSecondsLeft,
                    progress = updatedSecondsLeft.toFloat() / TIMER_SECONDS
                )

                if (updatedSecondsLeft == 0) {
                    timerJob?.cancel()
                    viewState = viewState.copy(animationRes = R.raw.wrong)
                    break
                }
            }
        }
    }

    private fun showNextQuestion() {
        val nextQuestionIndex = viewState.currentQuestionIndex + 1

        if (nextQuestionIndex < viewState.questionnaire.size) {
            viewState = viewState.copy(
                currentQuestionIndex = nextQuestionIndex,
                timeLeftInSeconds = TIMER_SECONDS,
                progress = 1f,
                animationRes = null
            )

            startTimer()
        } else {
            viewState = viewState.copy(animationRes = null, isGameEnded = true)
        }
    }

    data class ViewState(
        val questionnaire: List<Question> = Question.mockList().shuffled().take(MAX_QUESTIONS),
        val currentQuestionIndex: Int = 0,
        val timeLeftInSeconds: Int = TIMER_SECONDS,
        val progress: Float = 1f,
        @RawRes val animationRes: Int? = null,
        val isGameEnded: Boolean = false,
        val isGameWon: Boolean = false,
        val showResultsDialog: Boolean = false
    )

    sealed interface ViewEvent {
        data class AnswerSelected(val answer: Answer) : ViewEvent
        data object ShowNextQuestion : ViewEvent
        data object ShowResultDialog : ViewEvent
    }

    companion object {
        private const val TIMER_SECONDS = 30
        private const val MAX_QUESTIONS = 5
        private const val MIN_RIGHT_ANSWERS = (5 / 2).toInt()
    }
}