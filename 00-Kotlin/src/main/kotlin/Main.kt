import java.util.*
import kotlin.collections.ArrayList

fun main(){
    print("Hola Mundo")
    print("I am Jonathan, I am from Ecuador")

    var edadProfesor: Int = 32;
    // var edadProsor: Int = 32;-- casi no se utiliza

    var sueldoProfesor = 1.23;
    edadProfesor = 25;

    // Duck Typing. dentro de kotlin no necesitamos definir las variables, porque el va
    // tratar de entender que tipo de dato es.

    // --variables mutables e inmutables

    // MUTABLES (RE asignar "=")
    var _edadCachoroo: Int = 0;
    _edadCachoroo = 1
    _edadCachoroo = 2
    _edadCachoroo = 3
    _edadCachoroo = 4

    // INMUTABLE (NO RE asignar "=")
    val numeroCedula = 1452365241
     // en cualquier lenguaje de programacion solo utilizaremos variables inmutables (solo lectura)

    // Tipos de variables (JAVA)
    // primitivos:
    val nombreProfesor: String = "Jona"
    val sueldo: Double = 1.2
    val estadoCivil: Char = 'S'
    val fechaNacimiento: Date = Date()

    // Condicionales

    if(true){
        // verdadera
    }else{
        // false
    }

    // switch Estado - S -> c -> ;;;;;
    val estadoCivilWhen: String = "S";

    when(estadoCivilWhen){
        ("S") -> {
           println("Acercarse")
        }
        "C" ->{
            println("Alejarse")
        }
        "UN" -> println("Hablar")
        else -> println("No reconocido")

    }
    val coqueteo = if (estadoCivilWhen == "S") "SI" else "NO"
    // condicion ? bloque-true: bloque-false

    imprimitNombre("Jonathan");
    val resp = calcularSueldo(100.00);
    val resp2 = calcularSueldo(100.00, 14.00);
    val resp3 = calcularSueldo(100.00, 14.00, 25.00);

    println("sueldo1: $resp sueldo2: $resp2")

    // Named Parameters
    calcularSueldo(bonoEspecial = 15.00, sueldo = 1235.52, tasa = 12.00)
    calcularSueldo(bonoEspecial = 15.00, sueldo = 1235.52)

    // ******** tipos de arreglos *******

    // arreglos estaticos
    val arregloEstaticos: Array<Int> = arrayOf(1,2,3);
    // no se puede modificar el arreglo

    // arreglos dinamicos
    val arregloDinamico: ArrayList<Int> = arrayListOf(1,2,3,4,5,6,7,8,9,10)
    arregloDinamico.add(11)
    arregloDinamico.add(12)
    print(arregloDinamico)

    // OPERADORES -> sirven para los arreglos estaticos y dinamicos

    // FOR EACH -> devuelve Unit (nada)
   // iterar un arreglo

    val respuestaForEach: Unit = arregloDinamico
        .forEach { valorActual: Int ->
            println("valor actual: $valorActual")
        }
    println(respuestaForEach)

    arregloDinamico
        .forEachIndexed{indice: Int, valorActual: Int ->
            println("valor $valorActual Indice: $indice")
        }
    arregloDinamico.forEach {
        println("valor Actual: $it")
    }


    // MAP -> muta el arreglo (cambiar al arreglo)
    // 1) enviemos el nuevo valor de la iteracion
    // 2) nos devuelve es un NUEVO ARREGLO con los valores modificados

    val respMap: List<Double> = arregloDinamico.map { valorActual: Int ->
        return@map valorActual.toDouble() + 100.00;
    }
    println(respMap)


    println(arregloDinamico.map { it + 15
    })


    // FILTER -> filtrar el arreglo
    // 1) devuelve una expresion (TRUE o False)
    // 2) Nuevo arreglo filtrado

    val respuestaFilter: List<Int> = arregloDinamico.filter {
        valorActual: Int ->
        val mayoresACinco: Boolean = valorActual < 5
        return@filter mayoresACinco
    }
    print(respuestaFilter)

    val respuestaFilterDos: List<Int> = arregloDinamico.filter {it >= 5}
    print(respuestaFilterDos)



} // FIN BLOQUE MAIN

fun imprimitNombre(nombre: String): Unit{
    println("Nombre: $nombre");
}

// lo que no devuelve nada se llama Unit

fun calcularSueldo(
    sueldo: Double, // parametro requerido
    tasa: Double = 12.00, // parametro opcional (valor por defecto)
    bonoEspecial: Double? = null // opcional (NULL -> nullable)
): Double {
    // String -> String?
    // Int -> Int?
    // Date -> Date?

    if (bonoEspecial == null) {
        return return sueldo * (100 / tasa)
    }
    return sueldo * (100 / tasa) + bonoEspecial;
}


