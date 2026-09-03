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
        val createEntry = """
            INSERT INTO users (username, ip_address, larp_score, created_at)
            VALUES (?, ?, ?, ?)
        """.trimIndent()

        try {
            dbManager?.connection?.prepareStatement(createEntry).use {
                preparedStatement ->
                preparedStatement?.setString(1, username)
                preparedStatement?.setString(2, ip_address)
                preparedStatement?.setInt(3, larp_score)
                preparedStatement?.setTimestamp(4, created_at)
                preparedStatement?.execute()
            }
        } catch (e: SQLException) {
            println("Error Creating Entry")
        }
    }
}