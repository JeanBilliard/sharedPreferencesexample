package com.example.sharedexample

import android.content.Context
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.sharedexample.databinding.ActivityMainBinding

private const val sharedPreferecName = "comm.example.sharedexample"

class MainActivity : AppCompatActivity() {

    private lateinit var mSharedPreferences: SharedPreferences//una variable prar contenet o acceder
    //a las shared prerefences

    private lateinit var binding : ActivityMainBinding

            override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_main)
                binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        mSharedPreferences = getSharedPreferences(sharedPreferecName, Context.MODE_PRIVATE)

        val key1="key1"
        val email = "jpbilliard75@gmail.com"

        // Escribir en  las shared
        // preferences
        mSharedPreferences.edit().putString(key1, email).apply()
        mSharedPreferences.edit().putInt("key2", 100).apply()

        //reeeplazo o update
        val email2 = "jpbilliard75@gmail.com"
        mSharedPreferences.edit().putString(key1, email2).apply()


        val emailobtenido = mSharedPreferences.getString(key1, "")// leer de shared
        // preferences

        //borrar de 1   a traves de la key
        mSharedPreferences.edit().remove("key2").apply()

        // borrar shared preferences nuclear
        mSharedPreferences.edit().clear().apply()



    }
}