package com.example.moviles

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

class CIntentExplicitoParametros : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cintent_explicito_parametros)

        val nombre = intent.getStringExtra("nombre");
        val apellido = intent.getStringExtra("apellido");
        val edad = intent.getIntExtra("edad", 0);

        Log.i("intent-explicito","${nombre}")
        Log.i("intent-explicito","${apellido}")
        Log.i("intent-explicito","${edad}")
    }
}