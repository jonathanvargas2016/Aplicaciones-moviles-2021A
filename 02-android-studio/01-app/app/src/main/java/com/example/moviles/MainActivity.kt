package com.example.moviles

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //encontrar un boton por ID
        val bottonIrCicloVida = findViewById<Button>(
            R.id.btn_ciclo_vida
        )
        //llamar a la fun cuando hace clic
        bottonIrCicloVida.setOnClickListener {
            abrirCicloVida();
        }
    }

    fun abrirCicloVida(){
        val intentExplicito = Intent(
            this,
            ACicloVida::class.java
        )
        startActivity(intentExplicito);
    }
}