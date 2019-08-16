package com.example.stockage_local

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = arrayOf(Team::class,Player::class),version = 1)
abstract class Appatabase: RoomDatabase() {
    abstract fun getTeamDo(): inter_Team.teamDao
    abstract fun getPlayerDo(): inter_Player.PlayerDao
}