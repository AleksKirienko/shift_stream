package shift.cft.common

import java.io.Serializable

data class Info(
    val title: String,
    val description: String? = null,
    val temperature: String? = null
):Serializable