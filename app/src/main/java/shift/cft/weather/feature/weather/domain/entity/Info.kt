package shift.cft.weather.feature.weather.domain.entity

import java.io.Serializable

data class Info(
    val title: String,
    val description: String? = null,
    val temperature: String? = null
):Serializable