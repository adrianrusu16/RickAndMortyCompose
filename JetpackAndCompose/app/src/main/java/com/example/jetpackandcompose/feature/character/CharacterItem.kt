package com.example.jetpackandcompose.feature.character

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberImagePainter
import com.example.jetpackandcompose.R
import com.example.jetpackandcompose.data.Character
import com.example.jetpackandcompose.ui.theme.JetpackAndComposeTheme

@Composable
fun CharacterItem(
    modifier: Modifier = Modifier,
    character: Character
) {
    Card(
        elevation = 20.dp,
        backgroundColor = Color.Gray,
        modifier = modifier
            .padding(
                start = 16.dp,
                end = 16.dp,
                top = 16.dp
            )
            .height(150.dp)
            .fillMaxWidth()
    ) {
        Row(
            modifier = modifier
        ) {
            Image(
                contentScale = ContentScale.Crop,
                painter = rememberImagePainter(
                    data = character.image,
                    builder = {
                        placeholder(R.drawable.ic_launcher_background)
                        crossfade(true)
                    }
                ),
                contentDescription = "Image with a character from Rick and Morty",
                modifier = modifier
                    .height(150.dp)
                    .width(150.dp)
            )
            Column(
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = modifier
                    .fillMaxSize()
            ) {
                Text(
                    text = character.name,
                    color = Color.White,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis,
                    fontSize = 22.sp,
                    modifier = modifier
                        .padding(8.dp)
                )
                Text(
                    text = "${character.status} - ${character.species}",
                    color = Color.White,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis,
                    fontSize = 16.sp,
                    modifier = modifier
                        .padding(8.dp)
                )
            }
        }
    }
}

@Preview
@Composable
fun CharacterItemPreview() {
    JetpackAndComposeTheme {
        CharacterItem(
            character = Character(
                1,
                "Rick Sanchez",
                "Alive",
                "Human",
                "\"https://rickandmortyapi.com/api/character/avatar/361.jpeg\""
            )
        )
    }
}