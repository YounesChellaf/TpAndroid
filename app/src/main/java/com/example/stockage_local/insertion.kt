package com.example.stockage_local

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_insertion.*
import retrofit2.Callback
import retrofit2.Call
import retrofit2.Response

class insertion : AppCompatActivity() {
    lateinit var inserer:Button
    lateinit var synch:Button




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_insertion)

      val name= findViewById(R.id.nameteam) as TextView
        val cont = findViewById(R.id.continent) as TextView
        val id = findViewById(R.id.idteam) as TextView
        inserer =  findViewById<Button>(R.id.insertion)
        synch  = findViewById<Button>(R.id.synchronistation)

        synch.setOnClickListener(View.OnClickListener {

            val intent = Intent(this@insertion, Main2Activity::class.java)
            startActivity(intent)
        })

        inserer.setOnClickListener(View.OnClickListener {

                  var team1:Team
                  team1=Team(id.getText().toString().toInt(),name.getText().toString(),cont.getText().toString() )


                  val call=RetrofitService.endpoint.addTeam(team1)

                    call.enqueue(object : Callback<String> {
                        override fun onFailure(call: Call<String>, t: Throwable) {

                            Toast.makeText(this@insertion,t.toString()+"test", Toast.LENGTH_LONG).show()

                        }
                        override fun onResponse(call: Call<String>, response: Response<String>) {
                if (response.isSuccessful){
                    Toast.makeText(this@insertion,"ajouter", Toast.LENGTH_LONG).show()
                }
                else{
                    Toast.makeText(this@insertion,"erreur", Toast.LENGTH_LONG).show()
                }
            }
        })
        })
    }
}
