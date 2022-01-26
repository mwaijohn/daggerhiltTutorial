package com.example.daggertuts.di//package com.example.daggertuts
//
//import android.content.Context
//import dagger.Module
//import dagger.Provides
//import dagger.hilt.InstallIn
//import dagger.hilt.android.components.ActivityComponent
//import dagger.hilt.android.qualifiers.ApplicationContext
//import dagger.hilt.android.scopes.ActivityScoped
//import javax.inject.Named
//
////container for
//@Module
//@InstallIn(ActivityComponent::class)
//object ActivityModule {
//
//    @Provides //with this function provide string
////    @ActivityScoped //only one instance
//    @Named("string2")
//    fun provideString(
//        @ApplicationContext context: Context,
//        stringFromAppModule: String //constructed from app module
//    ): String = "${context.getString(R.string.activity_string)}  - $stringFromAppModule"
//
//}