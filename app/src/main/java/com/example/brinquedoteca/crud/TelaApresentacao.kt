package com.example.brinquedoteca.crud

import android.annotation.SuppressLint
import android.app.Activity
import android.os.Bundle
import android.os.PersistableBundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.brinquedoteca.BancoBrinquedos
import com.example.brinquedoteca.Brinquedo
import com.example.brinquedoteca.ItemDaListaBrinquedos

class TelaApresentacao() : ComponentActivity()
{
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MenuTresPontosApresentacao()
            Apresentacao()
        }
    }

}

@OptIn(ExperimentalMaterialApi::class)
@SuppressLint("UnusedMaterialScaffoldPaddingParamater")
@Composable
fun Apresentacao(){

    val listState = rememberLazyListState()
    val contexto = LocalContext.current
    val meuBanco = BancoBrinquedos(contexto)
    val db_leitura = meuBanco.readableDatabase
    var cursor = db_leitura.rawQuery("select * from brinquedo", null)
    val listaBrinquedos = mutableListOf<Brinquedo>()

    with(cursor){
        while(moveToNext()){
            val codigo = this.getInt(getColumnIndexOrThrow("codigo"))
            val modelo = this.getString(getColumnIndexOrThrow("modelo"))
            val idade = this.getInt(getColumnIndexOrThrow("idade"))
            val peso = this.getFloat(getColumnIndexOrThrow("peso"))
            val volume = this.getFloat(getColumnIndexOrThrow("volume"))
            val custo = this.getDouble(getColumnIndexOrThrow("custo"))
        }
    }

    cursor.close()

    Scaffold(
        content = {
            Column(
                Modifier.padding(40.dp)
            ) {
                Text(
                    text = "Tela de apresentação",
                    textAlign = TextAlign.Center,
                    modifier = Modifier.fillMaxWidth()
                )
                Spacer(modifier = Modifier.height(25.dp))
                LazyColumn(
                    state = listState,
                    contentPadding = PaddingValues(horizontal = 16.dp, vertical = 8.dp)
                ) {
                    items(
                        items = listaBrinquedos,
                        itemContent = {
                            ItemDaListaBrinquedos(brinquedo = it)
                        }
                    )
                }
            }
        }
    )

}

@Composable
fun MenuTresPontosApresentacao() {
    var isOpened by remember { mutableStateOf(false) }
    val activity = (LocalContext.current as? Activity)

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentSize(Alignment.TopEnd)
    ){
        IconButton(onClick = {isOpened = !isOpened}) {
            Icon(
                imageVector = Icons.Default.MoreVert,
                contentDescription = "More vert"
            )
        }
        DropdownMenu(expanded = isOpened, onDismissRequest = { isOpened = false}) {
            DropdownMenuItem(
                onClick = { Toast.makeText(activity, "Jorge Silva Junior", Toast.LENGTH_LONG).show()
                    isOpened = !isOpened
                }
            ){
                Text("Voltar")
            }
        }

    }

}