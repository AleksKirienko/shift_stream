package shift.cft.server.repository

import org.jetbrains.exposed.sql.deleteWhere
import org.jetbrains.exposed.sql.insert
import org.jetbrains.exposed.sql.selectAll
import shift.cft.common.CreateCityDto
import shift.cft.server.db.dbQuery
import shift.cft.server.db.table.Cities
import shift.cft.server.db.table.toInfo

class WeatherRepository {
    suspend fun getAll() =
        dbQuery {
            Cities.selectAll().map { it.toInfo() }
        }

    suspend fun add(createCityDto: CreateCityDto) {
        dbQuery {
            Cities.insert { insertStatement ->
                insertStatement[title] = createCityDto.title
                insertStatement[description] = createCityDto.description
                insertStatement[temperature] = createCityDto.temperature
            }
        }
    }

    suspend fun delete(id: Long) {
        dbQuery {
            Cities.deleteWhere {
                Cities.id.eq(id)
            }
        }
    }
}