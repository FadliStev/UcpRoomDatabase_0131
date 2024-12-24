package com.example.ucp_2_b.ui.view.barang

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.ucp_2_b.ui.customwidget.TopAppBar
import com.example.ucp_2_b.ui.view.suplier.InsertBodySpl
import com.example.ucp_2_b.ui.viewmodel.BarangEvent
import com.example.ucp_2_b.ui.viewmodel.BrgFormErrorState
import com.example.ucp_2_b.ui.viewmodel.BrgUIState
import com.example.ucp_2_b.ui.viewmodel.HomeSplViewModel
import com.example.ucp_2_b.ui.viewmodel.InsertBrgViewModel
import com.example.ucp_2_b.ui.viewmodel.InsertSplViewModel
import com.example.ucp_2_b.ui.viewmodel.PenyediaViewModel
import com.example.ucp_2_b.ui.viewmodel.SplFormErrorState
import com.example.ucp_2_b.ui.viewmodel.SuplierEvent
import kotlinx.coroutines.launch


@Composable
fun InsertBrgView(
    onBack: () -> Unit,
    onNavigate: () -> Unit,
    modifier: Modifier = Modifier,
    viewModel: InsertBrgViewModel = viewModel(factory = PenyediaViewModel.Factory)
){
    val uiStateBrg = viewModel.uiStateBrg
    val snackbarHostState = remember { SnackbarHostState() }
    val corroutineScope = rememberCoroutineScope()

    LaunchedEffect(uiStateBrg.snackbarMessage) {
        uiStateBrg.snackbarMessage?.let { message ->
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
        ) {
            TopAppBar(
                onBack = onBack,
                showBackButton = true,
                judul = "Tambah Barang"
            )
            InsertBodyBrg(
                uiStateBrg = uiStateBrg,
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
fun InsertBodyBrg(
    modifier: Modifier = Modifier,
    onValueChange: (BarangEvent) -> Unit,
    uiStateBrg: BrgUIState,
    onClick: () -> Unit
){
    Column(
        modifier = modifier
            .fillMaxWidth()
            .padding(15.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        FormBarang(
            barangEvent = uiStateBrg.barangEvent,
            onValueChange = onValueChange,
            errorState = uiStateBrg.isEntrValid,
            modifier = Modifier.fillMaxWidth()
        )
        Button(
            onClick = onClick,
            modifier = Modifier.fillMaxWidth(),
            colors = ButtonDefaults.buttonColors(Color.Blue)
        ) {
            Text("Simpan")
        }

    }

}

@Composable
fun FormBarang(
    barangEvent: BarangEvent = BarangEvent(),
    onValueChange: (BarangEvent) -> Unit = {},
    errorState: BrgFormErrorState = BrgFormErrorState(),
    HomeSplViewModel: HomeSplViewModel = viewModel(factory = PenyediaViewModel.Factory),
    modifier: Modifier = Modifier
){
    val supUI by HomeSplViewModel.homeSplUiState.collectAsState()

    Column(
        modifier = modifier
            .fillMaxWidth()
            .padding(15.dp)
    ) {
        OutlinedTextField(
            modifier = Modifier.fillMaxWidth(),
            value = barangEvent.nama,
            onValueChange = {
                onValueChange(barangEvent.copy(nama = it))
            },
            label = { Text("Nama") },
            isError = errorState.nama != null,
            placeholder = { Text("Masukkan Nama") }
        )
        Text(
            text = errorState.nama ?: "",
            color = Color.Red
        )
        OutlinedTextField(
            modifier = Modifier.fillMaxWidth(),
            value = barangEvent.deskripsi,
            onValueChange = {
                onValueChange(barangEvent.copy(deskripsi = it))
            },
            label = { Text("Deskripsi") },
            isError = errorState.deskripsi != null,
            placeholder = { Text("Masukkan Deskripsi") }
        )
        Text(
            text = errorState.deskripsi ?: "",
            color = Color.Red
        )
        OutlinedTextField(
            modifier = Modifier.fillMaxWidth(),
            value = barangEvent.harga,
            onValueChange = {
                onValueChange(barangEvent.copy(harga = it))
            },
            label = { Text("Harga") },
            isError = errorState.harga != null,
            placeholder = { Text("Masukkan Harga") }
        )
        Text(
            text = errorState.harga ?: "",
            color = Color.Red
        )
        OutlinedTextField(
            modifier = Modifier.fillMaxWidth(),
            value = barangEvent.stok,
            onValueChange = {
                onValueChange(barangEvent.copy(stok = it))
            },
            label = { Text("Stok") },
            isError = errorState.harga != null,
            placeholder = { Text("Masukkan Stok") }
        )
        Text(
            text = errorState.stok ?: "",
            color = Color.Red
        )
        DropDownSup(
            title = "Pilih Suplier",
            options = supUI.listSpl.map { it.nama } ,
            selectedOption = barangEvent.namaSuplier,
            onOptionSelected = { namaSup ->
                onValueChange(barangEvent.copy(namaSuplier = namaSup))

            },
            isError = errorState.namaSuplier != null,
            errorMessage = errorState.namaSuplier
        )
        Text(
            text = errorState.namaSuplier ?: "",
            color = Color.Red
            )

    }
}

@Composable
fun DropDownSup(
    title: String,
    options: List<String>,
    selectedOption: String,
    onOptionSelected: (String) -> Unit,
    isError: Boolean = false,
    errorMessage: String? = null
){
    var expanded by remember { mutableStateOf(false) }
    var currentSelected by remember { mutableStateOf(selectedOption) }

    Column {
        OutlinedTextField(
            value = currentSelected,
            onValueChange = {},
            readOnly = true,
            label = { Text(text = title) },
            trailingIcon = {
                androidx.compose.material3.IconButton(onClick = { expanded = !expanded }) {
                    Icon(
                        imageVector = if (expanded) Icons.Default.ArrowDropDown else Icons.Default.ArrowDropDown,
                        contentDescription = null
                    )
                }
            },
            modifier = Modifier.fillMaxWidth()
        )
        DropdownMenu(
            expanded = expanded,
            onDismissRequest = { expanded = false }
        ){
            options.forEach { option ->
                DropdownMenuItem(
                    text = { Text(text = option) },
                    onClick = {
                        onOptionSelected(option)
                        currentSelected = option
                        expanded = false
                    }
                )
            }
        }
        if (isError && errorMessage != null) {
            Text(
                text = errorMessage,
                color = Color.Red
            )

        }
    }
}

