package com.example.assignment2.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.fragment.findNavController
import com.example.assignment2.R
import com.example.assignment2.databinding.FragmentListBinding
import com.example.assignment2.view.CatListView
import kotlinx.android.synthetic.main.fragment_list.*

/**
 * Created by Monil Panchal, B00838558 on 2020-03-27.
 * Organization: Dalhousie university
 * Email: monil.panchal@dal.ca
 */

/**
 * A [Fragment] subclass.
 * This class manages and binds all UI components related to [fragment_list.xml]
 * It uses [CatListView] ViewModel to listen to the UI changes and react accordingly.
 */
class ListFragment : Fragment() {

    private lateinit var binding: FragmentListBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentListBinding.inflate(inflater, container, false)

        /**
         * [CatListView] instance observes the value changes in the ([MutableMap] )
         * and sets the UI components with those values.
         */
        binding.listViewModel =
            ViewModelProviders.of(this).get(CatListView::class.java).also { view ->
                view.name.observe(this, Observer { name -> cat_name.text = name })
                view.likeCount.observe(
                    this,
                    Observer { cuteCounter -> like_score.text = cuteCounter.toString() })
                view.dislikeCount.observe(
                    this,
                    Observer { notCuteCounter -> dislike_score.text = notCuteCounter.toString() })
                view.isListCompleted.observe(this, Observer { isComplete ->
                    if (isComplete) {
                        findNavController().navigate(R.id.finalFragment)
                    }
                })
            }
        binding.lifecycleOwner = this
        return binding.root
    }
}