package shift.cft.weather.feature.weather.cities.data

import android.icu.text.IDNA
import shift.cft.weather.feature.weather.cities.domain.CitiesRepositoiry
import shift.cft.weather.feature.weather.domain.entity.Info

class CitiesRepositoryImpl(
    private val networkWeatherDataSource: NetworkWeatherDataSource
) : CitiesRepositoiry {

    override fun getCity(): List<Info> = networkWeatherDataSource.getCity()
}