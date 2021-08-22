package com.example.moviles

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.ContextMenu
import android.view.MenuItem
import android.view.View
import android.widget.*

class BListView : AppCompatActivity() {
    var posicionItemSeleccionado = 0;
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_blist_view)


        val arregloNumeros = BBaseDatosMemoria.arregloEntrenadores

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
                BEntrenador("Prueba", "d@d.com"), arregloNumeros, adaptador
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


        // obtener elemento array cuando selecciono...
        var info = menuInfo as AdapterView.AdapterContextMenuInfo
        val id = info.position
        posicionItemSeleccionado = id;

        Log.i("list-view", "list view ${id}")
        Log.i("list-view", "entrenador ${BBaseDatosMemoria.arregloEntrenadores[id]}")

    }

    override fun registerForContextMenu(view: View?) {
        super.registerForContextMenu(view)
    }

    fun anadirItemsAListView(valor: BEntrenador,
                             arreglo: ArrayList<BEntrenador>,
                             adaptador: ArrayAdapter<BEntrenador>
    ){
        arreglo.add(valor)
        adaptador.notifyDataSetChanged()
    }

    override fun onContextItemSelected(item: MenuItem): Boolean {
        return when(item?.itemId){
            // editar
            R.id.mi_editar ->{
                Log.i("list-view","Editar ${BBaseDatosMemoria.arregloEntrenadores[posicionItemSeleccionado]}")
                return true
            }

            // Eliminar

            R.id.mi_eliminar ->{
                Log.i("list-view","Eliminar ${BBaseDatosMemoria.arregloEntrenadores[posicionItemSeleccionado]}")
                return true
            }

            else -> super.onContextItemSelected(item)
        }
    }
}