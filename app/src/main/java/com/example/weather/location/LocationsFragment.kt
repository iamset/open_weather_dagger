package com.example.weather.location

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.EditText
import androidx.compose.ui.text.capitalize
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.weather.BaseApplication
import com.example.weather.R
import com.example.weather.utils.OnTextClickListener


import javax.inject.Inject

class LocationsFragment :Fragment(R.layout.fragment_locations), OnTextClickListener{
    @Inject lateinit var viewModelFactory: ViewModelProvider.Factory
    lateinit var viewModel: LocationsViewModel
    lateinit var addButton: Button
    lateinit var cityEditText: EditText
    lateinit var recyclerViewCities:RecyclerView
    lateinit var adapter: LocationsAdapter


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        addButton = view.findViewById(R.id.btn)
        cityEditText = view.findViewById(R.id.edt_txt_city)
        recyclerViewCities = view.findViewById(R.id.rv_cities)


        viewModel = ViewModelProvider(this, viewModelFactory)[LocationsViewModel::class.java]
        viewModel.getLocations()
        viewModel.data.observe(viewLifecycleOwner, Observer {

            adapter = LocationsAdapter(it, this)
            recyclerViewCities.adapter = adapter
            recyclerViewCities.layoutManager = LinearLayoutManager(context)
        })

        addButton.setOnClickListener{
            val cityName = cityEditText.text.toString().trim().capitalize()
            if(cityName.isNotEmpty()){
                addCity(cityName)
                clearKeyBoardFromScreen()
            }

        }

    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        (context.applicationContext as BaseApplication).appComponent.inject(this)
    }

    fun clearKeyBoardFromScreen(){
        // forces the keyboard to disappear.
        val mgr: InputMethodManager =
            requireActivity().getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        mgr.hideSoftInputFromWindow(cityEditText.windowToken, 0)
    }
    fun addCity(cityName: String){
        viewModel.insertLocation(Location(cityName))
        cityEditText.text.clear()
        cityEditText.clearFocus()
    }

    override fun onTextClick(location: Location) {
        val action =
            LocationsFragmentDirections.actionLocationsFragmentToWeatherFragment().setCityName(location.name)
        cityEditText.findNavController().navigate(action)
    }
}