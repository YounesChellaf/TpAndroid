package com.example.stockage_local

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = arrayOf(Player::class,Team::class),version = 1)
abstract class AppDatabase :RoomDatabase(){
    abstract fun getPlayerDao(): inter_Player.PlayerDao
    abstract fun getTeamDao(): inter_Team.teamDao


}