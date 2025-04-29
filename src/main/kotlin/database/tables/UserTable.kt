package com.syntex_error.database.tables

import com.syntex_error.database.BaseIntEntity
import com.syntex_error.database.BaseIntEntityClass
import com.syntex_error.database.BaseIntIdTable
import org.jetbrains.exposed.dao.id.EntityID

object UserTable : BaseIntIdTable("user") {
    val email = varchar("email", 255) // Nullable for mobile users
    val password = varchar("password", 200)
    val isVerified = bool("is_verified").default(false)

    override val primaryKey = PrimaryKey(id)

    // Create a composite unique index on email and userType
    init {
        uniqueIndex("email_userType_idx", email)
    }
}

class UserDAO(id: EntityID<String>) : BaseIntEntity(id, UserTable) {
    companion object : BaseIntEntityClass<UserDAO>(UserTable)

    var email by UserTable.email
    var password by UserTable.password
    var isVerified by UserTable.isVerified

}