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


    // OPERADORES OR y AND
    // OR -> ANY (alguno cumple)
    // AND -> ALL (todos cumplen)

    val respuestaAny: Boolean = arregloDinamico
        .any{valorActual: Int ->
        return@any (valorActual > 5)
    }
    println(respuestaAny)
    val respuestaAll: Boolean = arregloDinamico
        .all{valorActual: Int ->
            return@all (valorActual > 5)
        }
    println(respuestaAll)

    // REDUCE -> devuelve valor acumulado
    // 1) devuelve el valor acumulado
    // 2) en que valor empieza

    // [1, 2, 3, 4, 5] -> sumemos todos los valores del arreglo
    // perite trabajar con los elementos del arreglo

    val respuestaReduce: Int = arregloDinamico
        .reduce{//acumulado = 0 -> simepre empieza en 0
            acumulado: Int, valorActual: Int ->
            return@reduce acumulado + valorActual;
        }
    println(respuestaReduce)

    // 100
    val arregloDanio = arrayListOf<Int>(12, 15, 8, 10)
    val respuestaReduceFold = arregloDanio
        .fold(100
        ) { acumulado, valorActualIteracion ->
            return@fold acumulado + valorActualIteracion
        }
    println(respuestaReduceFold)

    val vidaActual: Int = arregloDinamico
        .map { it * 2 }
        .filter { it > 20 }
        .fold(100) { acc, i -> acc - i }
        .also { println(it) }
    println("vida actual $vidaActual")

    val ejemploUno = Suma(1, 2)
    val ejemploDos = Suma(null, 2)
    val ejemploTres = Suma(1, null)

    println(ejemploUno.sumar())
    println(Suma.historialSumas)
    println(ejemploDos.sumar())
    println(Suma.historialSumas)
    println(ejemploTres.sumar())
    println(Suma.historialSumas)

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

abstract class NumerosJava{
    protected val numero1: Int
    private val numero2: Int

    constructor(
        uno: Int, //parametro requerido
        dos: Int //parametro requerido
    )
    {
        numero1 = uno;
        numero2 = dos
        println("Inicializar")
    }
}

abstract class Numeros(//constructor primario
    protected  var numeroUno: Int, // propiedad
    protected  var numeroDos: Int,
){
    init { //bloque de inicio del constructor primario
        println("inicializar")
    }
}
class Suma(
    uno: Int, // parametro requerido
    dos: Int
): Numeros( //constructor papa (super)
    uno,
    dos
){
    init {
        this.numeroUno
        this.numeroDos
    }
    constructor(//segundo constructor
        uno: Int?,
        dos: Int
    ): this(// llamda constructor primario
        if(uno == null) 0 else uno,
        dos
    )
    constructor(//tercer constructor
        uno: Int,
        dos: Int?
    ): this(// llamada constructor primario
        uno,
        if(dos == null) 0 else dos,

    )
    // por defecto todas las propiedades, fnciones son publicas por defecto
    fun sumar(): Int{
        val total: Int = numeroUno + numeroDos
        agregarHistorial(total)
        return total;
    }

    // SINGLETON -> no se van a instancias varias veces lo q este ahi
    companion object{
        val historialSumas = arrayListOf<Int>()
        fun agregarHistorial(valorNuevaSuma: Int){
            historialSumas.add(valorNuevaSuma)
            println(historialSumas)
        }
    }

}