package com.example.mvvm_base_kotlin.data

import com.example.mvvm_base_kotlin.R

class ExampleRepositoryMock: ExampleRepository {

    override fun getExample(success: (ExampleData) -> Unit, failure: (ExampleData) -> Unit) {
        if(Math.random() > 0.5)
            success(ExampleData(messageResId = R.string.hello_world))
        else
            failure(ExampleData(messageResId = R.string.hello_world_failed))
    }

}