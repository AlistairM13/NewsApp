package com.alistair.newsapp.util

// Sealed class - type of abstract class but only specified classes are allowed to inherit from it
// Resource class - used to wrap around the success, error and loading states
sealed class Resource<T>(
    val data: T? = null,
    val message: String? = null,
) {

    class Success<T>(data: T) : Resource<T>(data)
    class Error<T>(message: String, data: T? = null) : Resource<T>(data, message)
    class Loading<T> : Resource<T>()

}