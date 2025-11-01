package com.example.formpendaftaran

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.selection.selectable
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopBar(modifier: Modifier = Modifier) {
    Column(modifier = modifier) {
        Spacer(modifier = Modifier.height(50.dp))
        TopAppBar(
            title = {
                Text(
                    text = "Formulir Pendaftaran",
                    color = Color.White,
                    fontFamily = FontFamily.SansSerif,
                    fontSize = 30.sp,
                )
            },
            colors = TopAppBarDefaults.topAppBarColors(
                containerColor = Color.Black
            )
        )
    }
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

    Box(modifier = modifier
        .fillMaxSize()
        .background(color = Color.DarkGray)) {

        ElevatedCard(
            elevation = CardDefaults.cardElevation(defaultElevation = 50.dp),
            colors = CardDefaults.cardColors(containerColor = Color.LightGray),
            modifier = Modifier
                .padding(20.dp)
        ){
            Column(modifier=Modifier.padding(20.dp),
                verticalArrangement = Arrangement.Top
            ){
                Text(text=stringResource(R.string.nama).uppercase(),
                    modifier = Modifier.padding(5.dp)
                )
                OutlinedTextField(
                    value = textNama,
                    singleLine = true,
                    shape = MaterialTheme.shapes.large,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(5.dp),
                    label = { Text(text = "Isian Nama Lengkap")},
                    onValueChange = {
                        textNama = it
                    },
                )
                Text(text=stringResource(R.string.jenis).uppercase(),
                    modifier = Modifier.padding(5.dp)
                )
                Column(
                    modifier = Modifier.padding(5.dp)
                ) {
                    gender.forEach { item ->
                        Row(
                            modifier = Modifier.selectable(
                                selected = textJK == item,
                                onClick = { textJK = item }
                            ), verticalAlignment = Alignment.CenterVertically) {
                            RadioButton(
                                selected = textJK == item,
                                onClick = {
                                    textJK = item
                                })
                            Text(text=item)
                        }
                    }
                }
                Text(text=stringResource(R.string.status).uppercase(),
                    modifier = Modifier.padding(5.dp)
                )
                Column(
                    modifier = Modifier.padding(5.dp)
                ) {
                    statusKawin.forEach { item ->
                        Row(
                            modifier = Modifier.selectable(
                                selected = textStatus == item,
                                onClick = { textStatus = item }
                            ), verticalAlignment = Alignment.CenterVertically) {
                            RadioButton(
                                selected = textStatus == item,
                                onClick = {
                                    textStatus = item
                                })
                            Text(text=item)
                        }
                    }
                }
                Text(text=stringResource(R.string.alamat).uppercase(),
                    modifier = Modifier.padding(5.dp)
                )
                OutlinedTextField(
                    value = textAlamat,
                    singleLine = true,
                    shape = MaterialTheme.shapes.large,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(5.dp),
                    label = { Text(text = "Alamat")},
                    onValueChange = {
                        textAlamat = it
                    }
                )
                Button(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(5.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color.Black,
                        contentColor = Color.White
                    ),
                    enabled= textAlamat.isNotEmpty() && textNama.isNotEmpty() && textJK.isNotEmpty() && textStatus.isNotEmpty(),
                    onClick = {
                        nama = textNama
                        jenis=textJK
                        status=textStatus
                        alamat=textAlamat
                    }
                ){
                    Text(text=stringResource(R.string.submit))
                }
            }
        }
    }
}