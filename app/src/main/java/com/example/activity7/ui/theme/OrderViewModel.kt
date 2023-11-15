package com.example.activity7.ui.theme

import android.icu.text.NumberFormat
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import com.example.activity7.Data2.ContactUiState
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import androidx.compose.runtime.*


private const val HARGA_PER_CUP = 3000

class OrderViewModel : ViewModel() {
    private val _stateUI = MutableStateFlow(ContactUiState())
    val stateUi: StateFlow<ContactUiState> = _stateUI.asStateFlow()

    fun setContact(List: MutableList<String>)
    {
        _stateUI.update {
                stateSaatini->
            val list
            stateSaatini.copy(
                nama = list[0],
                alamat = list[1],
                tlpn = list[2]
            )
        }
    }
    private val _stateUI = MutableStateFlow(OrderUIState())
    val statedUI: StateFlow<OrderUIState> = _stateUI.asStateFlow()

    fun setJumlah(jmlEsJumbo:Int){
        _stateUI.update{ stateSaatIni ->
            stateSaatIni.copy(
                jumlah = jmlEsJumbo,
                harga = hitungHarga(jumlah = jmlEsJumbo)
            )
        }

        fun setRasa(rasaPilihan:String){
        _stateUI.update{ stateSaatIni ->
            stateSaatIni.copy(rasa = rasaPilihan)
            }
        }
        fun resetOrder(){
            _stateUI.value = OrderUIState()
        }

        private fun hitungHarga(
            jumlah:Int=_stateUI.value.jumlah,
        ):String{
            val kalkulasiHarga = jumlah* HARGA_PER_CUP
            return NumberFormat.getNumberInstance().format(kalkulasiHarga)
        }
}



}
