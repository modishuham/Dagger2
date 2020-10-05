package com.example.myapplication.network.repository

import com.example.myapplication.network.model.PostInfo
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET

interface APIService {

    @GET("posts")
    suspend fun makeRequest(): Response<List<PostInfo>>
}