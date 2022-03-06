package com.github.hanalee.thingsflowtask.domain.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.github.hanalee.thingsflowtask.domain.repository.MainRepository
import com.github.hanalee.thingsflowtask.domain.retrofit.entity.response.IssueResponse
import com.github.hanalee.thingsflowtask.utils.UtilFunction.Companion.TAG
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.launch
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

class MainViewModel : ViewModel(), KoinComponent {
    private val mainRepository: MainRepository by inject()

    private val handler = CoroutineExceptionHandler { _, exception ->
        _noData.value = Pair(true, exception)
    }

    private val _issueList = MutableLiveData<Pair<IssueResponse, String>>()
    val issueList: LiveData<Pair<IssueResponse, String>>
        get() = _issueList

    private val _noData = MutableLiveData<Pair<Boolean, Throwable?>>()
    val noData: LiveData<Pair<Boolean, Throwable?>>
        get() = _noData

    fun getIssuesAtFirstTime() = getIssueFromRemote()

    fun searchWithKeyword(org: String, repo: String) = getIssueFromRemote(org, repo)

    fun noDataFlagAfterCheckFromUser() {
        _noData.value = Pair(false, null)
    }

    private fun getIssueFromRemote(org: String? = "google", repo: String? = "dagger") =
        viewModelScope.launch(handler) {
            val response = mainRepository.getIssues(org!!, repo!!)
            if (response.size == 0) {
                _noData.value = Pair(true, Throwable("검색된 데이터가 없습니다"))
            } else {
                _issueList.value = Pair(response, "$org/$repo")
            }
        }
}