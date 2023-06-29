package com.gbl.neuro.network

import retrofit2.Retrofit
import retrofit2.converter.scalars.ScalarsConverterFactory
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.POST

private const val BASE_URL = "http://192.168.178.39:3000"

private val retrofit = Retrofit.Builder().addConverterFactory(ScalarsConverterFactory.create()).baseUrl(BASE_URL).build()

interface ExperimentApiService {
    @POST("experiment")
    @FormUrlEncoded
    suspend fun getAnswer(
        @Field("Data") data: String,
        @Field("Name") name: String,
        @Field("Device") device: String,
        @Field("SensorId") sensor_id: String,
        @Field("Timestamp") timestamp: String,


        ): String
}

object ExperimentApi {
    val retrofitService : ExperimentApiService by lazy {
        retrofit.create(ExperimentApiService::class.java)
    }
}