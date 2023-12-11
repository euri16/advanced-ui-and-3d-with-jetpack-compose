package dev.eury.advancedui.questionScreen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.rememberLottieComposition
import dev.eury.advancedui.R
import dev.eury.advancedui.ui.theme.AdvancedUI3DAnimationWithComposeTheme

@Composable
fun KaheetGameResultDialog(isGameWon: Boolean) {
    Dialog(
        onDismissRequest = { /*TODO*/ },
        properties = DialogProperties(usePlatformDefaultWidth = false)
    ) {
        if (isGameWon) {
            GameWonContainer()
        } else {
            GameLostContainer()
        }
    }
}

@Composable
private fun GameWonContainer(modifier: Modifier = Modifier) {
    Box(
        modifier = modifier
            .fillMaxSize()
            .background(Color(0xFFDADADA))
    ) {

        val composition by rememberLottieComposition(LottieCompositionSpec.RawRes(R.raw.guy_won))

        LottieAnimation(
            composition = composition,
            restartOnPlay = true,
            iterations = Int.MAX_VALUE,
            contentScale = ContentScale.FillHeight,
            modifier = Modifier
                .height(600.dp)
                .fillMaxWidth()
                .align(Alignment.BottomCenter)
        )

        Text(
            text = "You won!",
            modifier = Modifier
                .align(Alignment.TopCenter)
                .padding(top = 64.dp),
            fontSize = 32.sp
        )
    }
}

@Composable
private fun GameLostContainer(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .background(Color.White)
    ) {

        Text(
            text = "Hi there, try again?",
            modifier = Modifier
                .padding(top = 64.dp)
                .align(Alignment.CenterHorizontally),
            fontSize = 32.sp
        )

        val composition by rememberLottieComposition(LottieCompositionSpec.RawRes(R.raw.waving_girl))

        LottieAnimation(
            composition = composition,
            restartOnPlay = true,
            iterations = Int.MAX_VALUE,
            contentScale = ContentScale.FillWidth,
            modifier = Modifier
        )
    }
}

@Composable
@Preview
private fun DialogPreview() {
    AdvancedUI3DAnimationWithComposeTheme {
        KaheetGameResultDialog(true)
    }
}