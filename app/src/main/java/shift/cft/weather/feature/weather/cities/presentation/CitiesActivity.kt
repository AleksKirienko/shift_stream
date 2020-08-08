package shift.cft.weather.feature.weather.cities.presentation

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_weather.*
import shift.cft.common.Info
import shift.cft.weather.R
import shift.cft.weather.feature.main.presentation.MainActivity
import shift.cft.weather.feature.weather.add.presentation.AddCityActivity
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

        addButton.setOnClickListener() {
            startActivity(Intent(this, AddCityActivity::class.java))
        }
    }

    private fun setCitiesList(citiesList: List<Info>) {
        adapter.setWeatherList(citiesList)
    }

    private fun showWeatherDetails(model: Info) {
        val intent = Intent(this@CitiesActivity, CityDetailActivity::class.java)
        intent.putExtra("City", model)
        startActivity(intent)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater = menuInflater
        inflater.inflate(R.menu.menu_main, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.action_home -> {
                startActivity(Intent(this, MainActivity::class.java))
                return true
            }
        }
        return super.onOptionsItemSelected(item)
    }
}
