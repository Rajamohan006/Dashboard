package com.example.dashboard.presentation.linkScreen

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.dashboard.data.local.Link
import com.example.dashboard.data.local.Resource
import com.example.dashboard.data.repository.LinksRepository
import kotlinx.coroutines.launch

class LinkScreenViewModel(
    private val repository: LinksRepository
) : ViewModel() {
    private val _links = MutableLiveData<Resource<List<Link>>>()
    val links: LiveData<Resource<List<Link>>> = _links

    init {
        getLinks()
    }

    fun getLinks() {
        viewModelScope.launch {
            _links.value = Resource.Loading()
            _links.value = repository.getLinks()
        }
    }


}
