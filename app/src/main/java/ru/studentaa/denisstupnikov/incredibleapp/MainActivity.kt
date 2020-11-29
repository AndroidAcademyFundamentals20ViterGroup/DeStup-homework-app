package ru.studentaa.denisstupnikov.incredibleapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity(), ClickListener {
    private var listFragment : FragmentMoviesList? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        if (savedInstanceState == null) {
            listFragment = FragmentMoviesList()
            listFragment?.apply {
                supportFragmentManager.beginTransaction()
                    .add(R.id.main_container, this, SOME_FRAGMENT_TAG)
                    .commit()
            }
        } else {
            listFragment = supportFragmentManager.findFragmentByTag(SOME_FRAGMENT_TAG) as? FragmentMoviesList
        }
    }

    override fun goToDetails() {
        supportFragmentManager.beginTransaction()
            .addToBackStack(null)
            .add(R.id.main_container, FragmentMoviesDetails())
            .commit()
    }

    override fun backToList() {
        supportFragmentManager.beginTransaction()
            .addToBackStack(null)
            .replace(R.id.main_container, FragmentMoviesList())
            .commit()
    }
    companion object {
        const val SOME_FRAGMENT_TAG = "SomeFragment"
    }
}
