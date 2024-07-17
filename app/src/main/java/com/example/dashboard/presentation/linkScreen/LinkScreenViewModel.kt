package com.example.dashboard.presentation.linkScreen

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.dashboard.data.local.Link
import com.example.dashboard.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class LinkScreenViewModel @Inject constructor() : ViewModel() {
    private val _links = MutableLiveData<Resource<List<Link>>>()
    val links: LiveData<Resource<List<Link>>> = _links

}
