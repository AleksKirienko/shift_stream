package shift.cft.weather.feature.weather.details.presentation

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_city_detail.*
import kotlinx.android.synthetic.main.activity_main.*
import shift.cft.common.Info
import shift.cft.weather.R
import shift.cft.weather.feature.weather.cities.presentation.CitiesActivity

@Suppress("DEPRECATION")
class CityDetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_city_detail)

        val parameters = intent.getSerializableExtra("City") as Info?

        titleDetail.text = parameters?.title
        descriptionDetail.text = parameters?.description
        temperatureDetail.text = parameters?.temperature

        deleteButton.setOnClickListener {
            Toast.makeText(this, "Информация о городе удалена!", Toast.LENGTH_SHORT).show()
            startActivity(Intent(this, CitiesActivity::class.java))
        }
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