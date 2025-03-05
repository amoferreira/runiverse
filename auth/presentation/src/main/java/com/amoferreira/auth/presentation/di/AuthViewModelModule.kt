package com.amoferreira.auth.presentation.di

import com.amoferreira.auth.presentation.register.RegisterViewModel
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module

val authViewModelModule = module {
    singleOf(::RegisterViewModel)
}