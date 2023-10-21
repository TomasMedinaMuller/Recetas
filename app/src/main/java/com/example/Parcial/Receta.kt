package com.example.Parcial

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Receta(
    val id : Int,
    val nombre : String,
    val dificultad : Nivel,
    val origen : Pais,
    val logo : String,
    val ingredientes : String
) : Parcelable
enum class Pais{
    Argentina,
    Alemania,
    China,
    Japon,
    Mexico,
    España,
    Venezuela
}
enum class Nivel {
    Facil,
    Medio,
    Dificil,
    Experto
}
