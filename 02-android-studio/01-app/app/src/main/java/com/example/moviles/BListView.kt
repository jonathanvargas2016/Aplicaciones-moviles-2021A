package com.example.moviles

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.ContextMenu
import android.view.View
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.ListView
import android.widget.Toast

class BListView : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_blist_view)


        val arregloNumeros = arrayListOf<Int>(1, 2, 3, 4, 5, 6);

        val adaptador = ArrayAdapter(
            this, // contexto
            android.R.layout.simple_list_item_1, // layout precargado
            arregloNumeros // arreglo
        )
        val listViewEjemplo = findViewById<ListView>(R.id.ltv_ejemplo)
        listViewEjemplo.adapter = adaptador

        val botonAnadirNumeros = findViewById<Button>(R.id.btn_anadir_numero)
        botonAnadirNumeros.setOnClickListener {
            anadirItemsAListView(
                1, arregloNumeros, adaptador
            )
        }

        // devuelve posicion del item
        /*listViewEjemplo.setOnItemLongClickListener { adapterView, view, position, id ->
            Log.i("List-view", "Dio click  ${position}")
            Toast.makeText(applicationContext,"Dio click  ${position}",Toast.LENGTH_SHORT).show()

            return@setOnItemLongClickListener true
        }*/

        registerForContextMenu(listViewEjemplo)
    }

    override fun onCreateContextMenu(
        menu: ContextMenu?,
        v: View?,
        menuInfo: ContextMenu.ContextMenuInfo?
    ) {
        super.onCreateContextMenu(menu, v, menuInfo)
        val inflater = menuInflater
        inflater.inflate(R.menu.menu, menu)
    }

    override fun registerForContextMenu(view: View?) {
        super.registerForContextMenu(view)
    }

    fun anadirItemsAListView(valor: Int,
                             arreglo: ArrayList<Int>,
                             adaptador: ArrayAdapter<Int>
    ){
        arreglo.add(valor)
        adaptador.notifyDataSetChanged()
    }
}