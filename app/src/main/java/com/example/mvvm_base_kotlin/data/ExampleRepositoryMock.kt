package com.example.mvvm_base_kotlin.data

import com.example.mvvm_base_kotlin.R

class ExampleRepositoryMock: ExampleRepository {

    override fun getExample(success: (Int) -> Unit, failure: (Int) -> Unit) {
        if(Math.random() > 0.5)
            success(R.string.hello_world)
        else
            failure(R.string.hello_world_failed)
    }

}