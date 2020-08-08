package shift.cft.weather.feature.weather.add.presentation

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.activity.viewModels
import androidx.core.view.isVisible
import androidx.lifecycle.Observer
import kotlinx.android.synthetic.main.activity_add_city.*
import shift.cft.weather.R
import shift.cft.weather.feature.main.presentation.MainActivity
import shift.cft.weather.feature.weather.add.di.AddCityViewModelFactory
import shift.cft.weather.feature.weather.cities.presentation.CitiesActivity

class AddCityActivity : AppCompatActivity() {

    private var createTitle: String? = null
    private var createDescription: String? = null
    private var createTemperature: String? = null
    private val viewModel: AddCityViewModel by viewModels {
        AddCityViewModelFactory()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_city)

        saveButton.setOnClickListener {

            createTitle = addTitle.text?.toString()
            createDescription = addDescription.text?.toString()
            createTemperature = addTemperature.text?.toString()

            viewModel.addCity(createTitle, createDescription, createTemperature)

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

        viewModel.isLoading.observe(this, Observer { isLoading ->
            addCityContainer.isVisible = !isLoading
            progressBar.isVisible = isLoading
        })
        viewModel.emptyTitleEvent.observe(this, Observer {
            Toast.makeText(this, "Город не указан", Toast.LENGTH_SHORT).show()
        })
        viewModel.emptyDescriptionEvent.observe(this, Observer {
            Toast.makeText(this, "Отсутствует описание", Toast.LENGTH_SHORT).show()
        })
        viewModel.emptyTemperatureEvent.observe(this, Observer {
            Toast.makeText(this, "Температура не указана", Toast.LENGTH_SHORT).show()
        })
        viewModel.addWeatherErrorEvent.observe(this, Observer {
            Toast.makeText(this, "Ошибка, попробуй ещё раз!", Toast.LENGTH_SHORT).show()
        })
        viewModel.addWeatherSuccessEvent.observe(this, Observer {
            Toast.makeText(this, "Город добавлен!", Toast.LENGTH_SHORT).show()
        })
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
