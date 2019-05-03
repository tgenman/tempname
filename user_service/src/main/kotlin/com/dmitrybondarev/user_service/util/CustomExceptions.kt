package com.dmitrybondarev.user_service.util

class EmailExistsException(message: String) : Exception(message)

class UserNotFoundException(message: String) : Exception(message)