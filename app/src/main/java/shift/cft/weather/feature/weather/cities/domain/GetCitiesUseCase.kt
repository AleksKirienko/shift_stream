package shift.cft.weather.feature.weather.cities.domain

import shift.cft.common.Info

class GetCitiesUseCase(private val citiesRepositoiry: CitiesRepositoiry) {

    operator fun invoke(): List<Info> = citiesRepositoiry.getCity()
}