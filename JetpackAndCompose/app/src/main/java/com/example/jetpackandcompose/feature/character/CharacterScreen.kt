package com.example.jetpackandcompose.feature.character

import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel

@Composable
fun CharacterScreen(
    modifier: Modifier = Modifier,
    characterViewModel: CharacterViewModel = viewModel()
) {
    Scaffold(
        content = {
            CharacterListing(
                modifier = modifier,
                characters = characterViewModel.characters
            )
        }
    )
}