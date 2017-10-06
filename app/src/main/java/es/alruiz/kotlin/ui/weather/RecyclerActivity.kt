package es.alruiz.kotlin.ui.weather

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import es.alruiz.kotlin.R
import es.alruiz.kotlin.domain.commands.RequestForecastCommand
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
            val result = RequestForecastCommand(zipCode).execute()
            uiThread {
                val adapter = ForecastListAdapter(result) { toast(result.city) }
                forecast_list.adapter = adapter
            }
        }
    }
}
