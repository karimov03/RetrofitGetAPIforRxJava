package com.example.retrofitgetapiforrxjava

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.annotation.MainThread
import com.example.retrofitgetapiforrxjava.Retrofit.RetrofitClient
import com.example.retrofitgetapiforrxjava.Retrofit.RetrofitServise
import com.example.retrofitgetapiforrxjava.databinding.ActivityMainBinding
import com.example.retrofitgetapiforrxjava.models.Movie
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.create

class MainActivity : AppCompatActivity() {
    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
//        RetrofitClient.getApiClient().getApi().enqueue(object :Callback<ArrayList<Movie>>{
//            override fun onResponse(
//                call: Call<ArrayList<Movie>>,
//                response: Response<ArrayList<Movie>>
//            ) {
//                if (response.isSuccessful){
//                    binding.myTv.text=response.body().toString()
//                }
//                else{
//                    binding.myTv.text="Ma'lumot olib kelishta Xatolik"
//                }
//            }
//
//            override fun onFailure(call: Call<ArrayList<Movie>>, t: Throwable) {
//                Toast.makeText(this@MainActivity, "404 Not Fount", Toast.LENGTH_SHORT).show()
//            }
//
//        })
//
//        // Call obyektini Single obyektiga o'zgartiramiz
//        val single: Single<ArrayList<Movie>> = Single.create { emitter ->
//            val call = RetrofitClient.getRetrofit().create(RetrofitServise::class.java).getApi()
//            try {
//                val response = call.execute()
//                if (response.isSuccessful) {
//                    emitter.onSuccess(response.body()!!)
//                } else {
//                    emitter.onError(Throwable("HTTP Error: ${response.code()}"))
//                }
//            } catch (e: Exception) {
//                emitter.onError(e)
//            }
//        }
//
//// Single obyektini ishga tushiramiz
//        val dep = single.subscribeOn(Schedulers.io())
//            .observeOn(AndroidSchedulers.mainThread())
//            .subscribe(
//                { result ->
//                    // Ma'lumotlarni ishlash va UI-ni yangilash
//                    binding.myTv.text=result.toString()
//                },
//                { error ->
//                    // Xatoliklarni qaytarish
//                    Toast.makeText(this@MainActivity, "Xatolik: ${error.message}", Toast.LENGTH_SHORT).show()
//                }
//            )
//
//


//Endi RxJava bilan ko'ramiz
        val dep= RetrofitClient.getRetrofit().create(RetrofitServise::class.java).getApi().subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(
                {result->
                    binding.myTv.text=result.toString()
                },
                {error->
                    Toast.makeText(this@MainActivity, "Xatolik: ${error.message}", Toast.LENGTH_SHORT).show()

                }
            )
    }

}