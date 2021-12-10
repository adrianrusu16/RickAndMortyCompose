package com.example.jetpackandcompose.feature.character

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.unit.dp
import androidx.paging.LoadState
import androidx.paging.PagingData
import androidx.paging.compose.collectAsLazyPagingItems
import androidx.paging.compose.itemsIndexed
import com.example.jetpackandcompose.data.Character
import kotlinx.coroutines.flow.Flow

@Composable
fun CharacterListing(
    modifier: Modifier = Modifier,
    characters: Flow<PagingData<Character>>
) {
    val lazyCharacterItems = characters.collectAsLazyPagingItems()

    LazyColumn {
        if (lazyCharacterItems.loadState.refresh == LoadState.Loading) {
            item {
                Text(
                    text = "Waiting for items to load",
                    modifier = modifier
                        .fillMaxWidth()
                        .wrapContentWidth(Alignment.CenterHorizontally)
                )
            }
        }

        itemsIndexed(lazyCharacterItems) { _, character ->
            character?.let {
                CharacterItem(
                    modifier,
                    character = it
                )
            }
        }

        lazyCharacterItems.apply {
            when {
                loadState.refresh is
                        LoadState.Loading -> {
                    item { LoadingItem() }
                }
                loadState.append is
                        LoadState.Loading -> {
                    item { LoadingItem() }
                }
                loadState.refresh is
                        LoadState.Error -> {
                }
                loadState.append is
                        LoadState.Error -> {
                }
            }
        }
    }
}

@Composable
fun LoadingItem() {
    CircularProgressIndicator(
        modifier = Modifier
            .testTag("ProgressBarItem")
            .fillMaxWidth()
            .padding(16.dp)
            .wrapContentWidth(
                Alignment.CenterHorizontally
            )
    )
}
