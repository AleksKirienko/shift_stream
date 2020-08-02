package shift.cft.weather.feature.weather.cities.presentation

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import shift.cft.weather.feature.weather.domain.entity.Info
import shift.cft.weather.feature.util.viewmodel.SingleLiveEvent
import shift.cft.weather.feature.weather.cities.domain.GetCitiesUseCase

class WeatherListViewModel(getCitiesUseCase: GetCitiesUseCase) : ViewModel() {

    val cities = MutableLiveData<List<Info>>()
    val cityClickedEvent =
        SingleLiveEvent<Info>()

    init {
        cities.value = getCitiesUseCase()
    }

    fun citiesClicked(model: Info) {
        cityClickedEvent(model)
    }
}