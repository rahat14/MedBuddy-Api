package com.syntex_error.config
import io.github.cdimascio.dotenv.dotenv
import com.zaxxer.hikari.HikariConfig
import com.zaxxer.hikari.HikariDataSource
import org.jetbrains.exposed.sql.Database


object DatabaseFactory {
    fun init() {
        Database.connect(hikari())
    }

    private fun hikari(): HikariDataSource {
        val dotenv = dotenv()

        val config = HikariConfig().apply {
            jdbcUrl = dotenv["DB_URL"] ?: "jdbc:postgresql://localhost:5432/yourdbname"
            username = dotenv["DB_USER"] ?: "yourdbuser"
            password = dotenv["DB_PASSWORD"] ?: "yourdbpassword"
            driverClassName = "org.postgresql.Driver"
            maximumPoolSize = 100
            isAutoCommit = false
            transactionIsolation = "TRANSACTION_REPEATABLE_READ"
            validate()
        }
        return HikariDataSource(config)
    }
}