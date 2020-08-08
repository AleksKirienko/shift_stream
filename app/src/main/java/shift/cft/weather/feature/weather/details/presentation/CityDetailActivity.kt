package shift.cft.weather.feature.weather.details.presentation

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_city_detail.*
import shift.cft.common.Info
import shift.cft.weather.R
import shift.cft.weather.feature.main.presentation.MainActivity
import shift.cft.weather.feature.weather.cities.presentation.CitiesActivity
import shift.cft.weather.feature.weather.update.UpdateCityActivity

@Suppress("DEPRECATION")
class CityDetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_city_detail)

        val parameters = intent.getSerializableExtra("City") as Info?

        titleDetail.text = parameters?.title
        descriptionDetail.text = parameters?.description
        temperatureDetail.text = parameters?.temperature

        updateButton.setOnClickListener {
            startActivity(Intent(this, UpdateCityActivity::class.java))
        }

        deleteButton.setOnClickListener {
            Toast.makeText(this, "Информация о городе удалена!", Toast.LENGTH_SHORT).show()
            startActivity(Intent(this, CitiesActivity::class.java))
        }
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
            R.id.action_cities -> {
                startActivity(Intent(this, CitiesActivity::class.java))
                return true
            }
        }
        return super.onOptionsItemSelected(item)
    }

    fun iconWeather(model: Info) {
        if (model.description == "Солнечно") {

        } else if (model.description == "Переменная облачность") {
            weather_icon.setImageDrawable(resources.getDrawable(R.drawable.partly_cloudy))
        } else if (model.description == "Малооблачно" || model.description == "Облачно" || model.description == "Пасмурно") {
            weather_icon.setImageDrawable(resources.getDrawable(R.drawable.cloudy))
        } else if (model.description == "Местами грозы") {
            weather_icon.setImageDrawable(resources.getDrawable(R.drawable.storm))
        } else if (model.description == "Дождь") {
            weather_icon.setImageDrawable(resources.getDrawable(R.drawable.rain))
        } else if (model.description == "Снег") {
            weather_icon.setImageDrawable(resources.getDrawable(R.drawable.snow))
        }
    }
}