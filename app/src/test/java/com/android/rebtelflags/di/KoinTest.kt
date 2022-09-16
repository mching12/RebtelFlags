package com.android.rebtelflags.di

import org.koin.core.context.startKoin
import org.koin.core.context.stopKoin
import org.koin.dsl.module

fun initKoin() {
    stopKoin()
    startKoin {
        modules(testModelStoreModule, testIntentFactoryModule)
    }
}

/**
 * Koin test modules
 */
val testModelStoreModule = module {
//    single { LoginViewModelStore() }
//    single { SplashModelStore() }
//    single { MainViewModelStore() }
//    single { ResetPasswordViewModelStore() }
//    single { AccessPointListModelStore() }
//    single { ChannelListModelStore() }
//    single { RequirementProfileModelStore() }
//    single { SpectrumGraphModelStore() }
//    single { InterferenceViewModelStore() }
//    single { InterferenceDetailModelStore() }
//    single { UserProfileModelStore() }
//    single { DeviceStatusModelStore()  }
//    single { ConnectivityViewModelStore() }
//    single { DataConfigNotificationModelStore() }
//    single { AccessPointDetailModelStore() }
}

val testIntentFactoryModule = module {
    // single { DataConfigNotificationIntentFactory(get()) }
}