package io.bintang.todo.vo

sealed class ValidationResult {
    object VALID : ValidationResult()
    class INVALID(val errorMessage: String) : ValidationResult()
}