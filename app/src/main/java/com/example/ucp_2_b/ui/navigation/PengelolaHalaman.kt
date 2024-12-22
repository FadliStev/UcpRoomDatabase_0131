package com.example.ucp_2_b.ui.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.ucp_2_b.ui.view.barang.DetailMhsView
import com.example.ucp_2_b.ui.view.barang.HomeBrgView
import com.example.ucp_2_b.ui.view.barang.InsertBrgView
import com.example.ucp_2_b.ui.view.barang.UpdateBrgView
import com.example.ucp_2_b.ui.view.suplier.HomeSplView
import com.example.ucp_2_b.ui.view.suplier.InsertSplView

@Composable
fun PengelolaHalaman(
    navController: NavHostController = rememberNavController(),
    modifier: Modifier = Modifier
){

    NavHost(
        navController = navController,
        startDestination = DestinasiHomeBrg.route
    ){
        composable(
            route = DestinasiHomeSpl.route
        ){

            HomeSplView(
                onAddSpl = {
                    navController.navigate(DestinasiInsertSpl.route)
                },
                modifier = modifier
            )
        }
        composable(
            route = DestinasiHomeBrg.route
        ){

            HomeBrgView(
                onDetailClick = {nama ->
                    navController.navigate("${DestinasiDetail.route}/$nama")
                    println(
                        "PengelolaHalaman: nim = $nama"
                    )
                },
                onAddBrg = {
                    navController.navigate(DestinasiInsertBrg.route)
                },
                modifier = modifier
            )
        }
        composable(
            route = DestinasiInsertSpl.route
        ){
            InsertSplView(
                onBack = {navController.popBackStack()},
                onNavigate = { navController.popBackStack()},
                modifier = modifier
                )
        }
        composable(
            route = DestinasiInsertBrg.route
        ){
            InsertBrgView(
                onBack = {navController.popBackStack()},
                onNavigate = { navController.popBackStack()},
                modifier = modifier
            )
        }

        composable(
            DestinasiDetail.routeWithArg,
            arguments = listOf(
                navArgument(DestinasiDetail.NAMA){
                    type = NavType.StringType
                }
            )
        ){
            val nim = it.arguments?.getString(DestinasiDetail.NAMA)
            nim?.let { nama ->
                DetailMhsView(
                    onBack = {
                        navController.popBackStack()
                    },
                    onEditClick = {
                        navController.navigate("${DestinasiUpdate.route}/$it")
                    },
                    modifier = modifier,
                    onDeleteClick = {
                        navController.popBackStack()
                    }
                )
            }
        }
        composable(
            DestinasiUpdate.routeWithArg,
            arguments = listOf(
                navArgument(DestinasiUpdate.NAMA){
                    type = NavType.StringType
                }
            )
        ){
            UpdateBrgView(
                onBack = {
                    navController.popBackStack()
                },
                onNavigate = {
                    navController.popBackStack()
                },
                modifier = modifier
            )
        }
    }

}