package com.seregaklim.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.map
import androidx.lifecycle.viewModelScope
import com.seregaklim.data.ResponseX
import com.seregaklim.db.MainDb
import com.seregaklim.model.FeedModel
import com.seregaklim.model.FeedModelState
import com.seregaklim.repository.ResponsePRepository
import com.seregaklim.repository.ResponsePRepositorylmpl
import com.seregaklim.utils.SingleLiveEvent
import kotlinx.coroutines.launch

class ResponsePViewModel(application: Application) : AndroidViewModel(application ){

    private val repository: ResponsePRepository= ResponsePRepositorylmpl(
        MainDb.getInstance(context = application).postDao())


    val data: LiveData<FeedModel> = repository.data.map(::FeedModel)
    private val _dataState = MutableLiveData<FeedModelState>()
    val dataState: LiveData<FeedModelState>
        get() = _dataState

    fun loadPayments(token: String) = viewModelScope.launch {
        try {
            _dataState.value = FeedModelState(loading = true)
            repository.getpaymentsAuth(token)
            _dataState.value = FeedModelState()
        } catch (e: Exception) {
            _dataState.value = FeedModelState(error = true)
        }
    }
}






















