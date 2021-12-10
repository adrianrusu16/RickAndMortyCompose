package com.example.jetpackandcompose.api

import com.example.jetpackandcompose.data.Character

data class CharacterResponse(
    val results: List<Character>
)