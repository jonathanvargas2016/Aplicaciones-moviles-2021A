package com.example.moviles

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

class ACicloVida : AppCompatActivity() {
    var numero = 0;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_aciclo_vida)
        Log.i("ciclo-vida", "onCreate")
        val textViewACicloVida = findViewById<TextView>(R.id.txv_ciclo_vida)
        textViewACicloVida.text = numero.toString();
        val buttonACicloVida = findViewById<Button>(R.id.btn_aumentar_ciclo_vida)
        buttonACicloVida.setOnClickListener { aumentarNumero() }
    }
// funcion que permite guardar valores primitivos cuando cambiamos de ORIENTACION
    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.run {
            // AQUI GUARDAMOS
            // SOLO PERMITE PRIMITIVOS

            putInt("numeroGuardado", numero)
        }
        super.onSaveInstanceState(outState)
        Log.i("ciclo-vida", "onSaveInstanceState")

    }

// funcion que permite recuperar valores primitivos cuando cambiamos de ORIENTACION
    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        val numeroRecuperado: Int? = savedInstanceState.getInt("numeroGuardado")
        if(numeroRecuperado != null){
            numero = numeroRecuperado
            val textViewACicloVida = findViewById<TextView>(R.id.txv_ciclo_vida)
            textViewACicloVida.text = numero.toString();
        }
        Log.i("ciclo-vida", "onRestoreInstanceState")
    }


    fun aumentarNumero(){
        numero += 1;
        val textViewACicloVida = findViewById<TextView>(R.id.txv_ciclo_vida)
        textViewACicloVida.text = numero.toString()
        
        if(numero == 30){
            Toast.makeText(applicationContext, "Llego a los 30", Toast.LENGTH_SHORT).show()
        }
    }

    override fun onStart() {
        super.onStart()
        Log.i("ciclo-vida", "onStart")
    }

    override fun onRestart() {
        super.onRestart()
        Log.i("ciclo-vida", "onRestart")
    }

    override fun onResume() {
        super.onResume()
        Log.i("ciclo-vida", "OnResume")
    }

    override fun onPause() {
        super.onPause()
        Log.i("ciclo-vida", "onPause")
    }

    override fun onStop() {
        super.onStop()
        Log.i("ciclo-vida", "onStop")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.i("ciclo-vida", "onDestroy")
    }
}