package shift.cft.weather.feature.weather.details.presentation

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_update_city.*
import shift.cft.weather.R
import shift.cft.weather.feature.weather.cities.presentation.CitiesActivity

class UpdateCityActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_update_city)

        saveButton2.setOnClickListener {
            Toast.makeText(this, "Информация изменена!", Toast.LENGTH_SHORT).show()
            startActivity(Intent(this, CitiesActivity::class.java))
        }
    }
}