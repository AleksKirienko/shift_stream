package shift.cft.common

import java.io.Serializable

data class Info(
    val id: Long,
    val title: String,
    val description: String? = null,
    val temperature: String? = null
):Serializable