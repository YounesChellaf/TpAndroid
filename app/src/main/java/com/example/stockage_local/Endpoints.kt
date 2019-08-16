package com.example.stockage_local

import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface Endpoints {

    // Call<List<Book>: une fonction callback qui retourne une liste
    @GET("/api/v1/team")
    fun getTeams(): Call<List<Team>>
    // Call the get player method
    @GET("/api/v1/player")
    fun getPlayers(): Call<List<Player>>
    // Envoi d'un paramètre name
    @GET("api/v1/team/{isbn}/players")
    fun detailPlayer(@Path("isbn") isbn:String):Call<Team>
    // Envoi d'un paramètre book dans le message body
    @POST("api/v1/team")
    fun addTeam(@Body team: Team):Call<String>
}