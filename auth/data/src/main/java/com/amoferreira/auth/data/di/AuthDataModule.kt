package com.amoferreira.auth.data.di

import com.amoferreira.auth.data.EmailPatternValidator
import com.amoferreira.auth.domain.PatternValidator
import com.amoferreira.auth.domain.UserDataValidator
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module

val authDataModule = module {
    single<PatternValidator> {
        EmailPatternValidator
    }
    singleOf(::UserDataValidator)
}