package com.syntex_error.routes


import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import org.jetbrains.exposed.sql.transactions.transaction

fun Route.dbHealthRoute() {
    route("/db/health") {
        get {
            try {
                transaction {
                    exec("SELECT 1;") // Simple dummy query to test connection
                }
                call.respondText("✅ Database connection is healthy!")
            } catch (e: Exception) {
                call.respondText("❌ Database connection failed: ${e.localizedMessage}")
            }
        }
    }
}