package com.example.stockage_local

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main2.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class Main2Activity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)


        val call=RetrofitService.endpoint.getTeams()
        call.enqueue(object :Callback<List<Team>>{
            override fun onFailure(call: Call<List<Team>>, t: Throwable) {
                Toast.makeText(this@Main2Activity,t.toString()+"test", Toast.LENGTH_LONG).show()
            }
            override fun onResponse(call: Call<List<Team>>, response: Response<List<Team>>) {
                if (response.isSuccessful){
                    val list=response.body()
                    val listtitle = mutableListOf<String>()
                    for(item:Team in list!!){
                        listtitle.add(item.team_name)
                    }
                    val adapter =ArrayAdapter(this@Main2Activity,android.R.layout.simple_list_item_1,listtitle)
                    ListView2.adapter=adapter
                }
                else{
                    Toast.makeText(this@Main2Activity,"ajouter", Toast.LENGTH_LONG).show()
                }
            }
        })
    }
}
