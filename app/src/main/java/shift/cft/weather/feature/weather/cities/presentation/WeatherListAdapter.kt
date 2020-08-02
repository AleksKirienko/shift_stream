package shift.cft.weather.feature.weather.cities.presentation

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import shift.cft.common.Info
import shift.cft.weather.R
import java.util.*

class WeatherListAdapter(private val clickListener:(Info) -> Unit) : RecyclerView.Adapter<WeatherListAdapter.ViewHolder>() {

    private val weatherList: MutableList<Info> = LinkedList()

    fun setWeatherList(newWeather: List<Info>) {
        weatherList.clear()
        weatherList.addAll(newWeather)

        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_weather, parent, false)
        return ViewHolder(
            view,
            clickListener
        )
    }

    override fun getItemCount(): Int {
        return weatherList.count()
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(model = weatherList[position])
    }

    class ViewHolder(itemView: View, private val weatherListener: (Info) -> Unit) : RecyclerView.ViewHolder(itemView) {

        private val title: TextView = itemView.findViewById(R.id.itemTitle)

        fun bind(model: Info) {
            title.text = model.title
            itemView.setOnClickListener {

                weatherListener(model)
            }
        }
    }
}