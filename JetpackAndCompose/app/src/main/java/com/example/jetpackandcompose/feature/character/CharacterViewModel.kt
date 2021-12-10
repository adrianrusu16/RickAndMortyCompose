package com.example.jetpackandcompose.feature.character

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.example.jetpackandcompose.data.CharacterRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.stateIn
import javax.inject.Inject

@HiltViewModel
class CharacterViewModel @Inject constructor(
    repository: CharacterRepository
) : ViewModel() {

    val characters = repository.getSearchResults()
        .cachedIn(viewModelScope)
        .stateIn(
            scope = viewModelScope,
//            started = SharingStarted.WhileSubscribed(5000),
            started = SharingStarted.Eagerly,
            initialValue = PagingData.empty()
        )
}