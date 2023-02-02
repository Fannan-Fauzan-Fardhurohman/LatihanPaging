package id.fannan.implementpaging.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.cachedIn
import dagger.hilt.android.lifecycle.HiltViewModel
import id.fannan.implementpaging.network.remote.ApiService
import id.fannan.implementpaging.paging.MainPagingSource
import javax.inject.Inject

@HiltViewModel
class MainViewModel
@Inject
constructor(private val apiService: ApiService) : ViewModel() {

    val listData = Pager(PagingConfig(pageSize = 1)) {
        MainPagingSource(apiService)
    }.flow.cachedIn(viewModelScope)
}
