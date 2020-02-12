package com.example.mvvm_base_kotlin

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.mvvm_base_kotlin.data.ExampleRepository

class ExampleViewModelFactory constructor(private val repository: ExampleRepository,
                                         private val application: Application
): ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T =
        with(modelClass) {
            when {
                isAssignableFrom(ExampleViewModel::class.java) ->
                    ExampleViewModel(repository, application)
                else ->
                    throw IllegalArgumentException("Unknown Class.")
            }
        } as T
}