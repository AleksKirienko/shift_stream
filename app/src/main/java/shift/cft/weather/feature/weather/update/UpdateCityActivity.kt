package shift.cft.weather.feature.weather.update

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_update_city.*
import shift.cft.weather.R
import shift.cft.weather.feature.main.presentation.MainActivity
import shift.cft.weather.feature.weather.cities.presentation.CitiesActivity

class UpdateCityActivity : AppCompatActivity() {

    private var updatetitle: String? = null
    private var updatedescription: String? = null
    private var updatetemperature: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_update_city)

        saveButton2.setOnClickListener {

            updatetitle = updateTitle.text.toString()
            updatedescription = updateTitle.text.toString()
            updatetemperature = updateTemperature.text.toString()

            if (updatetitle == "" || updatedescription == "" || updatetemperature == "") {
                Toast.makeText(this, "Вы заполнили не все поля!", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this, "Информация изменена!", Toast.LENGTH_SHORT).show()
                startActivity(Intent(this, CitiesActivity::class.java))
            }
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
}