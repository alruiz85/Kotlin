package es.alruiz.kotlin.ui.weather

import android.support.v7.widget.RecyclerView
import android.view.ViewGroup
import android.widget.TextView
import es.alruiz.kotlin.domain.model.ForecastList

/**
 * Adapter.
 */
class ForecastListAdapter(val weekForecast: ForecastList) :
        RecyclerView.Adapter<ForecastListAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int):
            ViewHolder? {
        return ViewHolder(TextView(parent.getContext()))
    }

    override fun onBindViewHolder(holder: ViewHolder,
                                  position: Int) {
        with(weekForecast.dailyForecast[position]) {
            holder.textView.text = "$date - $description - $high/$low"
        }
    }

    override fun getItemCount(): Int = weekForecast.dailyForecast.size

    class ViewHolder(val textView: TextView) : RecyclerView.ViewHolder(textView)
}