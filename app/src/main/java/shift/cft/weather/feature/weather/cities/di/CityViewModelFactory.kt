package shift.cft.weather.feature.weather.cities.di

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import shift.cft.weather.feature.weather.cities.data.CitiesApi
import shift.cft.weather.feature.weather.cities.data.CitiesRepositoryImpl
import shift.cft.weather.feature.weather.cities.data.NetworkWeatherDataSourceImpl
import shift.cft.weather.feature.weather.cities.domain.GetCitiesUseCase
import shift.cft.weather.feature.weather.cities.presentation.WeatherListViewModel

class CityViewModelFactory : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {

        if (modelClass == WeatherListViewModel::class.java) {

            val interceptor = HttpLoggingInterceptor()
            interceptor.level = HttpLoggingInterceptor.Level.BODY
            val client = OkHttpClient.Builder()
                .addInterceptor(interceptor)
                .build()
            val retrofit = Retrofit.Builder()
                .baseUrl("https://shift-weather-back.herokuapp.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .client(client)
                .build()

            val api = retrofit.create(CitiesApi::class.java)

            val networkDataSource = NetworkWeatherDataSourceImpl(api)
            val citiesRepository = CitiesRepositoryImpl(networkDataSource)
            val getCitiesUseCase = GetCitiesUseCase(citiesRepository)

            return WeatherListViewModel(getCitiesUseCase) as T
        } else {
            error("Unexpected class $modelClass")
        }
    }
} 