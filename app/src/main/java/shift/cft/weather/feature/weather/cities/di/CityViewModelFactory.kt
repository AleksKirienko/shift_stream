package shift.cft.weather.feature.weather.cities.di

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import shift.cft.weather.feature.weather.cities.data.CitiesRepositoryImpl
import shift.cft.weather.feature.weather.cities.data.NetworkWeatherDataSourceImpl
import shift.cft.weather.feature.weather.cities.domain.GetCitiesUseCase
import shift.cft.weather.feature.weather.cities.presentation.WeatherListViewModel

class CityViewModelFactory : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {

        if (modelClass == WeatherListViewModel::class.java) {
            val networkDataSource = NetworkWeatherDataSourceImpl()
            val citiesRepository = CitiesRepositoryImpl(networkDataSource)
            val getCitiesUseCase = GetCitiesUseCase(citiesRepository)

            return WeatherListViewModel(getCitiesUseCase) as T
        } else {
            error("Unexpected class $modelClass")
        }
    }
} 