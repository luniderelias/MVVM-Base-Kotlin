package com.example.mvvm_base_kotlin.data


interface ExampleRepository {
    fun getExample(success: (Int) -> Unit, failure: (Int) -> Unit)
}