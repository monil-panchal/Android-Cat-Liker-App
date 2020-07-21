package com.example.assignment2.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.bumptech.glide.Glide
import com.example.assignment2.R
import com.example.assignment2.databinding.FragmentFinalBinding


/**
 * Created by Monil Panchal, B00838558 on 2020-03-27.
 * Organization: Dalhousie university
 * Email: monil.panchal@dal.ca
 */

/**
 * A [Fragment] subclass.
 * This class manages and binds all UI components related to [fragment_final.xml]
 * It uses [SharedViewModel] ViewModel to communicate to the related fragment [BillSummaryFragment]
 */

class FinalFragment : Fragment() {

    private val IMG_URL =
        "https://images.unsplash.com/photo-1531425300797-d5dc8b021c84?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=800&q=60"
    private lateinit var binding: FragmentFinalBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentFinalBinding.inflate(inflater, container, false).apply {
            startOverButton.setOnClickListener {
                findNavController().navigate(R.id.action_finalFragment_to_startFragment2)
            }
        }
        Glide.with(this).load(IMG_URL).into(binding.finalImage)
        return binding.root


    }
}