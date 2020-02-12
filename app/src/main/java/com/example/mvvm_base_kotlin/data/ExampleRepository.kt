package com.example.mvvm_base_kotlin.data


interface ExampleRepository {
    fun getExample(success: (ExampleData) -> Unit, failure: (ExampleData) -> Unit)
}