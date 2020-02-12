package com.example.mvvm_base_kotlin

import android.app.Application
import android.view.View
import androidx.lifecycle.*
import com.example.mvvm_base_kotlin.base.application.App
import com.example.mvvm_base_kotlin.base.extensions.shouldShowView
import com.example.mvvm_base_kotlin.data.ExampleRepository

class ExampleViewModel(
    private val repository: ExampleRepository,
    application: Application
) : AndroidViewModel(application), LifecycleObserver {

    val loadingVisibility = MutableLiveData<Int>().apply { value = View.GONE }
    val textVisibility = MutableLiveData<Int>().apply { value = View.VISIBLE }
    val onReloadVisibility = MutableLiveData<Int>().apply { value = View.VISIBLE }
    val message = MutableLiveData<String>().apply { value = "" }

    @OnLifecycleEvent(Lifecycle.Event.ON_START)
    fun load() {
        handleTextVisibility(false)
        repository.getExample(
            { success ->
                message.postValue(getApplication<App>().getString(success.messageResId))
                handleTextVisibility(true)
            },
            { failure ->
                message.postValue(getApplication<App>().getString(failure.messageResId))
                handleTextVisibility(true)
            })
    }

    private fun handleTextVisibility(visibility: Boolean) {
        textVisibility.postValue(visibility.shouldShowView)
        loadingVisibility.postValue((!visibility).shouldShowView)
    }

    fun onReload(view: View){
        load()
    }

}