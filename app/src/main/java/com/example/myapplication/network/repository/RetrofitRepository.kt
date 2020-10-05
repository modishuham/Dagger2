package com.example.myapplication.network.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.myapplication.MyRetroApplication
import com.example.myapplication.network.di.APIComponent
import com.example.myapplication.network.model.PostInfo
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Response
import retrofit2.Retrofit
import javax.inject.Inject

class RetrofitRepository {
    var postInfoMutableList: MutableLiveData<List<PostInfo>> = MutableLiveData()

    @Inject
    lateinit var retrofit: Retrofit

    init {
        val apiComponent: APIComponent = MyRetroApplication.apiComponent
        apiComponent.inject(this)
    }

    fun fetchPostInfoList(): LiveData<List<PostInfo>> {
        CoroutineScope(Dispatchers.IO).launch {
            val response = getPostFromAPI()
            if (response.isSuccessful) {
                postInfoMutableList.postValue(response.body())
            }
        }
        return postInfoMutableList
    }

    private suspend fun getPostFromAPI(): Response<List<PostInfo>> {
        val apiService: APIService = retrofit.create(APIService::class.java)
        return apiService.makeRequest()
    }

}