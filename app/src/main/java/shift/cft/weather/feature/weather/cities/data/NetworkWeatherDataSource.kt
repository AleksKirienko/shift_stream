package shift.cft.weather.feature.weather.cities.data

import shift.cft.common.Info

interface NetworkWeatherDataSource {

    suspend fun getCity(): List<Info>
}

class NetworkWeatherDataSourceImpl(private val api: CitiesApi) : NetworkWeatherDataSource {
    override suspend fun getCity(): List<Info> =
        api.getAll()
}