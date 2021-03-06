/*
 * Copyright 2020 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.google.samples.apps.sunflower.api

import com.whereisdarran.homelesshelper.BuildConfig
import com.whereisdarran.homelesshelper.model.Resource
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import okhttp3.logging.HttpLoggingInterceptor.Level
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

/**
 * Used to connect to the Unsplash API to fetch photos
 */
interface BackendlessService {

    @GET("resource")
    suspend fun getResources(): List<Resource>

    companion object {
        private const val REST_API_KEY = BuildConfig.BACKENDLESS_ACCESS_KEY
        private const val BASE_URL = "https://api.backendless.com/E1AF80E4-794A-8993-FFAB-1D19AA6C4C00/$REST_API_KEY/data/"

        fun create(): BackendlessService {
            val logger = HttpLoggingInterceptor().apply { level = Level.BASIC }

            val client = OkHttpClient.Builder()
                .addInterceptor(logger)
                .build()

            return Retrofit.Builder()
                .baseUrl(BASE_URL)
                .client(client)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(BackendlessService::class.java)
        }
    }
}
