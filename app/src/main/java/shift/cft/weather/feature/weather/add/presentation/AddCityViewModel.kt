package shift.cft.weather.feature.weather.add.presentation

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import shift.cft.weather.feature.util.viewmodel.SingleLiveEvent
import shift.cft.weather.feature.weather.add.domain.AddCityUseCase
import java.lang.Exception

class AddCityViewModel(
    private val addCiryUseCase: AddCityUseCase
) : ViewModel() {

    val isLoading = MutableLiveData<Boolean>(false)
    val emptyTitleEvent = SingleLiveEvent<Unit>()
    val emptyDescriptionEvent = SingleLiveEvent<Unit>()
    val emptyTemperatureEvent = SingleLiveEvent<Unit>()
    val addWeatherErrorEvent = SingleLiveEvent<Unit>()
    val addWeatherSuccessEvent = SingleLiveEvent<Unit>()

    fun addCity(
        title: String?,
        description: String?,
        temperature: String?
    ) {

        when {
            title.isNullOrEmpty() -> emptyTitleEvent(Unit)
            description.isNullOrEmpty() -> emptyDescriptionEvent(Unit)
            temperature.isNullOrEmpty() -> emptyTemperatureEvent(Unit)
            else -> {
                isLoading.value = true
                viewModelScope.launch {
                    try {
                        addCiryUseCase(title, description, temperature)
                        addWeatherSuccessEvent(Unit)
                    } catch (e: Exception) {
                        addWeatherErrorEvent(Unit)
                    }
                    isLoading.value = false
                }
            }
        }


    }

}