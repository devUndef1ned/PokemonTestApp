package com.devundefined.pokemontestapp.presentation.pokemonlist

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.devundefined.pokemontestapp.PokemonTestApp
import com.devundefined.pokemontestapp.R
import com.devundefined.pokemontestapp.domain.models.Pokemon

class PokemonListActivity : AppCompatActivity(), PokemonListView {

    private val presenter: PokemonListPresenter = PokemonTestApp.INSTANCE.appComponent.listPresenter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
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
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun showLoading() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}
