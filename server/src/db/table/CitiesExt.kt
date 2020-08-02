package shift.cft.server.db.table

import shift.cft.common.Info
import org.jetbrains.exposed.sql.ResultRow

fun ResultRow.toInfo() = Info(
    id = this[Cities.id],
    title = this[Cities.title],
    description = this[Cities.description],
    temperature = this[Cities.temperature]
)