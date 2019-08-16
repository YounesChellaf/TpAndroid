package com.example.stockage_local

import android.widget.Toast
import androidx.room.*
import retrofit2.Call
import retrofit2.Callback


@Entity(tableName ="teams" )
    data class Team(
    @PrimaryKey
    var id_team:Int,
    var team_name:String,
    var continent:String )






