package org.larp.db

import java.sql.DriverManager
import java.sql.Connection

class RepositoryConnector(dbPrefix: String? = "larpedin.db") {
    val connection: Connection

    init {
        connection = DriverManager.getConnection("jdbc:sqlite:${dbPrefix}")
        println("Connection to db opened")
    }

    fun disconnect() {
        connection.close()
        println("Connection to db opened")
    }
}