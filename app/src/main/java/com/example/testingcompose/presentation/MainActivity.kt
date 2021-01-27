package com.example.testingcompose.presentation

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.BlendMode
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.setContent
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import com.example.testingcompose.R
import com.example.testingcompose.domain.Pokemon
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private val viewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MaterialTheme {
                Column(Modifier.background(Color.Black)) {
                    ListOfNumbers()
                    Text(
                        text = "Hello za warudo",
                        color = Color.Black,
                        fontSize = TextUnit.Companion.Sp(40)
                    )
                }
            }
        }
    }

    @Composable
    fun ListOfNumbers() {
        Column(
            modifier = Modifier
                .padding(start = 16.dp)
                .background(Color.Magenta)
        ) {
            val typography = MaterialTheme.typography
            val until: List<Pokemon> by viewModel.pokemons().observeAsState(listOf())

            for (i in until) {
                Text(text = i.toString(), style = typography.body1)
            }
            Spacer(modifier = Modifier.preferredHeight(16.dp))
            BeautifulImage()
            Counter()
        }
    }

    @Composable
    fun BeautifulImage() {
        val image = imageResource(id = R.drawable.header)
        Image(
            image,
            colorFilter = ColorFilter(Color.Transparent, BlendMode.ColorBurn),
            contentScale = ContentScale.FillWidth,
            modifier = Modifier
                .preferredHeight(180.dp)
                .fillMaxWidth()
                .clip(shape = RoundedCornerShape(32.dp))
        )
    }

    @Composable
    fun Counter() {
        val counter: MutableState<Int> = remember { mutableStateOf(0) }

        Button(onClick = { counter.value++ }) {
            Row {
                Image(
                    imageResource(id = R.drawable.header),
                    colorFilter = ColorFilter(Color.Transparent, BlendMode.ColorBurn),
                    contentScale = ContentScale.FillWidth,
                    modifier = Modifier
                        .preferredHeight(24.dp)
                        .preferredWidth(24.dp)
                        .clip(shape = RoundedCornerShape(24.dp))
                )
                Text(counter.value.toString())
            }
        }
    }
}