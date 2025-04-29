package com.syntex_error.di

import com.syntex_error.modules.auth.controller.AuthController
import org.koin.dsl.module

val controllerModule = module {
    single { AuthController() }
}