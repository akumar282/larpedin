package org.larp.db

import java.sql.DriverManager
import java.sql.Connection
import java.sql.SQLException

class RepositoryConnector {
    public var connection: Connection? = null

    public constructor(dbPrefix: String? = "larpedin.db") {
        try {
            if (connection === null) {
                connection = DriverManager.getConnection("jdbc:sqlite:${dbPrefix}")
                println("Connection to db opened")
            }
        } catch (e: SQLException) {
            println("Unable to open db connection")
        }
    }

    fun disconnect() {
        try {
            if (connection != null) {
                connection?.close()
            }
        } catch (e: SQLException) {
            println("Unable to close db connection")
        }
    }
}