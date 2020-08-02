package shift.cft.weather.feature.weather.cities.domain

import shift.cft.common.Info

interface CitiesRepositoiry {

    fun getCity(): List<Info>
}