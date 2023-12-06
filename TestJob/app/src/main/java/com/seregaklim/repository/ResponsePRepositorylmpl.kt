package com.seregaklim.repository

import android.util.Log
import androidx.lifecycle.map
import com.seregaklim.api.PostsApi
import com.seregaklim.dao.ResponsePDao
import com.seregaklim.data.ResponseX
import com.seregaklim.entity.ResponsePEntity
import com.seregaklim.entity.toDto
import com.seregaklim.entity.toEntity
import com.seregaklim.error.ApiError
import com.seregaklim.error.NetworkError
import java.io.IOException


class ResponsePRepositorylmpl(private val db: ResponsePDao) : ResponsePRepository {
    override val data = db.getAll().map(List<ResponsePEntity>::toDto)

    override suspend fun getpaymentsAuth(
        token: String,
    ) {
        try {
            val response = PostsApi.service.getpaymentsAuth(token)
            if (!response.isSuccessful) {
                throw ApiError(response.code(), response.message())
            }
          //  Log.d("MyLog", " listResponse ${response.body()!!.response}")
            val listResponseX = response.body()!!.response
        //  Log.d("MyLog", "  listResponseX ${ listResponseX}")
            listResponseX.map {
            db.insert(
                ResponsePEntity(
                    amount =it.amount,
                    created = it.created,
                    id = it.id,
                    title = it.title
                )

            )
        }

      } catch (e: IOException) {
            throw NetworkError
        } catch (e: Exception) {

        }
    }

}
