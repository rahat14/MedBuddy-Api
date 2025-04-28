package com.syntex_error.config
import com.syntex_error.database.tables.UserTable
import io.github.cdimascio.dotenv.dotenv
import com.zaxxer.hikari.HikariConfig
import com.zaxxer.hikari.HikariDataSource
import org.jetbrains.exposed.sql.Database
import org.jetbrains.exposed.sql.StdOutSqlLogger
import org.jetbrains.exposed.sql.SchemaUtils.create
import org.jetbrains.exposed.sql.addLogger
import org.jetbrains.exposed.sql.transactions.transaction


object DatabaseFactory {
    fun init() {
        Database.connect(hikari())
        configureDataBase()
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

fun configureDataBase() {
    transaction {
        addLogger(StdOutSqlLogger)
        create(
            UserTable
        )
    }
}