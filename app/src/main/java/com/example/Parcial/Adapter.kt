package com.example.Parcial

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.clase5equipodefutbol.R

class Adapter (val context: Context) : ListAdapter<Receta, Adapter.ViewHolder>(DiffCallBack) {

    lateinit var onItemClickListener: (Receta) -> Unit

    inner class ViewHolder(private val view: View) : RecyclerView.ViewHolder(view) {
        private val name : TextView = view.findViewById(R.id.textViewName)
        private val level : TextView = view.findViewById(R.id.textViewDificultad)
        private val origen : TextView = view.findViewById(R.id.textViewPais)
        private val Iflag: ImageView = view.findViewById(R.id.imageFlag)
        private val Ifood: ImageView = view.findViewById(R.id.imageFood)

        fun bind (receta: Receta) {
            name.text = "Nombre: " + receta.nombre
            level.text = "Dificultad: " + receta.dificultad.toString()
            origen.text = "Origen: " + receta.origen.toString()


            val image = when (receta.origen){
                Pais.Argentina -> R.drawable.icons8argentina48
                Pais.Alemania -> R.drawable.icons8germany48
                Pais.China -> R.drawable.icons8china48
                Pais.Mexico -> R.drawable.icons8mexico48
                Pais.Venezuela -> R.drawable.icons8venezuela48
                Pais.España -> R.drawable.icons8spain48
                else -> {R.drawable.icons8japan48}
            }
            Iflag.setImageResource(image)

            Glide.with(context).load(receta.logo).into(Ifood)

            view.setOnClickListener {
                onItemClickListener(receta)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Adapter.ViewHolder {
        val view: View = LayoutInflater
            .from(parent.context)
            .inflate(R.layout.itemlist, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: Adapter.ViewHolder, position: Int) {
        val equipo = getItem(position)
        holder.bind(equipo)
    }

    companion object DiffCallBack : DiffUtil.ItemCallback<Receta>() {
        override fun areItemsTheSame(oldItem: Receta, newItem: Receta): Boolean {
            return  oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Receta, newItem: Receta): Boolean {
            return oldItem == newItem
        }
    }
}