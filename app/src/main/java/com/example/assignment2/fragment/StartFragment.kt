package com.example.assignment2.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.assignment2.R
import com.example.assignment2.databinding.FragmentStartBinding

/**
 * Created by Monil Panchal, B00838558 on 2020-03-27.
 * Organization: Dalhousie university
 * Email: monil.panchal@dal.ca
 */

/**
 * A [Fragment] subclass.
 * This class manages and binds all UI components related to [fragment_start.xml]
 */
class StartFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return FragmentStartBinding.inflate(inflater, container, false).apply {
            startButton.setOnClickListener {
                findNavController().navigate(R.id.startJudging)
            }
        }.root
    }

}