package br.com.andreyneto.architecturecompenents.seek_bar

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class SeekBarViewModel : ViewModel() {
    var seekBarValue = MutableLiveData<Int>()
}