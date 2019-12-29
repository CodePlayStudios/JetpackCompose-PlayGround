package com.rax.jetpackcompose

import androidx.compose.Composable
import androidx.compose.unaryPlus
import androidx.ui.core.Clip
import androidx.ui.core.Text
import androidx.ui.core.dp
import androidx.ui.foundation.DrawImage
import androidx.ui.foundation.HorizontalScroller
import androidx.ui.foundation.shape.corner.RoundedCornerShape
import androidx.ui.graphics.Color
import androidx.ui.layout.*
import androidx.ui.material.Button
import androidx.ui.material.Checkbox
import androidx.ui.material.Divider
import androidx.ui.material.MaterialTheme
import androidx.ui.material.surface.Surface
import androidx.ui.res.imageResource
import androidx.ui.tooling.preview.Preview

/**
 * To make a generic container, we create a
 * Composable function that takes as a parameter a lambda of a Composable function
 * (here called children) which returns Unit.
 * We return Unit because, as you might have noticed, all Composable functions must return Unit
 */
@Composable
fun MyApp(children: @Composable() () -> Unit) {
//    extra parenthesis in @Composable()
//     is needed when it is used as a parameter as @Composable already applied in the function
    MaterialTheme {
        Surface(color = Color.White) {
            children()
        }
    }
}


@Composable
fun startApp() {
    MyApp {
        createComponents(News())
    }
}

fun createComponents(news: News) {
    Column(modifier = Spacing(16.dp).wraps(ExpandedHeight)) {
        Column(modifier = Flexible(1f)) {
            AddScroller(news)
            CounterHeader(news)
            AddSubtractButtons(news)
        }
        CounterLabel(news)
        Divider(color = Color.Black, height = 0.2.dp)
    }
}

@Composable
fun AddScroller(news: News){
    HorizontalScroller {
        Row(modifier = Spacing(bottom = 16.dp, right = 16.dp)) {
            for (x in 0 until 10) {
                WidthSpacer(16.dp)
                NewsStory(news)
            }
        }
    }
}

@Composable
fun CounterHeader(news: News) {
    Text(text = news.text)
}

@Composable
fun AddSubtractButtons(news: News) {
    HeightSpacer(16.dp)
    Button(
        text = "Add",
        onClick = { news.add() })
    HeightSpacer(16.dp)
    Button(
        text = "Subtract",
        onClick = { news.subtract() })
}

@Composable
fun CounterLabel(news: News) {
    HeightSpacer(16.dp)
    Text(text = "Clicks: ${news.counter}", style = (+MaterialTheme.typography()).h6)
}


@Preview
@Composable
fun DefaultPreview() {
    startApp()
}