package com.whereisdarran.homelesshelper.ui.main

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.google.samples.apps.sunflower.api.BackendlessService
import com.whereisdarran.homelesshelper.model.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ResourceViewModel @Inject constructor(val backendlessService: BackendlessService) : ViewModel() {

    init {
        getResources()
    }

    val resources = MutableLiveData<List<Resource>>(emptyList())

    private fun getResources() = viewModelScope.launch {
        val resources = backendlessService.getResources()
        this@ResourceViewModel.resources.postValue(resources)
    }
}
