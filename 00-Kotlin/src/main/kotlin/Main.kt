import java.util.*

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

}

