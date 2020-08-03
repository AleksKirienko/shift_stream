package shift.cft.weather.feature.weather.cities.data

import shift.cft.common.Info
import retrofit2.http.GET

interface CitiesApi {
    @GET("/cities")
    suspend fun getAll(): List<Info>
}