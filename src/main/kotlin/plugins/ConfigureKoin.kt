package com.syntex_error.plugins

import com.syntex_error.di.controllerModule
import io.ktor.server.application.*
import org.koin.core.logger.Level
import org.koin.ktor.plugin.Koin
import org.koin.logger.slf4jLogger

fun Application.configureKoin() {
    install(Koin) {
        slf4jLogger(Level.INFO)
        modules(controllerModule)
    }
}