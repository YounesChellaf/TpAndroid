package com.example.stockage_local

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.room.Room
import okhttp3.Response
import retrofit2.Call
import retrofit2.Callback




class MainActivity : AppCompatActivity() {
    lateinit var inserer:Button
    var teamid:Int = 0
   
    lateinit var continent:String
    lateinit var name_team:String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        inserer =  findViewById<Button>(R.id.button)
        val text = findViewById(R.id.textView) as TextView
        inserer.setOnClickListener(View.OnClickListener {

            val intent = Intent(this@MainActivity,insertion::class.java)
            startActivity(intent)
        })
        val call = RetrofitService.endpoint.getTeams()
        call.enqueue(object:Callback<List<Team>>{
            override fun onFailure(call: Call<List<Team>>, t: Throwable) {
                Toast.makeText(this@MainActivity,t.toString()+"test", Toast.LENGTH_LONG).show()
            }
            override fun onResponse(call: Call<List<Team>>, response: retrofit2.Response<List<Team>>) {
                if(response.isSuccessful) {
                    val list:List<Team>? = response.body()
                      text.setText(list?.get(1)?.team_name.toString())
                    }
            }
        })


    }

}
