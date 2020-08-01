package shift.cft.weather.feature.weather.cities.domain

import shift.cft.weather.feature.weather.domain.entity.Info

interface CitiesRepositoiry {

    fun getCity(): List<Info>
}