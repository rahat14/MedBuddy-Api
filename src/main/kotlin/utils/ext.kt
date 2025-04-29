package com.syntex_error.utils

import com.syntex_error.modules.auth.controller.JwtTokenRequest
import io.ktor.server.application.ApplicationCall
import io.ktor.server.auth.principal
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import org.jetbrains.exposed.sql.transactions.transaction
import io.github.smiley4.ktoropenapi.config.RouteConfig
import io.ktor.http.HttpStatusCode
import io.ktor.http.cio.Response

suspend fun <T> query(block: () -> T): T = withContext(Dispatchers.IO) {
    transaction {
        block()
    }
}

fun ApplicationCall.currentUser(): JwtTokenRequest {
    return this.principal<JwtTokenRequest>() ?: throw IllegalStateException("No authenticated user found")
}


fun String.notFoundException(): CommonException {
    return CommonException("$this is not Exist")
}

fun String.alreadyExistException(secondaryInfo: String = ""): CommonException {
    return if (secondaryInfo.isEmpty()) CommonException("$this is already Exist")
    else CommonException("$this $secondaryInfo is already Exist")
}


fun RouteConfig.apiResponse() {
    return response {
        // document the "200 OK" response
        code(HttpStatusCode.OK) {
            description = "Successful"
            // specify the schema of the response body and some additional information
            body<Response> {
                description = "Successful"
            }
        }
        // document the "422 Unprocessable Entity" response
        code(HttpStatusCode.InternalServerError) {
            description = "Internal Server Error"
        }
    }
}

class UserNotExistException : Exception()
class EmailNotExist : Exception()
class PasswordNotMatch : Exception()
class CommonException(itemName: String) : Exception(itemName)