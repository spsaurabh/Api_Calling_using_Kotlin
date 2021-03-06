package com.example.api_calling

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

const val BASE_URL = "https://jsonplaceholder.typicode.com/"
class MainActivity : AppCompatActivity() {

    lateinit var myAdatper: MyAdapter
    lateinit var linearLayoutManager : LinearLayoutManager
    lateinit var recl : RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recl = findViewById(R.id.recyclerview_users)
        recl.setHasFixedSize(true)
        linearLayoutManager = LinearLayoutManager(this)
        recl.layoutManager = linearLayoutManager

        getMyData();
    }
    private fun getMyData() {
    val retrofitBuilder = Retrofit.Builder()
        .addConverterFactory(GsonConverterFactory.create())
        .baseUrl(BASE_URL)
        .build()
        .create(ApiInterface::class.java)
    val retrofitData = retrofitBuilder.getData()
        retrofitData.enqueue(object : Callback<List<MyDataItem>?> {
            override fun onResponse(
                call: Call<List<MyDataItem>?>,
                response: Response<List<MyDataItem>?>
            ) {
                val responceBody = response.body()!!
                Log.i("Main",""+response.body())

                myAdatper = MyAdapter(baseContext,responceBody)

                recl.adapter = myAdatper
                myAdatper.notifyDataSetChanged()
            }
            override fun onFailure(call: Call<List<MyDataItem>?>, t: Throwable) {
                Log.d("MainActivity","onFailure"+t.message)
            }
        })
    }

}