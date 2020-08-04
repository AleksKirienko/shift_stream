package shift.cft.weather.feature.weather.cities.presentation

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_add_city.*
import shift.cft.weather.R

class AddCityActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_city)

        saveButton.setOnClickListener() {
            Toast.makeText(this, "Город добавлен!", Toast.LENGTH_SHORT).show()
            startActivity(Intent(this, CitiesActivity::class.java))
        }
    }
}
