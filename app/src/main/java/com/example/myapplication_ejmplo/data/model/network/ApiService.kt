package com.example.myapplication_ejmplo.data.model.network

import com.example.myapplication_ejmplo.data.model.ServiceModel
import retrofit2.Response
import retrofit2.http.*

interface ApiService {
    @GET("service")
    suspend fun getServices(): Response<List<ServiceModel>>

    @GET("service({id}")
    suspend fun getService(@Path("id") id: Int): Response<List<ServiceModel>>

    @POST("service")
    suspend fun createService(@Body service: ServiceModel): Response<List<ServiceModel>>

    @PUT("service/{id}")
    suspend fun updateService(@Path("id") id: Int, @Body service: ServiceModel): Response<List<ServiceModel>>

    @DELETE("service")
    suspend fun deleteService(@Path("id") id: Int): Response<List<ServiceModel>>
}