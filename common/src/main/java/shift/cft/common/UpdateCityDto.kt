package shift.cft.common

import java.io.Serializable

data class UpdateCityDto(
    val title: String,
    val description: String,
    val temperature: String
) : Serializable