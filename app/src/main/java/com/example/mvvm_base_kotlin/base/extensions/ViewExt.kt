package com.example.mvvm_base_kotlin.base.extensions

import android.view.View

val Boolean.shouldShowView: Int
    get() = if (this) View.VISIBLE
    else View.GONE