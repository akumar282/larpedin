package org.larp.db
import java.sql.SQLException
import java.sql.Timestamp

class Repository {
    private var dbManager: RepositoryConnector? = null

    public constructor(dbName: String?) {
        dbManager = RepositoryConnector(dbName)
    }

    fun createTables() {
        val createTableSql = """
            CREATE TABLE IF NOT EXISTS users (
                username TEXT PRIMARY KEY UNIQUE,
                ip_address TEXT,
                larp_score INTEGER NOT NULL,
                created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
            );
        """.trimIndent()

        try {
            dbManager?.connection?.createStatement().use { statement -> statement?.execute(createTableSql) }
        } catch (e: SQLException) {
            println("Error Creating Table")
        }
    }

    fun createEntry(
        username: String,
        ip_address: String,
        larp_score: Int,
        created_at: Timestamp
    ) {

    }
}