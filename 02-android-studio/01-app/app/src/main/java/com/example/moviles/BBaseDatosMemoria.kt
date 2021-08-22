package com.example.moviles

class BBaseDatosMemoria {

    // metodos y propiedades staticas que puedes tener en una clase -> Singleton.
    // puedo tener un companion object por todas las clases existentes
    companion object {
        val arregloEntrenadores = arrayListOf<BEntrenador>()
        init {
            arregloEntrenadores.add(
                BEntrenador("Jonathan", "a@a.com")
            )
            arregloEntrenadores.add(
                BEntrenador("Santiago", "b@b.com")
            )
            arregloEntrenadores.add(
                BEntrenador("Carolina", "c@c.com")
            )

        }
    }
}