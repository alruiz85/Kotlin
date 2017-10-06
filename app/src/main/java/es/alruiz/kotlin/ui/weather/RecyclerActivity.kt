package es.alruiz.kotlin.ui.weather

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import es.alruiz.kotlin.R
import es.alruiz.kotlin.domain.commands.RequestForecastCommand
import es.alruiz.kotlin.domain.model.Forecast
import kotlinx.android.synthetic.main.activity_recycler.*
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.toast
import org.jetbrains.anko.uiThread

class RecyclerActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recycler)

        forecast_list.layoutManager = LinearLayoutManager(this)

        btn_get_weather.setOnClickListener {
            val code: String = et_zip_code.text.toString()
            getWeatherPrevision(code)
        }


    }

    fun getWeatherPrevision(zipCode: String) {
        doAsync {
            val result = RequestForecastCommand("94043").execute()
            uiThread {
                forecast_list.adapter = ForecastListAdapter(result,
                        object : ForecastListAdapter.OnItemClickListener {
                            override fun invoke(forecast: Forecast) {
                                toast(forecast.date)
                            }
                        })

            }
        }
    }
}
