package com.syntex_error

import com.syntex_error.config.DatabaseFactory
import com.syntex_error.routes.configureRouting
import io.ktor.server.application.*

fun main(args: Array<String>) {
    io.ktor.server.netty.EngineMain.main(args)
}

fun Application.module() {
    DatabaseFactory.init()
    configureHTTP()
    configureSerialization()
    //configureDatabases()
    configureSecurity()
    configureRouting()
}
