package com.example.ucp_2_b.repository

import com.example.ucp_2_b.data.dao.BarangDao
import com.example.ucp_2_b.data.entity.Barang
import com.example.ucp_2_b.data.entity.Suplier
import kotlinx.coroutines.flow.Flow

class LocalRepositoryBarang(
    private val barangDao: BarangDao
): RepositoryBarang {

    override suspend fun insertBrg(barang: Barang) {
        barangDao.insertBarang(barang)
    }

    override suspend fun deleteBrg(barang: Barang) {
        return barangDao.deleteBarang(barang)
    }

    override suspend fun updateBrg(barang: Barang) {
        return barangDao.updateBarang(barang)
    }

    override fun getAllBrg(): Flow<List<Barang>> {
        return barangDao.getAllBarang()
    }

    override fun getNamaSpl(nama: String): Flow<Suplier> {
        return barangDao.getNamaSuplier(nama)
    }
}