package com.devundefined.pokemontestapp.presentation.pokemonlist

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.devundefined.pokemontestapp.R
import com.devundefined.pokemontestapp.domain.models.Pokemon

class PokemonVH(view: View) : RecyclerView.ViewHolder(view) {

    private val name: TextView = view.findViewById(R.id.name)

    fun setName(name: String) {
        this.name.text = name.capitalize()
    }

    fun setOnClickListener(listener: () -> Unit) {
        itemView.setOnClickListener { listener() }
    }
}

class PokemonViewBinder {

    fun bind(viewHolder: PokemonVH, pokemon: Pokemon, listener: (Pokemon) -> Unit) {
        viewHolder.setName(pokemon.name)
        viewHolder.setOnClickListener { listener(pokemon) }
    }
}

class PokemonListAdapter(private val listener: (Pokemon) -> Unit) : RecyclerView.Adapter<PokemonVH>() {

    private var pokemons: List<Pokemon> = listOf()

    private val binder = PokemonViewBinder()

    fun setData(pokemons: List<Pokemon>) {
        this.pokemons = pokemons
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PokemonVH {
        return PokemonVH(LayoutInflater.from(parent.context).inflate(R.layout.view_pokemon_item, parent, false))
    }

    override fun getItemCount(): Int {
        return pokemons.size
    }

    override fun onBindViewHolder(holder: PokemonVH, position: Int) {
        binder.bind(holder, pokemons.get(position), listener)
    }
}