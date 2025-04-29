package com.syntex_error.plugins


import com.syntex_error.database.models.user.RegisterRequest
import io.ktor.http.HttpStatusCode
import io.ktor.server.application.*
import io.ktor.server.plugins.requestvalidation.*
import org.valiktor.ConstraintViolationException
import io.ktor.server.plugins.*
import io.ktor.server.plugins.statuspages.*
import io.ktor.server.response.respond
import org.valiktor.i18n.mapToMessage
import java.util.Locale

fun Application.configureRequestValidation() {
    install(RequestValidation) {

        validate<RegisterRequest> { register ->
            register.validation()
            ValidationResult.Valid
        }

    }
}
