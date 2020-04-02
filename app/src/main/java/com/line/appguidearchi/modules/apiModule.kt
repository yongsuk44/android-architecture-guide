package com.line.appguidearchi.modules

import com.line.appguidearchi.ui.UserProfile.UserRepository
import org.koin.dsl.module

val apiModule = module {
    factory { UserRepository(get() , get()) }
}