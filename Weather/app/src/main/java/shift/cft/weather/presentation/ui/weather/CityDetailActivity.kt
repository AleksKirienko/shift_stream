package shift.cft.weather.presentation.ui.weather

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_city_detail.*
import shift.cft.weather.R
import shift.cft.weather.model.entity.Info

class CityDetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_city_detail)

        val parameters = intent.getSerializableExtra("City") as Info?

        titleDetail.text = parameters?.title
        descriptionDetail.text = parameters?.description
    }
}