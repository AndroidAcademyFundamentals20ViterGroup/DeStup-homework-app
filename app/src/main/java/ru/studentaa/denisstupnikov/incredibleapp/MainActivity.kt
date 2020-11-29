package ru.studentaa.denisstupnikov.incredibleapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class MainActivity : AppCompatActivity(), ClickListener {
    private val listFragment = FragmentMoviesList().apply { setListener(this@MainActivity) }
    private val detailsFragment = FragmentMoviesDetails().apply { setListener(this@MainActivity) }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportFragmentManager.beginTransaction()
            .add(R.id.main_container, listFragment)
            .commit()
    }

    override fun goToDetails() {
        supportFragmentManager.beginTransaction()
            .addToBackStack(null)
            .add(R.id.main_container, detailsFragment)
            .commit()
    }


   override fun backToList() {
        supportFragmentManager.beginTransaction()
            .replace(R.id.main_container, listFragment)
            .commit()
    }
}