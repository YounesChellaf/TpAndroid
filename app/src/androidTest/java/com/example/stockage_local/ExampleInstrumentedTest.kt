package com.example.stockage_local

import androidx.room.Database
import androidx.room.Room
import androidx.test.InstrumentationRegistry
import androidx.test.runner.AndroidJUnit4
import org.junit.Assert

import org.junit.Test
import org.junit.runner.RunWith

import org.junit.Assert.*
import org.junit.Before

/**
 * Instrumented test, which will execute on an Android device.
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@RunWith(AndroidJUnit4::class)
class ExampleInstrumentedTest {
 lateinit var mDataBase:AppDatabase
    @Before
    fun initDB() {
        mDataBase =
            Room.inMemoryDatabaseBuilder(InstrumentationRegistry. getInstrumentation().context,AppDatabase::class.java).build()
    }
    @Test
    fun testInsertAndGetUser() {
        val team1 = Team(1, "CRB","Alger")
        val team2 = Team (2,"JSK","TIZI")

        val Player1 = Player(1,"Adel","Djerrar",29,75.0,1)
        val Player2 = Player(2,"Amir","Sayoud",30,79.0,1)
        val Player3 = Player(3, "Yougherta", "Hamroun", 23,80.0,2)
       val Player4=  Player(4,"Abdelkader","salhi",27,75.0,2)

        mDataBase?.getTeamDo()?.addTeam(team1)
        mDataBase?.getTeamDo()?.addTeam(team2)


        mDataBase?.getPlayerDo()?.addPlayers(Player1)
        mDataBase?.getPlayerDo()?.addPlayers(Player2)
        mDataBase?.getPlayerDo()?.addPlayers(Player3)
        mDataBase?.getPlayerDo()?.addPlayers(Player4)

        var CRB:List<Player> = mDataBase?.getPlayerDo()?.getPlayers("CRB")
        var Test :MutableList<Player> = mutableListOf<Player>(Player1,Player2)
//        Assert.assertArrayEquals(CRB.toTypedArray() ,Test.toTypedArray())
    }
}
