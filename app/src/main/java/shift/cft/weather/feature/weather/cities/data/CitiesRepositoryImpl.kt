package shift.cft.weather.feature.weather.cities.data

import shift.cft.common.Info
import shift.cft.weather.feature.weather.cities.domain.CitiesRepositoiry

class CitiesRepositoryImpl(
    private val networkWeatherDataSource: NetworkWeatherDataSource
) : CitiesRepositoiry {

    override suspend fun getCity(): List<Info> = networkWeatherDataSource.getCity()
}