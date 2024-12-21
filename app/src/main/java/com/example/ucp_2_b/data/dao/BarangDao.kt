package com.example.ucp_2_b.data.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.ucp_2_b.data.entity.Barang
import kotlinx.coroutines.flow.Flow

@Dao
interface BarangDao {
    @Query("SELECT * FROM barang ORDER BY nama ASC")
    fun getAllBarang(): Flow<List<Barang>>

    @Insert
    suspend fun insertBarang( barang: Barang )

    @Update
    suspend fun updateBarang( barang: Barang )

    @Delete
    suspend fun deleteBarang( barang: Barang )
}