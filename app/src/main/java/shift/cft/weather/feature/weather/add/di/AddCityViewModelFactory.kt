package shift.cft.weather.feature.weather.add.di

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import shift.cft.weather.feature.weather.add.data.AddCityApi
import shift.cft.weather.feature.weather.add.domain.AddCityUseCase
import shift.cft.weather.feature.weather.add.presentation.AddCityViewModel
import shift.cft.weather.feature.weather.cities.data.CitiesApi
import shift.cft.weather.feature.weather.cities.data.CitiesRepositoryImpl
import shift.cft.weather.feature.weather.cities.data.NetworkWeatherDataSourceImpl

class AddCityViewModelFactory : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {

        if (modelClass == AddCityViewModel::class.java) {

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

            val api = retrofit.create(AddCityApi::class.java)

//            val networkDataSource = NetworkWeatherDataSourceImpl(api)
//            val citiesRepository = CitiesRepositoryImpl(networkDataSource)
            val addCityUseCase = AddCityUseCase()
            return AddCityViewModel(addCityUseCase) as T
        } else {
            error("Unexpected class $modelClass")
        }
    }
}