package com.example.stockage_local

import androidx.room.*

interface inter_Player {
    @Dao
    interface PlayerDao {
        @Query("select * from players where first_name=:first_name")
        fun getPlayers(first_name:String):List<Player>
        @Insert
        fun addPlayers(player:Player)
        @Update
        fun updatePlayers(player:Player)
        @Delete
        fun deletePlayers(player:Player) }
}