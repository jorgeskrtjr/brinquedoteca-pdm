package com.example.brinquedoteca

import android.content.Intent
import android.util.Log
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material.DropdownMenu
import androidx.compose.material.DropdownMenuItem
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.example.brinquedoteca.crud.TelaApresentacao

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MenuTremPontos()
            ElementosDaTela()
        }
    }
}

@Composable
fun ElementosDaTela(){
    val contexto = LocalContext.current

    Column(
        Modifier.padding(40.dp)
    ) {
        Text(text = "Fábrica de brinquedos", textAlign = TextAlign.Center, modifier = Modifier.width(300.dp))
        Spacer(modifier = Modifier.height(15.dp))
        Button(
            onClick = {
                Log.i("Teste", "Botão inserir")
                // contexto.startActivity(Intent(contexto, TelaInsercao::class.java))
            },
            modifier = Modifier.width(300.dp)
        ) {
            Text(text = "Inserir")
        }
        Spacer(modifier = Modifier.height(15.dp))
        Button(
            onClick = {
                contexto.startActivity(Intent(contexto, TelaApresentacao::class.java))
            },
            modifier = Modifier.width(300.dp)
        ) {
            Text(text = "Mostrar")
        }
    }
}

@Composable fun MenuTremPontos() {
    val contexto = LocalContext.current
    var isOpened by remember { mutableStateOf(false) }

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentSize(Alignment.TopEnd)
    ){
        IconButton(onClick = {isOpened != isOpened }){
            Icon(
                 imageVector = Icons.Default.MoreVert,
                 contentDescription = "More vert"
                )
        }
        DropdownMenu(expanded = isOpened, onDismissRequest = { isOpened = false}) {
            DropdownMenuItem(
            onClick = { Toast.makeText(contexto, "Jorge Silva Junior", Toast.LENGTH_LONG).show()
                 isOpened = !isOpened
              }
            ){
                Text("Creditos")
            }
        }
    }
}


