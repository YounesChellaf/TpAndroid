package com.example.stockage_local

import android.app.Application
import android.content.Context
import androidx.room.Room

        class App: Application(){
            override fun onCreate() {
                super.onCreate()
                RoomService.context = applicationContext
}
        }

