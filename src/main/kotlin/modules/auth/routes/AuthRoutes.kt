package com.syntex_error.modules.auth.routes

import com.syntex_error.database.models.user.RegisterRequest
import com.syntex_error.modules.auth.controller.AuthController
import com.syntex_error.utils.ApiResponse
import com.syntex_error.utils.apiResponse
import io.github.smiley4.ktoropenapi.post
import io.ktor.http.HttpStatusCode
import io.ktor.server.request.receive
import io.ktor.server.response.respond
import io.ktor.server.routing.Route
import io.ktor.server.routing.route

fun Route.authRoutes(authController: AuthController) {


    route("auth") {

        post("register", {
            tags("Auth")
            request {
                body<RegisterRequest>()
            }
            apiResponse()
        }) {
            val requestBody = call.receive<RegisterRequest>()
            call.respond(
                ApiResponse.success(
                    authController.register(requestBody),
                    HttpStatusCode.OK
                )
            )
        }
    }


}