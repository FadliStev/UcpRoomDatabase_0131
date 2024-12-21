package com.example.ucp_2_b.repository

import com.example.ucp_2_b.data.entity.Suplier
import kotlinx.coroutines.flow.Flow

interface RepositorySuplier {

    suspend fun insertSpl(suplier: Suplier)

    fun getAllSpl(): Flow<List<Suplier>>
}