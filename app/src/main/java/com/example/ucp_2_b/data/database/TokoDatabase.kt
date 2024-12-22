package com.example.ucp_2_b.data.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.ucp_2_b.data.dao.BarangDao
import com.example.ucp_2_b.data.dao.SuplierDao
import com.example.ucp_2_b.data.entity.Barang
import com.example.ucp_2_b.data.entity.Suplier

@Database(entities = [Barang::class , Suplier::class], version = 1, exportSchema = false)
abstract class TokoDatabase : RoomDatabase() {

    abstract fun barangDao(): BarangDao

    abstract fun suplierDao(): SuplierDao

    companion object{
        private var Instance: TokoDatabase? = null

        fun getDatabase(context: Context): TokoDatabase{
            return (Instance ?: synchronized(this) {
                Room.databaseBuilder(
                    context,
                    TokoDatabase::class.java,
                    "KrsDatabase"
                )
                    .build().also { Instance = it }
            })
        }
    }
}