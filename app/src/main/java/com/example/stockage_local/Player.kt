package com.example.stockage_local

import androidx.room.*

@Entity(tableName ="players",foreignKeys = arrayOf(ForeignKey(entity =
Team::class, parentColumns = arrayOf("id_team"),
    childColumns = arrayOf("team_id"),
    onDelete = ForeignKey.CASCADE)
))
data class Player(
@PrimaryKey
var id_player:Int,
var first_name:String,
var last_name:String,
var age:Int,
var height:Double,
var team_id:Int)

