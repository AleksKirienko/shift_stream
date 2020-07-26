package shift.cft.weather.presentation.viewmodel.weather.list

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import shift.cft.weather.model.entity.Info
import shift.cft.weather.presentation.viewmodel.SingleLiveEvent

class WeatherListViewModel : ViewModel() {

    private val citiesList = listOf(

        Info("Барнаул", "Переменная облачность, +26°C"),
        Info("Бердск", "Переменная облачность +22°C"),
        Info("Воронеж", "Малооблачно +23°C"),
        Info("Екатеринбург", "Пасмурно +22°C"),
        Info("Казань", "Малооблачно +22°C"),
        Info("Москва", "Местами грозы +17°C"),
        Info("Новосибирск", "Преимущ. солнечно +23°C"),
        Info("Омск", "Малооблачно +22°C"),
        Info("Самара", "Облачно +22°C"),
        Info("Санкт-Петербург", "Облачно +18°C"),
        Info("Тольятти", "Малооблачно +25°C"),
        Info("Тюмень", "Облачно +23°C"),
        Info("Уфа", "Пасмурно, небольшой дождь +23°C"),
        Info("Челябинск", "Облачно +25°C")
    )

    val cities = MutableLiveData<List<Info>>()
    val cityClickedEvent = SingleLiveEvent<Info>()

    init {
        cities.value = citiesList
    }

    fun citiesClicked(model: Info) {
        cityClickedEvent(model)
    }
}