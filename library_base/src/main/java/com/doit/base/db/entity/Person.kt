package com.doit.base.db.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Person(
    @PrimaryKey(autoGenerate = true)
    var id: Long,
    var name: String,
)
