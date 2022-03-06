package com.github.hanalee.thingsflowtask.domain.remote_source

import com.github.hanalee.thingsflowtask.domain.remote_source.entity.response.IssueResponse
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Path

interface MainApiInterface {
    @Headers("Content-Type: application/json")
    @GET("repos/{org}/{repo}/issues")
    suspend fun getIssues(@Path("org") org: String,
                          @Path("repo") repo: String): IssueResponse
}