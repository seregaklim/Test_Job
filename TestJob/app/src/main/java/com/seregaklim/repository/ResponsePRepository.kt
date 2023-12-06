package com.seregaklim.repository

import androidx.lifecycle.LiveData
import com.seregaklim.data.ResponseX
import kotlinx.coroutines.flow.Flow


interface ResponsePRepository {
 val data: LiveData<List<ResponseX>>
 suspend fun getpaymentsAuth(token: String, ){}
}