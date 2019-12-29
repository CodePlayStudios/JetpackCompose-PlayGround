package com.rax.jetpackcompose

import androidx.compose.Composable
import androidx.compose.unaryPlus
import androidx.ui.core.Clip
import androidx.ui.core.Text
import androidx.ui.core.dp
import androidx.ui.foundation.DrawImage
import androidx.ui.foundation.shape.corner.RoundedCornerShape
import androidx.ui.layout.*
import androidx.ui.material.Checkbox
import androidx.ui.material.MaterialTheme
import androidx.ui.material.withOpacity
import androidx.ui.res.imageResource
import androidx.ui.text.style.TextOverflow

@Composable
fun NewsStory(news: News) {
    val image = +imageResource(R.drawable.ic_header)

    MaterialTheme {
        Column(
            modifier = Spacing(16.dp)
        ) {
            Container(modifier = Size(280.dp, 240.dp)) {
                Column(modifier = Expanded) {
                    Clip(shape = RoundedCornerShape(8.dp)) {
                        DrawImage(image)
                        Checkbox(
                            checked = news.optionChecked,
                            onCheckedChange = { newState -> news.optionChecked = newState })
                    }
                }
            }
            HeightSpacer(16.dp)
            Text(
                news.text,
                maxLines = 2,
                overflow = TextOverflow.Ellipsis,
                style = (+MaterialTheme.typography()).h6
                    .withOpacity(0.87f)
            )
            Text(
                news.desc,
                style = (+MaterialTheme.typography()).body2
                    .withOpacity(0.87f)
            )
            Text(
                news.date,
                style = (+MaterialTheme.typography()).body2
                    .withOpacity(0.6f)
            )
        }
    }
}
