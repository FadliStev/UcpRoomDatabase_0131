package com.example.ucp_2_b.data.entity

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey


@Entity(
    tableName = "barang",
    foreignKeys = [
        ForeignKey(
            entity = Suplier::class,
            parentColumns = ["nama"],
            childColumns = ["namaSuplier"],
            onDelete = ForeignKey.CASCADE
        )
    ]
    )
data class Barang(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val nama: String,
    val deskripsi: String,
    val harga: String,
    val stok: String,
    val namaSuplier: String,
)
