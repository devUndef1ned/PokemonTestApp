package com.devundefined.pokemontestapp.presentation.pokemoninfo

import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import com.bumptech.glide.Glide
import com.devundefined.pokemontestapp.PokemonTestApp
import com.devundefined.pokemontestapp.R
import com.devundefined.pokemontestapp.domain.models.Pokemon

class PokemonInfoActivity : AppCompatActivity(), PokemonInfoView {

    companion object {
        const val EXTRA_KEY_POKEMON = "extra_key_pokemon"
    }

    private val progress: View by lazy { findViewById<View>(R.id.progress) }
    private val mainContent: View by lazy { findViewById<View>(R.id.main_content) }
    private val toolbar: Toolbar by lazy { findViewById<Toolbar>(R.id.toolbar)}
    private val sprite: ImageView by lazy { findViewById<ImageView>(R.id.sprite) }
    private val name: TextView by lazy { findViewById<TextView>(R.id.name) }
    private val description: TextView by lazy { findViewById<TextView>(R.id.description) }

    private var pokemonId: Int = -1

    private val pokemonInfoPresenter = PokemonTestApp.INSTANCE.appComponent.infoPresenter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pokemon_info)
        toolbar.setNavigationOnClickListener { onBackPressed() }
        (intent.getSerializableExtra(EXTRA_KEY_POKEMON) as Pokemon).let { pokemon ->
            toolbar.title = pokemon.name.capitalize()
            pokemonId = pokemon.id
        }

    }

    override fun onStart() {
        super.onStart()
        pokemonInfoPresenter.attachView(this)
        pokemonInfoPresenter.loadPokemon(pokemonId)
    }

    override fun onStop() {
        pokemonInfoPresenter.detachView()
        super.onStop()
    }

    override fun showLoading() {
        progress.visibility = View.VISIBLE
        mainContent.visibility = View.GONE
    }

    override fun showPokemon(pokemon: Pokemon) {
        progress.visibility = View.GONE
        mainContent.visibility = View.VISIBLE

        name.text = pokemon.name.capitalize()
        pokemon.photoUrl?.let { url ->
            Glide.with(this)
                .load(url)
                .into(sprite)
        }

        val stringBuilder = StringBuilder().append("Types: ")

        for (i in 0 until pokemon.types.size) {
            if (i != pokemon.types.size - 1) {
                stringBuilder.append("${pokemon.types[i]}, ")
            } else {
                stringBuilder.append("${pokemon.types[i]}\n")
            }
        }

        pokemon.weight?.let { weight -> stringBuilder.append("Weight: $weight\n") }
        pokemon.height?.let { height -> stringBuilder.append("Height: $height") }

        description.text = stringBuilder.toString()
    }
}