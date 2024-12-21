package com.example.ucp_2_b.dependenciesinjection

import android.content.Context
import com.example.ucp_2_b.data.database.TokoDatabase
import com.example.ucp_2_b.repository.LocalRepositoryBarang
import com.example.ucp_2_b.repository.LocalRepositorySuplier
import com.example.ucp_2_b.repository.RepositoryBarang
import com.example.ucp_2_b.repository.RepositorySuplier

interface InterfaceContainerApp{
    val repositoryBarang: RepositoryBarang

    val repositorySuplier: RepositorySuplier
}

class ContainerApp(private val context: Context): InterfaceContainerApp{

    override val repositoryBarang: RepositoryBarang by lazy {
        LocalRepositoryBarang(TokoDatabase.getDatabase(context).barangDao())
    }

    override val repositorySuplier: RepositorySuplier by lazy {
        LocalRepositorySuplier(TokoDatabase.getDatabase(context).suplierDao())
    }
}

