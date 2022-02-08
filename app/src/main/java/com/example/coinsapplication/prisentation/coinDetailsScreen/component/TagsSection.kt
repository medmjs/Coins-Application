package com.example.coinsapplication.prisentation.coinDetailsScreen.component

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.google.accompanist.flowlayout.FlowRow


@Composable
fun TagSection(tags: List<String>) {

    Text(text = "Tags", fontSize = 30.sp)
    Spacer(modifier = Modifier.height(15.dp))

    if (tags.isNotEmpty()) {
        FlowRow(
            mainAxisSpacing = 6.dp,
            crossAxisSpacing = 8.dp
        ) {
            tags.forEach { tag ->
                TagItem(tag)
            }
        }
    }

}
@Composable
fun TagItem(tag: String) {
    Box(
        modifier = Modifier
            .border(
                1.dp, Color.Green, CircleShape
            )
            .padding(horizontal = 8.dp, vertical = 6.dp), contentAlignment = Alignment.Center
    ) {
        Text(text = tag)
    }
}