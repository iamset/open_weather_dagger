package com.example.weather.weather

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.navArgs
import com.bumptech.glide.Glide
import com.example.weather.BaseApplication
import com.example.weather.R
import com.example.weather.utils.Constants
import javax.inject.Inject


class WeatherFragment: Fragment(R.layout.fragment_weather) {
    private val args: WeatherFragmentArgs by navArgs()
    private lateinit var cityName:TextView
    private lateinit var weatherDescription : TextView
    private lateinit var weatherMain: TextView
    private lateinit var imageView: ImageView
    private lateinit var tempMin: TextView
    private lateinit var tempMax : TextView

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory
    lateinit var viewModel: WeatherViewModel


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        cityName = view.findViewById(R.id.txt_city_name_2)
        cityName.text = args.cityName
        weatherDescription = view.findViewById(R.id.txt_whether_desc)
        weatherMain = view.findViewById(R.id.txt_main)
        imageView = view.findViewById(R.id.weather_img)
        tempMin = view.findViewById(R.id.weather_low_value)
        tempMax = view.findViewById(R.id.weather_high_value)

        viewModel = ViewModelProvider(this, viewModelFactory)[WeatherViewModel::class.java]
        viewModel.getWeather(cityName.text.toString())
        viewModel.result.observe(viewLifecycleOwner, Observer {
            weatherDescription.text = it.weather.get(0).description
            weatherMain.text = it.weather.get(0).main
            tempMin.text = it.main.temp_min.toInt().toString() + " F"
            tempMax.text = it.main.temp_max.toInt().toString() + " F"
            Glide.with(this)
                .load("${Constants.WEATHER_ICONS_URL}${it.weather.get(0).icon}.png")
                .into(imageView);
            Log.d("ViewModel", it.toString())
        })

    }

    override fun onAttach(context: Context) {

        super.onAttach(context)
        (context.applicationContext as BaseApplication).appComponent.inject(this)
    }


}