package com.example.ucp_2_b.ui.view

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.ucp_2_b.ui.customwidget.HomeTopAppBar


@Composable
fun HomeView(
    modifier: Modifier = Modifier,
    onNavigateAddSup: () -> Unit,
    onNavigateAddBrg: () -> Unit,
    onNavigateListSup: () -> Unit,
    onNavigateListBrg: () -> Unit,
) {
    Scaffold(
        modifier = modifier,
        topBar = {
            HomeTopAppBar()
        }
    ) { innerPadding ->
        BodyHome(
            modifier = Modifier.padding(innerPadding),
            onBrgListClick = {
                onNavigateListBrg()
            },
            onAddSupClick = {
                onNavigateAddSup()
            },
            onListSupClick = {
                onNavigateListSup()
            },
            onAddBrgClick = {
                onNavigateAddBrg()
            }
        )
    }
}

@Composable
fun BodyHome(
    modifier: Modifier = Modifier,
    onBrgListClick: () -> Unit = {},
    onAddSupClick: () -> Unit = {},
    onListSupClick: () -> Unit = {},
    onAddBrgClick: () -> Unit = {},
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = modifier.fillMaxWidth().padding(16.dp)
    ) {
        Row {
            CardMenu(
                namaMenu = "List Produk",
                onClick = onBrgListClick,
                namaIcon = Icons.Default.Menu
            )
            CardMenu(
                namaMenu = "Add Product",
                onClick = onAddBrgClick,
                namaIcon = Icons.Default.Add
            )
        }
        Row {
            CardMenu(
                namaMenu = "List Supplier",
                onClick = onListSupClick,
                namaIcon = Icons.Default.Person
            )
            CardMenu(
                namaMenu = "AddSupplier",
                onClick = onAddSupClick,
                namaIcon = Icons.Default.Add
            )
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CardMenu(
    namaMenu: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    namaIcon: ImageVector
) {
    Card(
        onClick = onClick,
        modifier = modifier
            .width(188.dp)
            .height(230.dp)
            .padding(8.dp),
    ) {
        Box(
            modifier = Modifier
                .background(color = Color(0xFF42A5F5))
                .fillMaxHeight()
        ) {
            Column(
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier
                    .padding(16.dp)
                    .fillMaxWidth()
                    .fillMaxHeight()
            ) {
                Icon(
                    imageVector = namaIcon,
                    contentDescription = "",
                    tint = Color.White
                )
                Spacer(modifier = Modifier.padding(8.dp))
                Text(
                    text = namaMenu,
                    color = Color.White,
                    fontWeight = FontWeight.ExtraBold
                )
            }
        }
    }
}