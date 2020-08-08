package shift.cft.weather.feature.weather.add.domain

import kotlinx.coroutines.delay

class AddCityUseCase {

    suspend operator fun invoke(title: String, description: String, temperature: String) {
        delay(3000)
    }

}