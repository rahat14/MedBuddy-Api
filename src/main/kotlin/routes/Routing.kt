package com.syntex_error.routes

import com.syntex_error.modules.auth.controller.AuthController
import com.syntex_error.modules.auth.routes.authRoutes
import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import org.koin.ktor.ext.inject

fun Application.configureRouting() {
    val authController: AuthController by inject()

    routing {
        get("/") {
            call.respondText("Hello World!")
        }
        get("/health") {
            call.respondText("Server is Working Well!")
        }

        dbHealthRoute()
        authRoutes(authController)

    }
}
