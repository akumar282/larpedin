package org.larp

import io.ktor.server.response.*
import io.ktor.server.routing.*
import io.ktor.server.engine.*
import io.ktor.server.netty.*
import org.larp.db.RepositoryConnector

fun main(args: Array<String>) {
    if (args.isEmpty()) {
        println("No args... Running basic server...")
        RepositoryConnector("larpedin.db")
        runBasicServer()
    }
}

fun runBasicServer() {
    embeddedServer(Netty, port = 8080) {
        routing {
            get("/") {
                call.respondText("Hello, world!")
            }
        }
    }.start(wait = true)
}
