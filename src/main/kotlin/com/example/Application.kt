package com.example

import com.example.plugins.*
import io.ktor.server.application.*
import io.ktor.server.engine.*
import io.ktor.server.netty.*

fun main() {
    embeddedServer(
        Netty,
        commandLineEnvironment(arrayOf("-config=application.conf"))
    ).start(wait = true)
}

fun Application.module() {
    configureRouting()
}
