package com.example.Parcial

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.clase5equipodefutbol.R

class MainActivity : AppCompatActivity() {

    private lateinit var rv: RecyclerView
    private lateinit var adapter: Adapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rv = findViewById(R.id.recyclerView)
        rv.layoutManager = LinearLayoutManager(this)

        adapter = Adapter(applicationContext)
        rv.adapter = adapter

        adapter.submitList(listadoRecetas())
        adapter.onItemClickListener = { receta -> goDetalle(receta) }
    }

    private fun goDetalle(receta: Receta) {
        val intent = Intent(this, Detalle::class.java)
        intent.putExtra("receta",receta)
        startActivity(intent)

    }

    private fun listadoRecetas(): MutableList<Receta>? {

        return mutableListOf(
            Receta(1, "Locro", Nivel.Experto, Pais.Argentina, "https://www.soyceliaconoextraterrestre.com/wp-content/uploads/2021/07/receta-de-locro.jpg",
                "maíz blanco partido, poroto pallares blanco, zapallo o calabaza, panceta, chorizo criollo, chorizo colorado,  pechito de cerdo, falda, cebolla"),
            Receta(2, "Arepas", Nivel.Facil, Pais.Venezuela, "https://c.pxhere.com/images/5c/41/f5b056165ca764532eb6b73a6f6a-1420549.jpg!d",
                "harina de maíz, agua, sal, aceite, Queso en lonchas"),
            Receta(3, "Chucrut", Nivel.Facil, Pais.Alemania, "https://www.entrenamiento.com/wp-content/uploads/2020/03/chucrut-beneficios.jpg?width=1200&enable=upscale",
                "Repollo, Sal gruesa"),
            Receta(4, "Chop suey", Nivel.Dificil, Pais.China, "https://images.squarespace-cdn.com/content/v1/601eeccabeed354b4e2f9f3b/1618744895269-7DZA7FFYLFQH4F7F8W3B/Veg+chop+suay.jpg?format=2500w",
                "pimiento morrón rojo, pimiento morrón verde, zucchini, cebolla, zanahoria, dientes de ajo, Ralladura de 1 limón, cdita de jengibre rallado pechugas de pollo, brotes de soja , salsa de soja, puñado de castañas de cajú tostadas, Ciboulette picado, Aceite para saltear "),
            Receta(5, "Ramen", Nivel.Dificil, Pais.Japon, "https://imag.bonviveur.com/ramen-de-cerdo.jpg",
                "Puerro (solo la parte verde),  Cebolla chica (o 1/2 grande), 4 Rodajas de jengibre fresco, 1/2 Zanahoria, 4 Dientes de ajo, 2 Huevos, 1 Costilla de cerdo (puede ser otra parte), Fideos de arroz (pueden ser otros),1 Vaso de Salsa de soja, 1 Cda. de sake (yo: vodka), 3 Cdas. de mirín (yo: vino blanco dulce), 2 Cditas. de azúcar, , 1 Cebolla de verdeo, Sal"),
            Receta(6, "Paella", Nivel.Dificil, Pais.España, "https://www.tapasmagazine.es/wp-content/uploads/2021/10/douglas-lopez-4B0cLMtJxWw-unsplash-1-1200x800.jpg",
                "1 morrón rojo, 1 morrón verde  , 2 cebollas, Arroz doble carolina 200 gr, 1 cda. pimentón dulce, 2 ajos, Azafrán o condimento para arroz, 500 grs. de calamar, 200 grs. de mejillones, 400 grs. de langostinos, 200 grs. de almejas, 200 grs. de berberechos, 700 ml. de caldo de verduras"),
            Receta(7, "Tacos", Nivel.Medio, Pais.Mexico, "https://www.oregoncc.org/sites/default/files/styles/content_image/public/2015/07/06/Tres%20Tacos_0.jpg?itok=BJOzP_jn",
                "250 grs de carne: puede ser peceto, 1 cebolla morada mediana, 2 dientes de ajo, 1 chile fresco (opcional), 1/2 pimiento o morrón rojo, 1/2 pimiento o morrón verde, Jugo de 1 lima o limón, 1 tomate mediano, Orégano, Chile seco (a gusto), Sal y pimienta, Cilantro, Aceite neutro ")
        )
    }
}
