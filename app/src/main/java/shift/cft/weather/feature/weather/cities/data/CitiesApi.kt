package shift.cft.weather.feature.weather.cities.data

import retrofit2.http.DELETE
import shift.cft.common.Info
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.PUT
import shift.cft.common.CreateCityDto
import shift.cft.common.UpdateCityDto

interface CitiesApi {
    @GET("/cities")
    suspend fun getAll(): List<Info>

//    @POST("/cities")
//    suspend fun addCity(createCityDto: CreateCityDto)

    @DELETE("/cities")
    suspend fun deleteCity(id: Long)

    @PUT("/cities")
    suspend fun updateCity(id: Long, updateCityDto: UpdateCityDto)
}