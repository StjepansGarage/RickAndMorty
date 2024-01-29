package com.example.rickandmorty

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.rickandmorty.network.ApiClient
import com.example.rickandmorty.network.CharacterResponse
import retrofit2.Call
import retrofit2.Response


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val client = ApiClient.apiService.fetchCharacters("1")

        client.enqueue(object :retrofit2.Callback<CharacterResponse> {
            override fun onResponse(
                call: Call<CharacterResponse>,
                response: Response<CharacterResponse>
            ){
                if (response.isSuccessful){
                    Log.d("characters", ""+response.body())

                    val result = response.body()?.result
                    result?.let {
                        val adapter= MainAdapter(result)
                        val recyclerView =findViewById<RecyclerView>(R.id.charactersRv)
                        recyclerView?.layoutManager =LinearLayoutManager(this@MainActivity)
                        recyclerView?.adapter=adapter
                    }
                }

            }
            override fun onFailure(call: Call<CharacterResponse>,t:Throwable){
                Log.e("failed", ""+t.message)
            }
        })
    }
}