package com.example.ucp_2_b.repository

import com.example.ucp_2_b.data.dao.SuplierDao
import com.example.ucp_2_b.data.entity.Suplier
import kotlinx.coroutines.flow.Flow

class LocalRepositorySuplier(
    private val suplierDao: SuplierDao
): RepositorySuplier {

    override suspend fun insertSpl(suplier: Suplier) {
        suplierDao.insertSuplier(suplier)
    }

    override fun getAllSpl(): Flow<List<Suplier>> {
        return suplierDao.getAllSuplier()
    }
}