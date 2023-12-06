package com.seregaklim.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.seregaklim.api.PostsApi
import com.seregaklim.data.AuthRequest
import com.seregaklim.data.UserToken
import com.seregaklim.entity.ResponsePEntity
import com.seregaklim.error.ApiError
import com.seregaklim.error.NetworkError

import kotlinx.coroutines.launch
import java.io.IOException

class SignViewModel() : ViewModel() {

    val erorAuth= MutableLiveData<UserToken>()
    val tokenData = MutableLiveData<String>()

    fun sigAuth(authRequest: AuthRequest) = viewModelScope.launch {

        try {
            val response = PostsApi.service.auth(authRequest)
            if (!response.isSuccessful) {
                throw ApiError(response.code(), response.message())
            }
            val body = response.body() ?: throw ApiError(response.code(), response.message())
            erorAuth.value = body
            tokenData.value=body.response.token

        } catch (e: IOException) {
            throw NetworkError
        } catch (e: Exception) {

        }
    }
}
