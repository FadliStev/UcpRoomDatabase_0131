package com.example.ucp_2_b.repository

import com.example.ucp_2_b.data.entity.Barang
import com.example.ucp_2_b.data.entity.Suplier
import kotlinx.coroutines.flow.Flow

interface RepositoryBarang {

    suspend fun insertBrg(barang: Barang)

    suspend fun deleteBrg(barang: Barang)

    suspend fun updateBrg(barang: Barang)

    fun getAllBrg(): Flow<List<Barang>>

    fun getNamaBrg(nama: String): Flow<Barang>

    fun getNamaSpl(nama: String): Flow<Suplier>
}