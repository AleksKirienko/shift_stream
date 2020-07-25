package shift.cft.weather

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_city_detail.*

class CityDetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_city_detail)

        val parameters = intent.getStringArrayListExtra("City")

        titleDetail.text = parameters?.get(0)
        descriptionDetail.text = parameters?.get(1)
    }
}