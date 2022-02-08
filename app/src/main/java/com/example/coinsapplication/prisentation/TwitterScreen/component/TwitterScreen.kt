package com.example.coinsapplication.prisentation.TwitterScreen.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.rememberVectorPainter
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import coil.compose.ImagePainter
import coil.compose.rememberImagePainter
import coil.request.ImageRequest
import com.example.coinsapplication.R
import com.example.coinsapplication.domain.model.twitter.CoinTwitter
import com.example.coinsapplication.prisentation.TwitterScreen.CoinTwitterViewModel
import dagger.hilt.android.scopes.ViewModelScoped

@Composable
fun TwitterScreen(
    navController: NavController,
    viewModel: CoinTwitterViewModel = hiltViewModel()
) {

    val result = viewModel.state.value

    result.coinTwitters?.let { coinTwettes ->

        LazyColumn(
            verticalArrangement = Arrangement.spacedBy(5.dp),
            modifier = Modifier.fillMaxSize()
        ) {
            items(coinTwettes) { coinTwitter ->
                TwitterItem(coinTwitter)
            }
        }


    }


}


@Composable
fun TwitterItem(coinTwitter: CoinTwitter) {

    val painter = rememberImagePainter(data = coinTwitter.userImageLink, builder = {

    })



    Box(
        Modifier
            .fillMaxWidth()
            .shadow(5.dp, shape = RoundedCornerShape(5.dp), clip = true)
            .border(width = 1.dp, color = Color.LightGray, shape = RoundedCornerShape(5.dp))
            .padding(horizontal = 10.dp, vertical = 10.dp),


        ) {
        Column(Modifier.fillMaxSize()) {
            Row(Modifier.fillMaxWidth()) {
                Image(
                    painter = painter,
                    contentDescription = "",
                    modifier = Modifier
                        .size(40.dp)
                        .clip(CircleShape)
                        .border(3.dp, color = MaterialTheme.colors.onSurface, CircleShape),
                    alignment = Alignment.Center
                )



                Text(
                    text = coinTwitter.userName,
                    modifier = Modifier.padding(start = 10.dp)
                )

                Text(
                    text = coinTwitter.date,
                    modifier = Modifier.fillMaxWidth(),
                    textAlign = TextAlign.End
                )
            }
            Text(text = coinTwitter!!.status)


        }

    }


}
//
//@Preview
//@Composable
//fun priviewMetiod() {
//    TwitterItem()
//}