package com.github.hanalee.thingsflowtask.di.module

import com.github.hanalee.thingsflowtask.domain.repository.MainRepository
import org.koin.dsl.module

val repositoryModule = module {
    single { MainRepository() }
}