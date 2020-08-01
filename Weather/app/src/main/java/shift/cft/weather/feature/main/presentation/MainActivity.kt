package shift.cft.weather.feature.main.presentation

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import shift.cft.weather.R
import shift.cft.weather.feature.weather.cities.presentation.CitiesActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button1.setOnClickListener {
            startActivity(Intent(this, CitiesActivity::class.java))
        }

        button2.setOnClickListener {
            Toast.makeText(this, "Тут пока ничего нет, но скоро будет!", Toast.LENGTH_SHORT).show()
        }
    }
}