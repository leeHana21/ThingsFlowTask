package com.github.hanalee.thingsflowtask.domain.repository

import com.github.hanalee.thingsflowtask.domain.retrofit.MainApiClient


class MainRepository {
    suspend fun getIssues(org: String, repo: String) =
        MainApiClient.getInstance().getIssues(org, repo)
}