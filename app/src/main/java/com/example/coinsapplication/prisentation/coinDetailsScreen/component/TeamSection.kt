package com.example.coinsapplication.prisentation.coinDetailsScreen.component

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Divider
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.coinsapplication.data.remote.dto.Team

@Composable
fun TeamSection(list: List<Team>) {

    Text(text = "Team Member", fontSize = 25.sp)
    Spacer(modifier = Modifier.height(15.dp))
    Box(
        modifier = Modifier
            .fillMaxWidth()
    ) {
        LazyColumn() {
            items(list) { team ->
                TeamItem(team)
                Divider()
            }
        }
    }


}

@Composable
fun TeamItem(team: Team) {

    Column(
        Modifier
            .fillMaxWidth()
            .padding(vertical = 10.dp)) {
        Text(text = team.name)
        Text(text = team.position, fontStyle = FontStyle.Italic)

    }


}
