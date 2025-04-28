package com.syntex_error

import com.syntex_error.config.DatabaseFactory
import com.syntex_error.routes.configureRouting
import io.ktor.server.application.*
import io.ktor.server.engine.embeddedServer
import io.ktor.server.netty.Netty
import com.syntex_error.plugins.*

fun main() {

    embeddedServer(Netty, port = 7100, host = "localhost") {
        DatabaseFactory.init()
        configureBasic()
        configureKoin()
        configureHTTP()
        configureSerialization()
        //configureDatabases()
        configureSecurity()
        configureRouting()

    }.start(wait = true)

  //  io.ktor.server.netty.EngineMain.main(args)
}



//fun Application.module() {
//
//}
