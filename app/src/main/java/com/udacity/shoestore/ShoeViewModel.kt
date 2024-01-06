package com.udacity.shoestore

import androidx.databinding.InverseMethod
import androidx.databinding.adapters.Converters
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.udacity.shoestore.models.Shoe
import timber.log.Timber
import java.util.Date

class ShoeViewModel : ViewModel() {

    private val _shoes = MutableLiveData<ArrayList<Shoe>>(arrayListOf())
     val shoes: LiveData<ArrayList<Shoe>>
        get() = _shoes
    private val _shoe = MutableLiveData<Shoe>(Shoe("",0.0,"","", arrayListOf()))
     val shoe: LiveData<Shoe>
        get() = _shoe

    fun onSave(){
       //val shoe2 = Shoe(shoe.value?.name ?: "", _shoe.value.size, "","")
        val shoe2 = shoe.value?.copy()
       _shoe.value = Shoe("",0.0,"","", arrayListOf())
        _shoes.value?.add(shoe2!!)

    }


}

object DoubleConverter {
    @JvmStatic
    @InverseMethod("stringToDouble")
    fun doubleToString(value: Double): String {
        // Convert double to string
        return value.toString()
    }

    @JvmStatic
    fun stringToDouble(value: String): Double {
        // Convert string to double
        return value.toDoubleOrNull() ?: 0.0
    }
}

