package com.devundefined.pokemontestapp.presentation.pokemonlist

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.LinearLayout
import android.widget.ProgressBar
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.devundefined.pokemontestapp.PokemonTestApp
import com.devundefined.pokemontestapp.R
import com.devundefined.pokemontestapp.domain.models.Pokemon
import com.devundefined.pokemontestapp.presentation.pokemoninfo.PokemonInfoActivity

class PokemonListActivity : AppCompatActivity(), PokemonListView {

    private val presenter: PokemonListPresenter = PokemonTestApp.INSTANCE.appComponent.listPresenter()

    private val recyclerView: RecyclerView by lazy { findViewById<RecyclerView>(R.id.recycler_view) }
    private val progress: ProgressBar by lazy { findViewById<ProgressBar>(R.id.progress) }
    private val adapter: PokemonListAdapter = PokemonListAdapter {pokemon ->
        startActivity(Intent(this, PokemonInfoActivity::class.java).apply { putExtra(PokemonInfoActivity.EXTRA_KEY_POKEMON, pokemon) })
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pokemon_list)
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(this, RecyclerView.VERTICAL, false)
    }

    override fun onStart() {
        super.onStart()
        presenter.attachView(this)
    }

    override fun onStop() {
        presenter.detachView()
        super.onStop()
    }

    override fun show(pokemons: List<Pokemon>) {
        adapter.setData(pokemons)
        progress.visibility = View.GONE
        recyclerView.visibility = View.VISIBLE
    }

    override fun showLoading() {
        progress.visibility = View.VISIBLE
        recyclerView.visibility = View.GONE
    }
}
