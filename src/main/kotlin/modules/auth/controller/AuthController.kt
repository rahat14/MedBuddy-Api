package com.syntex_error.modules.auth.controller

import com.syntex_error.database.models.user.RegisterRequest
import com.syntex_error.database.models.user.RegisterResponse
import com.syntex_error.database.tables.UserDAO
import com.syntex_error.database.tables.UserTable
import com.syntex_error.modules.auth.repo.AuthRepo
import com.syntex_error.utils.query

class AuthController  : AuthRepo {

    override suspend fun register(registerRequest: RegisterRequest)  : Any  = query {

        val userEntity =
            UserDAO.Companion.find { UserTable.email eq registerRequest.email }
                .toList().singleOrNull()

        if (userEntity != null) {
            "User already exists"
        }else {

          val inserted =   UserDAO.new {
                email = registerRequest.email
                password = registerRequest.password

            }

            RegisterResponse(
                inserted.id.value, registerRequest.email,
                message = "User Registered Successfully"
            )




        }


    }


}