package shift.cft.server.repository

import org.jetbrains.exposed.sql.selectAll
import shift.cft.server.db.dbQuery
import shift.cft.server.db.table.Cities
import shift.cft.server.db.table.toInfo

class WeatherRepository {
    suspend fun getAll() =
        dbQuery {
            Cities.selectAll().map { it.toInfo() }
        }
}