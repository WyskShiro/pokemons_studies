package com.example.testingcompose.list.presentation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.preferredHeight
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.setContent
import androidx.compose.ui.unit.dp
import com.example.testingcompose.list.domain.Pokemon
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {

    private val viewModel: MainViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MaterialTheme {
                Column(Modifier.background(Color.Black)) {
                    ListOfNumbers()
                    Text(
                        text = "Hello za warudo",
                        color = Color.Black
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
        }
    }
}