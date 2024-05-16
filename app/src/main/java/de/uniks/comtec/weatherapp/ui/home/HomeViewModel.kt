package de.uniks.comtec.weatherapp.ui.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import de.uniks.comtec.weatherapp.data.WeatherRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val weatherRepository: WeatherRepository
) : ViewModel() {

    private val _uiState: MutableStateFlow<HomeUiState> = MutableStateFlow(HomeUiState())
    val uiState: StateFlow<HomeUiState> = _uiState

    init {
        viewModelScope.launch {
            weatherRepository.weatherDbFlow.collect {
                if (it == null) return@collect
                _uiState.value = _uiState.value.copy(temperature = it.tempC)
            }
        }
        viewModelScope.launch {
            weatherRepository.loadingFlow.collect {
                _uiState.value = _uiState.value.copy(loading = it)
            }
        }
    }


}