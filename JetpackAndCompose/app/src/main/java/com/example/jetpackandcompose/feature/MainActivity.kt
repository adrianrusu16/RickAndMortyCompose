package com.example.jetpackandcompose.feature

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.ui.Modifier
import com.example.jetpackandcompose.feature.character.CharacterScreen
import com.example.jetpackandcompose.feature.character.CharacterViewModel
import com.example.jetpackandcompose.ui.theme.JetpackAndComposeTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private val viewModel: CharacterViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetpackAndComposeTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {
                    CharacterScreen(
                        modifier = Modifier,
                        characterViewModel = viewModel
                    )
                }
            }
        }
    }
}