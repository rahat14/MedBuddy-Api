package com.syntex_error.modules.auth.repo

import com.syntex_error.database.models.user.RegisterRequest

interface AuthRepo {

    suspend fun register(registerRequest: RegisterRequest): Any

}