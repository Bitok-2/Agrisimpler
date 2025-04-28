package com.enock.agrisimpler.repository

import com.enock.agrisimpler.data.UserDao
import com.enock.agrisimpler.model.User

class UserRepository(private val userDao: UserDao) {
    suspend fun registerUser(user: User) {
        userDao.registerUser(user)
    }

    suspend fun loginUser(email: String, password: String): User? {
        return userDao.loginUser(email, password)
    }
}