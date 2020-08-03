package shift.cft.weather.feature.weather.cities.presentation

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import shift.cft.common.Info
import shift.cft.weather.feature.util.viewmodel.SingleLiveEvent
import shift.cft.weather.feature.weather.cities.domain.GetCitiesUseCase

class WeatherListViewModel(getCitiesUseCase: GetCitiesUseCase) : ViewModel() {

    val cities = MutableLiveData<List<Info>>()
    val cityClickedEvent =
        SingleLiveEvent<Info>()

    init {
        viewModelScope.launch {
            try {
                cities.value = getCitiesUseCase()
            } catch (e: Exception) {
                // show error
            }
        }
    }

    fun citiesClicked(model: Info) {
        cityClickedEvent(model)
    }
}