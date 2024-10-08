package com.example.roomdb

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Note(

    @PrimaryKey(autoGenerate = true)
    val id : Int = 0,
    var title :String,
    var time :String,
    var date :String,
)
