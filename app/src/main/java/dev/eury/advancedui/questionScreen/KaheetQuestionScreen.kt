package dev.eury.advancedui.questionScreen

import androidx.annotation.RawRes
import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Divider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.animateLottieCompositionAsState
import com.airbnb.lottie.compose.rememberLottieComposition
import dev.eury.advancedui.R
import dev.eury.advancedui.models.Answer
import dev.eury.advancedui.questionScreen.KaheetQuestionViewModel.ViewEvent
import dev.eury.advancedui.questionScreen.KaheetQuestionViewModel.ViewState
import dev.eury.advancedui.ui.theme.AdvancedUI3DAnimationWithComposeTheme

@Composable
fun KaheetQuestionScreen(
    modifier: Modifier = Modifier,
    viewModel: KaheetQuestionViewModel = hiltViewModel(),
) {
    val viewState = viewModel.viewState

    KaheetQuestionScreen(viewState, viewModel::processEvent, modifier)

    if (viewState.showResultsDialog) {
        KaheetGameResultDialog(isGameWon = viewState.isGameWon)
    }
}

@Composable
private fun KaheetQuestionScreen(
    viewState: ViewState,
    onEvent: (ViewEvent) -> Unit,
    modifier: Modifier = Modifier,
) {
    val currentQuestion = remember(viewState.currentQuestionIndex) {
        viewState.questionnaire[viewState.currentQuestionIndex]
    }

    Box(modifier = modifier) {
        Column {
            AnimatedContent(targetState = currentQuestion.text, label = "") { text ->
                Text(
                    text = text,
                    modifier = Modifier.padding(vertical = 40.dp, horizontal = 20.dp),
                    fontWeight = FontWeight.Bold
                )
            }

            AnimatedContent(targetState = currentQuestion.answers, label = "") { list ->
                AnswerList(
                    modifier = Modifier.padding(start = 10.dp, end = 20.dp),
                    answers = list,
                    onEvent = onEvent
                )
            }

            Spacer(modifier = Modifier.weight(1f))

            Divider()

            TimeIndicatorSection(
                modifier = Modifier.padding(20.dp),
                viewState.timeLeftInSeconds,
                viewState.progress
            )
        }

        viewState.animationRes?.let {
            FullScreenAnimation(
                animationRes = it,
                modifier = Modifier
                    .size(300.dp)
                    .align(Alignment.Center),
                onAnimationFinished = {
                    onEvent(ViewEvent.ShowNextQuestion)
                }
            )
        }

        if (viewState.isGameEnded) {
            FullScreenAnimation(
                animationRes = R.raw.confetti_fullscreen,
                contentScale = ContentScale.FillHeight,
                modifier = Modifier.fillMaxHeight(),
                onAnimationFinished = {
                    onEvent(ViewEvent.ShowResultDialog)
                }
            )
        }
    }
}

@Composable
private fun AnswerList(
    answers: List<Answer>,
    onEvent: (ViewEvent) -> Unit,
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.spacedBy(15.dp)
    ) {
        answers.forEach { answer ->
            Text(
                text = answer.text,
                modifier = Modifier
                    .fillMaxWidth()
                    .clip(shape = RoundedCornerShape(5.dp))
                    .background(Color(0xFFDFF1FA))
                    .clickable { onEvent(ViewEvent.AnswerSelected(answer)) }
                    .padding(15.dp)
            )
        }
    }
}

@Composable
private fun TimeIndicatorSection(
    modifier: Modifier = Modifier,
    secondsLeft: Int,
    progress: Float,
) {
    val animatedProgress: Float by animateFloatAsState(progress, label = "")

    Row(
        modifier = modifier,
        verticalAlignment = Alignment.CenterVertically
    ) {
        CircularProgressIndicator(
            progress = animatedProgress,
            modifier = Modifier
                .padding(end = 10.dp)
                .size(30.dp)
        )

        Text(text = "$secondsLeft seconds left")
    }
}

@Composable
private fun FullScreenAnimation(
    @RawRes animationRes: Int,
    onAnimationFinished: () -> Unit,
    modifier: Modifier = Modifier,
    contentScale: ContentScale = ContentScale.Fit,
) {
    val composition by rememberLottieComposition(LottieCompositionSpec.RawRes(animationRes))

    val progress by animateLottieCompositionAsState(composition)

    LottieAnimation(
        composition = composition,
        contentScale = contentScale,
        progress = { progress },
        modifier = modifier
    )

    if (progress == 1f) {
        LaunchedEffect(Unit) { onAnimationFinished() }
    }
}

@Composable
@Preview
private fun KaheetQuestionScreenPreview() {
    AdvancedUI3DAnimationWithComposeTheme {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(color = Color.White)
        ) {

            KaheetQuestionScreen(
                viewState = ViewState(
                    animationRes = R.raw.correct,
                    isGameEnded = true,
                ),
                onEvent = {}
            )
        }
    }
}