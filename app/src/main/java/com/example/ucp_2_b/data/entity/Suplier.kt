package com.example.ucp_2_b.data.entity

import androidx.room.Entity
import androidx.room.Index
import androidx.room.PrimaryKey

@Entity(
    tableName = "suplier",
    indices = [Index(value = ["nama"], unique = true)]
    )
data class Suplier(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val nama: String,
    val kontak: String,
    val alamat: String
)
