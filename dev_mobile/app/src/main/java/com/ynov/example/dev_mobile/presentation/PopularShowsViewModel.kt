package com.ynov.example.dev_mobile.presentation

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ynov.example.dev_mobile.domain.GetPopularShowsUseCase
import com.ynov.example.dev_mobile.domain.TvShow
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PopularShowsViewModel @Inject constructor(
    private val getPopularShowsUseCase: GetPopularShowsUseCase
) : ViewModel() {
    private val _state = mutableStateOf<List<TvShow>>(emptyList())
    val state: State<List<TvShow>> = _state

    init {
        loadShows()
    }

    private fun loadShows() {
        viewModelScope.launch {
            try {
                _state.value = getPopularShowsUseCase(1)
            } catch (e: Exception) {
                // Handle error
            }
        }
    }
}