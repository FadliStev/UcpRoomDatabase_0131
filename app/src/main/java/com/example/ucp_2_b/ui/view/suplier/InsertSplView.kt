package com.example.ucp_2_b.ui.view.suplier

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.ucp_2_b.ui.customwidget.TopAppBar
import com.example.ucp_2_b.ui.viewmodel.InsertSplViewModel
import com.example.ucp_2_b.ui.viewmodel.PenyediaViewModel
import com.example.ucp_2_b.ui.viewmodel.SplFormErrorState
import com.example.ucp_2_b.ui.viewmodel.SplUIState
import com.example.ucp_2_b.ui.viewmodel.SuplierEvent
import kotlinx.coroutines.launch


@Composable
fun InsertSplView(
    onBack: () -> Unit,
    onNavigate: () -> Unit,
    modifier: Modifier = Modifier,
    viewModel: InsertSplViewModel = viewModel(factory = PenyediaViewModel.Factory)
){
    val uiStateSpl = viewModel.uiStateSpl
    val snackbarHostState = remember { SnackbarHostState() }
    val corroutineScope = rememberCoroutineScope()

    LaunchedEffect(uiStateSpl.snackbarMessage) {
        uiStateSpl.snackbarMessage?.let { message ->
            corroutineScope.launch {
                snackbarHostState.showSnackbar(message)
                viewModel.resetSnackBarMessage()
            }
        }

    }
    Scaffold(
        modifier = modifier,
        snackbarHost = { SnackbarHost(hostState = snackbarHostState) }
    ) {
            padding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
                .padding(16.dp)
        ) {
            TopAppBar(
                onBack = onBack,
                showBackButton = true,
                judul = "Tambah Suplier"
            )
            InsertBodySpl(
                uiStateSpl = uiStateSpl,
                onValueChange = {updatedEvent ->
                    viewModel.updateState(updatedEvent)

                },
                onClick = {
                    viewModel.saveData()
                    onNavigate()
                }
            )
        }

    }
}


@Composable
fun InsertBodySpl(
    modifier: Modifier = Modifier,
    onValueChange: (SuplierEvent) -> Unit,
    uiStateSpl: SplUIState,
    onClick: () -> Unit
){
    Column(
        modifier = modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        FormSuplier(
            suplierEvent = uiStateSpl.suplierEvent,
            onValueChange = onValueChange,
            errorState = uiStateSpl.isEntryValid,
            modifier = Modifier.fillMaxWidth()
        )
        Button(
            onClick = onClick,
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Simpan")
        }

    }

}

@Composable
fun FormSuplier(
    suplierEvent: SuplierEvent = SuplierEvent(),
    onValueChange: (SuplierEvent) -> Unit = {},
    errorState: SplFormErrorState = SplFormErrorState(),
    modifier: Modifier = Modifier
){
    Column(
        modifier = modifier.fillMaxWidth()
    ) {
        OutlinedTextField(
            modifier = Modifier.fillMaxWidth(),
            value = suplierEvent.nama,
            onValueChange = {
                onValueChange(suplierEvent.copy(nama = it))
            },
            label = { Text("Nama")},
            isError = errorState.nama != null,
            placeholder = { Text("Masukkan Nama")}
        )
        Text(
            text = errorState.nama ?: "",
            color = Color.Red
        )
        OutlinedTextField(
            modifier = Modifier.fillMaxWidth(),
            value = suplierEvent.kontak,
            onValueChange = {
                onValueChange(suplierEvent.copy(kontak = it))
            },
            label = { Text("Kontak")},
            isError = errorState.kontak != null,
            placeholder = { Text("Masukkan Kontak")}
        )
        Text(
            text = errorState.kontak ?: "",
            color = Color.Red
        )
        OutlinedTextField(
            modifier = Modifier.fillMaxWidth(),
            value = suplierEvent.alamat,
            onValueChange = {
                onValueChange(suplierEvent.copy(alamat = it))
            },
            label = { Text("Alamat")},
            isError = errorState.alamat != null,
            placeholder = { Text("Masukkan Alamat")}
        )
        Text(
            text = errorState.alamat ?: "",
            color = Color.Red
        )
    }
}
