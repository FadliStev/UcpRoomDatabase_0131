package com.example.ucp_2_b

import android.app.Application
import com.example.ucp_2_b.dependenciesinjection.ContainerApp

class TokoApp : Application() {

    lateinit var containerApp: ContainerApp

    override fun onCreate(){
        super.onCreate()

        containerApp = ContainerApp(this)
    }

}