package shift.cft.weather

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_weather.*

class WeatherActivity : AppCompatActivity() {

    private val citiesList = listOf(

        Info("Новосибирск", "Преимущ. солнечно 23°C"),
        Info("Москва", "Местами грозы 17°C"),
        Info("Санкт-Петербург", "Облачно 18°C"),
        Info("Барнаул", "Переменная облачность, 26°C"),
        Info("Бердск", "Переменная облачность 22°C")
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_weather)

        val adapter = WeatherListAdapter()
        val layoutManager =
            LinearLayoutManager(applicationContext, LinearLayoutManager.VERTICAL, false)

        recyclerView.adapter = adapter
        recyclerView.layoutManager = layoutManager

        adapter.setWeatherList(citiesList)

        adapter.setListener(object : WeatherListAdapter.WeatherListener {
            override fun onClickNote(model: Info) {
                val intent = Intent(this@WeatherActivity, CityDetailActivity::class.java)
                intent.putStringArrayListExtra("City", arrayListOf(model.title, model.description))
                startActivity(intent)
            }
        })

    }

}
