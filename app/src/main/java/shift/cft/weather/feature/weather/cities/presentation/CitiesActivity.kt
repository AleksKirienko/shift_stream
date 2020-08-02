package shift.cft.weather.feature.weather.cities.presentation

import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_weather.*
import shift.cft.common.Info
import shift.cft.weather.R
import shift.cft.weather.feature.weather.cities.di.CityViewModelFactory
import shift.cft.weather.feature.weather.details.presentation.CityDetailActivity

class CitiesActivity : AppCompatActivity() {

    private val viewModel: WeatherListViewModel by viewModels {
        CityViewModelFactory()
    }
    private val adapter =
        WeatherListAdapter { model ->
            viewModel.citiesClicked(model)
        }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_weather)
        viewModel.cities.observe(this, Observer { citiesList ->
            setCitiesList(citiesList)
        })

        viewModel.cityClickedEvent.observe(this, Observer { weatherList ->
            showWeatherDetails(weatherList)
        })

        val layoutManager =
            LinearLayoutManager(applicationContext, LinearLayoutManager.VERTICAL, false)

        recyclerView.adapter = adapter
        recyclerView.layoutManager = layoutManager


    }

    private fun setCitiesList(citiesList: List<Info>) {
        adapter.setWeatherList(citiesList)
    }

    private fun showWeatherDetails(model: Info) {
        val intent = Intent(this@CitiesActivity, CityDetailActivity::class.java)
        intent.putExtra("City", model)
        startActivity(intent)
    }
}