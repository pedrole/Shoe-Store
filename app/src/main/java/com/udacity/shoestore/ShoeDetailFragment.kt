package com.udacity.shoestore

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.udacity.shoestore.databinding.FragmentShoeDetailBinding
import com.udacity.shoestore.databinding.FragmentShoeListBinding


/**
 * A simple [Fragment] subclass.
 * Use the [ShoeDetailFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class ShoeDetailFragment : Fragment() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val binding = DataBindingUtil.inflate<FragmentShoeDetailBinding>(
            inflater,
            R.layout.fragment_shoe_detail,
            container,
            false
        )
        binding.lifecycleOwner = viewLifecycleOwner


        val viewModel = ViewModelProvider(requireActivity()).get(ShoeViewModel::class.java)
        binding.viewModel = viewModel

        binding.buttonSave.setOnClickListener(View.OnClickListener {
            viewModel.onSave()
            findNavController().navigateUp()
            /*findNavController()
            .navigate(ShoeDetailFragmentDirections.actionShoeDetailFragmentToShoeListFragment())*/

        })
        binding.buttonCancel.setOnClickListener(View.OnClickListener { findNavController()
            .navigate(ShoeDetailFragmentDirections.actionShoeDetailFragmentToShoeListFragment()) })
        // Inflate the layout for this fragment
        return binding.root
    }


}