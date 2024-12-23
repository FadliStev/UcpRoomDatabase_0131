package com.example.ucp_2_b.ui.customwidget

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.ucp_2_b.R

@Preview(showBackground = false)
@Composable
fun HomeTopAppBar(
    modifier: Modifier = Modifier,
) {

    Column(
        modifier = modifier
            .fillMaxWidth()
            .height(200.dp)
            .background(
                Color(0xFF42A5F5),
                shape = RoundedCornerShape(bottomEnd = 80.dp)
            )
    ) {
        Row(
            modifier = Modifier
                .fillMaxSize()
                .padding(10.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {

            Column {
                Icon(
                    Icons.Filled.Menu, contentDescription = "",
                    Modifier
                        .padding(6.dp)
                        .size(40.dp),
                    tint = Color.White
                )
                Text(
                    text = "Inventaris",
                    Modifier
                        .padding(6.dp),
                    style = TextStyle(
                        fontSize = 30.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color.White
                    ),

                    )
                Text(
                    text = "Toko Izal Bjir",
                    style = TextStyle(
                        fontSize = 20.sp,
                        color = Color.White
                    )

                )

            }
            Image(
                painter = painterResource(id = R.drawable.icontoko),
                contentDescription = "",
                Modifier
                    .size(100.dp)
                    .clip(shape = CircleShape)

            )
        }
    }
}