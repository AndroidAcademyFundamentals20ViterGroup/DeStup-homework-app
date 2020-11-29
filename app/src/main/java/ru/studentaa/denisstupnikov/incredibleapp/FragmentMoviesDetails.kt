package ru.studentaa.denisstupnikov.incredibleapp

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment

class FragmentMoviesDetails : Fragment() {
    private var listener: ClickListener? = null
    private var backButton: TextView? = null
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_movies_details, container, false)
        backButton = view.findViewById<TextView>(R.id.back_button).apply {
            setOnClickListener { listener?.backToList() }
        }
        return view
    }
    fun setListener(b: ClickListener) {
        listener = b
    }
}