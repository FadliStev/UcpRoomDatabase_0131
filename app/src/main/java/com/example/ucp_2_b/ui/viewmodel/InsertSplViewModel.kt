package com.example.ucp_2_b.ui.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.ucp_2_b.data.entity.Suplier
import com.example.ucp_2_b.repository.RepositorySuplier
import kotlinx.coroutines.launch


class InsertSplViewModel(private val repositorySuplier: RepositorySuplier): ViewModel(){

    var uiStateSpl by mutableStateOf(SplUIState())
    fun updateState(suplierEvent: SuplierEvent){
        uiStateSpl = uiStateSpl.copy(
            suplierEvent = suplierEvent
        )
    }

    private fun validateFields(): Boolean{
        val event = uiStateSpl.suplierEvent
        val errorState = SplFormErrorState(
            nama = if (event.nama.isNotEmpty()) null else "Nama tidak boleh kosong",
            kontak = if (event.kontak.isNotEmpty()) null else "Kontak tidak boleh kosong",
            alamat = if (event.alamat.isNotEmpty()) null else "Alamat tidak boleh kosong",

        )

        uiStateSpl = uiStateSpl.copy(isEntryValid = errorState)
        return errorState.isValid()
    }

    fun saveData(){
        val currentEvent = uiStateSpl.suplierEvent

        if (validateFields()){
            viewModelScope.launch {
                try {
                    repositorySuplier.insertSpl(currentEvent.toSuplierEntity())
                    uiStateSpl = uiStateSpl.copy(
                        snackbarMessage = "Data Berhasil Ditambahkan",
                        suplierEvent = SuplierEvent(),
                        isEntryValid = SplFormErrorState()
                    )
                } catch (e: Exception){
                    uiStateSpl = uiStateSpl.copy(
                        snackbarMessage = "Data Gagal Disimpan"
                    )
                }
            }
        } else{
            uiStateSpl = uiStateSpl.copy(
                snackbarMessage = "Inputan Salah. Periksa kembali data anda."
            )
        }
    }
    fun resetSnackBarMessage(){
        uiStateSpl = uiStateSpl.copy(snackbarMessage = null)
    }
}

data class SplUIState(
    val suplierEvent: SuplierEvent = SuplierEvent(),
    val isEntryValid: SplFormErrorState = SplFormErrorState(),
    val snackbarMessage: String? = null
)

data class SplFormErrorState(
    val id: Int? = null,
    val nama: String? = null,
    val kontak: String? = null,
    val alamat: String? = null
){
    fun isValid(): Boolean{
        return id == null &&
                nama == null &&
                kontak == null &&
                alamat == null
    }
}

fun SuplierEvent.toSuplierEntity(): Suplier = Suplier(
    id = id,
    nama = nama,
    kontak = kontak,
    alamat = alamat
)

data class SuplierEvent(
    val id: Int = 0,
    val nama: String = "",
    val kontak: String = "",
    val alamat: String = ""
)