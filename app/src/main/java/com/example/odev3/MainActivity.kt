package com.example.odev3

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.odev3.R
import com.example.odev3.ui.theme.AnaRenk
import com.example.odev3.ui.theme.AnaRenkDark
import com.example.odev3.ui.theme.Odev3Theme
import com.example.odev3.ui.theme.YaziRenk1
import com.example.odev3.ui.theme.YaziRenk2
import com.example.odev3.ui.theme.merriweather


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Odev3Theme {
                Anasayfa()
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Anasayfa(darkTheme: Boolean = isSystemInDarkTheme()) {

    val configuration = LocalConfiguration.current

    val ekranGenisligi = configuration.screenWidthDp
    val ekranYuksekligi = configuration.screenHeightDp


    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = { Text(text = "İlan", fontFamily = merriweather) },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = if (darkTheme) AnaRenkDark else AnaRenk,
                    titleContentColor = YaziRenk1
                )
            )
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues),
            verticalArrangement = Arrangement.SpaceEvenly,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = stringResource(id = R.string.daireBaslik),
                color = YaziRenk2,
                fontWeight = FontWeight.Bold,
                fontSize = (ekranGenisligi / 10).sp,
            )
            Image(
                painter = painterResource(id = R.drawable.daire_resim),
                contentDescription = "",
                modifier = Modifier
                    .width(750.dp)
                    .height(230.dp)
            )

            Text(
                text = stringResource(id = R.string.ilanDetay),
                color = YaziRenk2,
                fontWeight = FontWeight.Bold,
                fontSize = 22.sp
            )

            Text(
                text = stringResource(id = R.string.daireAciklama),
                color = YaziRenk2,
                fontSize = 22.sp,
                textAlign = TextAlign.Center
            )
            Row(
                modifier = Modifier.fillMaxWidth().padding(start = 10.dp, end = 10.dp),
                horizontalArrangement = Arrangement.Center
            )
            {
                Text(
                    text = stringResource(id = R.string.fiyatYazi),
                    color = YaziRenk2,
                    fontWeight = FontWeight.Bold,
                    fontSize = 40.sp
                )
            }
            Row(
                modifier = Modifier.fillMaxWidth()
                    .padding(start = (ekranGenisligi / 20).dp, end = (ekranGenisligi / 20).dp),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Chip(icerik = "Ara")
                Chip(icerik = "Mesaj Gönder")
                Chip(icerik = "Teklif Ver")
            }
        }
    }
}

@Preview(showBackground = true, locale = "tr")
@Composable
fun GreetingPreview() {
    Odev3Theme {
        Anasayfa()
    }
}
