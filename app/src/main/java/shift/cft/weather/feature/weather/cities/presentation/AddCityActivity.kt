package shift.cft.weather.feature.weather.cities.presentation

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_add_city.*
import shift.cft.weather.R
import shift.cft.weather.feature.main.presentation.MainActivity

class AddCityActivity : AppCompatActivity() {

    private var createTitle: String? = null
    private var createDescription: String? = null
    private var createTemperature: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_city)

        saveButton.setOnClickListener {

            createTitle = addTitle.text.toString()
            createDescription = addDescription.text.toString()
            createTemperature = addTemperature.text.toString()

            if (createTitle == "" || createDescription == "" || createTemperature == "") {
                Toast.makeText(this, "Вы заполнили не все поля!", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(
                    this,
                    "$createTitle $createDescription $createTemperature",
                    Toast.LENGTH_SHORT
                ).show()
                Toast.makeText(this, "Город добавлен!", Toast.LENGTH_SHORT).show()
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
