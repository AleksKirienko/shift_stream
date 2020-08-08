package shift.cft.weather.feature.weather.add.data

import retrofit2.http.POST
import shift.cft.common.CreateCityDto

interface AddCityApi {
    @POST("/cities")
    suspend fun addCity(createCityDto: CreateCityDto)
}