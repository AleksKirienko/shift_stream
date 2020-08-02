package shift.cft.server.db.table

import org.jetbrains.exposed.sql.Column
import org.jetbrains.exposed.sql.Table

object Cities : Table() {
    val id: Column<Long> = Cities.long("id").autoIncrement().primaryKey()
    val title: Column<String> = Cities.text("title")
    val description: Column<String> = Cities.text("description")
    val temperature: Column<String> = Cities.text("temperature")
}