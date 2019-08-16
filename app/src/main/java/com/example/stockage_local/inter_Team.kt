package com.example.stockage_local

import androidx.room.*

interface inter_Team {
    @Dao
    interface teamDao {
        @Query("select * from teams where team_name=:firstName")
        fun getTeam(firstName:String):List<Team>
        @Insert
        fun addTeam(team:Team)
        @Update
        fun updateTeam(team: Team)
        @Delete
        fun deleteTeam(team: Team) }
    @Query("Select * from teams T , players P where T.id_team=P.team_id and T.team_name = :team_name ")

      fun getPlayersTeam (team_name:String):List<Player>
}