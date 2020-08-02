package shift.cft.weather.feature.weather.cities.domain

import shift.cft.weather.feature.weather.domain.entity.Info

class GetCitiesUseCase(private val citiesRepositoiry: CitiesRepositoiry) {

    operator fun invoke(): List<Info> = citiesRepositoiry.getCity()
}