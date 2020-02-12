package com.example.mvvm_base_kotlin.base

import com.example.mvvm_base_kotlin.base.application.App
import com.example.mvvm_base_kotlin.base.application.StarterApplication
import com.example.mvvm_base_kotlin.data.ExampleRepository
import com.example.mvvm_base_kotlin.data.ExampleRepositoryMock
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers.Main
import org.koin.dsl.module.module

val appModule = module {
    factory {
        App()
    } bind StarterApplication::class

    factory {
        ExampleRepositoryMock()
    } bind ExampleRepository::class
}

val dispatcherModule = module {
    factory { Main as CoroutineDispatcher }
}