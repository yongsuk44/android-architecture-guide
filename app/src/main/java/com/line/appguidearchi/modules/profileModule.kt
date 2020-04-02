package com.line.appguidearchi.modules

import com.line.appguidearchi.ui.UserProfile.UserProfileViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module


val profileModule = module {
    viewModel { UserProfileViewModel(get()) }
}