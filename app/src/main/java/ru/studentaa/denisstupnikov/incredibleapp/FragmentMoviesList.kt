package ru.studentaa.denisstupnikov.incredibleapp

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.cardview.widget.CardView
import androidx.fragment.app.Fragment

class FragmentMoviesList : Fragment() {
    private var listener: ClickListener? = null
    private var cwButton: CardView? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? = inflater.inflate(R.layout.fragment_movies_list, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        cwButton = view.findViewById<CardView>(R.id.cw_avg_eg).apply {
            setOnClickListener { listener?.goToDetails() }
        }
    }
    fun setListener(l: ClickListener) {
        listener = l
    }
}