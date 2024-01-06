package com.udacity.shoestore

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.NavigationUI
import com.udacity.shoestore.databinding.FragmentShoeListBinding



/**
 * A simple [Fragment] subclass.
 * Use the [ShoeListFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class ShoeListFragment : Fragment() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val binding = DataBindingUtil.inflate<FragmentShoeListBinding>(
            inflater,
            R.layout.fragment_shoe_list,
            container,
            false
        )
        //val viewModel = ViewModelProvider(this).get(ShoeViewModel::class.java)
        val viewModel = ViewModelProvider(requireActivity()).get(ShoeViewModel::class.java)
        val shoes = viewModel.shoes.value




        for (shoe in shoes!!) {
            val shoeView = TextView(context)
            shoeView.text = "${shoe.name} ${shoe.company} ${shoe.size} ${shoe.description}"

            binding.layoutShoes.addView(shoeView)
        }
        binding.invalidateAll()






        setHasOptionsMenu(true)
        binding.buttonNewShoe.setOnClickListener {
            findNavController().navigate(
                ShoeListFragmentDirections.actionShoeListFragmentToShoeDetailFragment()
            )
        }
        // Inflate the layout for this fragment
        return binding.root
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.menu, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if(item.itemId == R.id.logout){
            findNavController().navigate(ShoeListFragmentDirections.actionShoeListFragmentToLoginFragment())
        }

        return NavigationUI.onNavDestinationSelected(item, requireView().findNavController()) || super.onOptionsItemSelected(item)
    }


}