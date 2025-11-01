package com.example.formpendaftaran

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopBar(modifier: Modifier = Modifier){
    TopAppBar(modifier = Modifier.padding(top = 50.dp),
        title = { Text(text= "Formulir Pendaftaran",
            color = Color.White,
            fontFamily = FontFamily.SansSerif,
            fontSize = 30.sp,
        ) },
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = Color.Black
        )
    )
}


@Composable
fun FormPendaftaran(modifier : Modifier) {

    var textNama by remember { mutableStateOf("") }
    var textAlamat by remember { mutableStateOf("") }
    var textJK by remember { mutableStateOf("") }
    var textStatus by remember { mutableStateOf("") }

    var nama by remember {mutableStateOf("")}
    var alamat by remember {mutableStateOf("")}
    var jenis by remember {mutableStateOf("")}
    var status by remember {mutableStateOf("")}

    val gender: List<String> =listOf("Laki-laki", "Perempuan")
    val statusKawin: List<String> = listOf("Janda", "Lajang", "Duda")

    Box(modifier = modifier.fillMaxSize()
        .background(color = Color.DarkGray)) {

        ElevatedCard(
            elevation = CardDefaults.cardElevation(defaultElevation = 50.dp),
            colors = CardDefaults.cardColors(containerColor = Color.LightGray),
            modifier = Modifier
                .padding(20.dp)
        ){
            Column(modifier=Modifier.padding(20.dp),
                verticalArrangement = Arrangement.Top
            ){}
        }
    }
}