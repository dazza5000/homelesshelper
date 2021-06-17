package com.whereisdarran.homelesshelper.ui.main

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch


class MainViewModel : ViewModel() {

    init {
        getResources()
    }

    val resource = MutableLiveData<String>("woot")

    private fun getResources() = viewModelScope.launch {
        Log.d("darran", "yolo")
    }
}