package com.example.ucp_2_b.data.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "suplier")
data class Suplier(
    @PrimaryKey(autoGenerate = true)
    val id: String,
    val nama: String,
    val kontak: String,
    val alamat: String
)
