package shift.cft.weather.presentation.ui.weather.list

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_weather.*
import shift.cft.weather.R
import shift.cft.weather.model.entity.Info
import shift.cft.weather.presentation.ui.weather.CityDetailActivity

class WeatherActivity : AppCompatActivity() {

    private val citiesList = listOf(

        Info("Барнаул", "Переменная облачность, +26°C"),
        Info("Бердск", "Переменная облачность +22°C"),
        Info("Воронеж", "Малооблачно +23°C"),
        Info("Екатеринбург", "Пасмурно +22°C"),
        Info("Казань", "Малооблачно +22°C"),
        Info("Москва", "Местами грозы +17°C"),
        Info("Новосибирск", "Преимущ. солнечно +23°C"),
        Info("Омск", "Малооблачно +22°C"),
        Info("Самара", "Облачно +22°C"),
        Info("Санкт-Петербург", "Облачно +18°C"),
        Info("Тольятти", "Малооблачно +25°C"),
        Info("Тюмень", "Облачно +23°C"),
        Info("Уфа", "Пасмурно, небольшой дождь +23°C"),
        Info("Челябинск", "Облачно +25°C")
    )

    val adapter = WeatherListAdapter { model ->
        val intent = Intent(this@WeatherActivity, CityDetailActivity::class.java)
        intent.putExtra("City", model)
        startActivity(intent)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_weather)

        val layoutManager =
            LinearLayoutManager(applicationContext, LinearLayoutManager.VERTICAL, false)

        recyclerView.adapter = adapter
        recyclerView.layoutManager = layoutManager

        adapter.setWeatherList(citiesList)
    }
}
