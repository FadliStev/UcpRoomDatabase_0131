package com.example.ucp_2_b.ui.navigation

interface AlamatNavigasi{
    val route : String
}

object DestinasiHome : AlamatNavigasi{
    override val route = "Home"
}

object DestinasiHomeBrg : AlamatNavigasi{
    override val route = "Home_brg"
}

object DestinasiHomeSpl : AlamatNavigasi{
    override val route = "Home_Spl"
}

object DestinasiInsertBrg : AlamatNavigasi {
    override val route: String = "insert_brg"
}


object DestinasiInsertSpl : AlamatNavigasi{
    override val route: String = "insert_spl"
}

object DestinasiDetail : AlamatNavigasi{
    override val route = "detail"
    const val NAMA = "nama"
    val routeWithArg = "$route/{$NAMA}"
}

object DestinasiUpdate : AlamatNavigasi{
    override val route = "update"
    const val NAMA = "nama"
    val routeWithArg = "$route/{$NAMA}"
}
