package com.example.Parcial

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.example.clase5equipodefutbol.R

class Detalle : AppCompatActivity() {
    private lateinit var tvingredientes: TextView
    private lateinit var tvname: TextView
    private lateinit var imglogo : ImageView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detalle)
        val receta = intent.getParcelableExtra<Receta>("receta")

        tvingredientes = findViewById(R.id.textViewIng)
        tvname = findViewById(R.id.textViewname)
        imglogo = findViewById(R.id.imageViewFood)

        tvname.text = receta?.nombre
        tvingredientes.text = "Ingrediente: " + "\n" + receta?.ingredientes

        Glide.with(this).load(receta?.logo).into(imglogo)


    }
}