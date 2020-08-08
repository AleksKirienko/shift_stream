package shift.cft.weather.feature.weather.add.data

interface NetworkAddCityDataSource {
    suspend fun addCity()
}

class NetworkAddCityDataSourceImpl(private val api: AddCityApi) : NetworkAddCityDataSource {

    override suspend fun addCity() {
//        api.addCity()
    }

}