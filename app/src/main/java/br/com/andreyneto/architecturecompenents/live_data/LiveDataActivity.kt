package br.com.andreyneto.architecturecompenents.live_data

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import br.com.andreyneto.architecturecompenents.R
import kotlinx.android.synthetic.main.activity_live_data.*

class LiveDataActivity : AppCompatActivity() {

    private val viewModel by lazy {
        ViewModelProviders.of(this).get(LiveDataTimerViewModel::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_live_data)

        subscribe()
    }

    fun subscribe() {
        val elapsedTimeObserver = Observer<Long> {
            tvTimer.text = "$it segundos se passaram."
        }

        viewModel.elapsedTime.observe(this, elapsedTimeObserver)
    }
}
