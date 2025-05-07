package com.enock.agrisimpler.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "products")
data class Product(
    @PrimaryKey(autoGenerate = true) val id: String = 0,
    val name: Int,
    val price: Double,
    val phone: String,
    val imagePath: String
)
