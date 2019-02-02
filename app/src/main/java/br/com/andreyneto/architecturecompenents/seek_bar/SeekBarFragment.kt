package br.com.andreyneto.architecturecompenents.seek_bar

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SeekBar
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import br.com.andreyneto.architecturecompenents.R

class SeekBarFragment : Fragment() {

    private lateinit var mSeekBar: SeekBar

    private lateinit var seekBarViewModel: SeekBarViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val root =  inflater.inflate(R.layout.fragment_seek_bar, container, false)
        mSeekBar = root.findViewById(R.id.seekBar)
        activity?.let {
            seekBarViewModel = ViewModelProviders.of(it).get(SeekBarViewModel::class.java)
            subscribeSeekBar()
        }
        return root
    }

    fun subscribeSeekBar() {
        mSeekBar.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                if(fromUser) seekBarViewModel.seekBarValue.value = progress
            }
            override fun onStartTrackingTouch(seekBar: SeekBar?) {
            }
            override fun onStopTrackingTouch(seekBar: SeekBar?) {
            }
        })
        seekBarViewModel.seekBarValue.observe(this, Observer {
            Log.e("value",it.toString())
            mSeekBar.progress = it
        })
    }
}
