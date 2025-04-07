package com.ynov.example.dev_mobile.presentation

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ynov.example.dev_mobile.domain.GetShowDetailsUseCase
import com.ynov.example.dev_mobile.domain.TvShowDetail
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ShowDetailsViewModel @Inject constructor(
    private val getShowDetailsUseCase: GetShowDetailsUseCase
) : ViewModel() {
    private val _state = mutableStateOf<TvShowDetail?>(null)
    val state: State<TvShowDetail?> = _state

    fun loadShowDetails(showId: String) {
        viewModelScope.launch {
            try {
                _state.value = getShowDetailsUseCase(showId)
            } catch (e: Exception) {
                // Handle error
            }
        }
    }
}