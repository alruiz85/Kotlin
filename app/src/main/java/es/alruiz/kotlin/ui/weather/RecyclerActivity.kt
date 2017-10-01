package es.alruiz.kotlin.ui.weather

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import es.alruiz.kotlin.R
import es.alruiz.kotlin.domain.commands.RequestForecastCommand
import kotlinx.android.synthetic.main.activity_recycler.*
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.uiThread

class RecyclerActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recycler)

        forecast_list.layoutManager = LinearLayoutManager(this)

        doAsync() {
            val result = RequestForecastCommand("26007").execute()
            uiThread {
                forecast_list.adapter = ForecastListAdapter(result)
            }
        }

    }
}
