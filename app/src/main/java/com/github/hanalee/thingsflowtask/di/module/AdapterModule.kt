package com.github.hanalee.thingsflowtask.di.module

import com.github.hanalee.thingsflowtask.view.adapter.MainAdapter
import org.koin.dsl.module

val adapterModule = module {
    factory { MainAdapter() } // 요청할 때마다 생성
}