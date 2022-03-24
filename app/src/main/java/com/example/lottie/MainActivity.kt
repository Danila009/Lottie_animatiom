package com.example.lottie

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.size
import androidx.compose.material.OutlinedButton
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.airbnb.lottie.compose.*

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Loader()
        }
    }
}

@Composable
private fun Loader() {
    val compositionResult =
        rememberLottieComposition(spec = LottieCompositionSpec.RawRes(R.raw.logo))

    val isPlaying by remember { mutableStateOf(true) }

    val progress = animateLottieCompositionAsState(
        composition = compositionResult.value,
        isPlaying = isPlaying,
        iterations = LottieConstants.IterateForever
    )

    Column {
        LottieAnimation(
            composition = compositionResult.value,
            progress = progress.progress,
            modifier = Modifier.size(300.dp)
        )

//        OutlinedButton(onClick = { isPlaying = true }) {
//            Text(text = "Start animation")
//        }
    }
}
