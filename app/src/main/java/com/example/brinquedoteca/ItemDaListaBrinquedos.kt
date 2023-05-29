package com.example.brinquedoteca

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme.typography
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.foundation.Image
import androidx.compose.material.Card


@Composable
fun ItemDaListaBrinquedos(brinquedo: Brinquedo) {
    Card(
        modifier = Modifier
            .padding(horizontal = 8.dp, vertical = 8.dp)
            .fillMaxWidth(),
        shape = RoundedCornerShape(corner = CornerSize(16.dp))
    ){
        Row{
            ImagemDoBrinquedo(brinquedo)
            Column(
                modifier = Modifier
                    .padding(16.dp)
                    .fillMaxWidth()
                    .align(Alignment.CenterVertically)){
                Text(text = brinquedo.codigo.toString(), style = typography.h1 )
                Text(text = brinquedo.modelo.toString(), style = typography.h1 )
                Text(text = brinquedo.idade.toString(), style = typography.h1 )
                Text(text = brinquedo.custo.toString(), style = typography.h1 )
                Text(text = brinquedo.volume.toString(), style = typography.h1 )
            }
        }

    }


}

@Composable
fun ImagemDoBrinquedo(brinquedo: Brinquedo) {

    Image(
        painter = painterResource(R.drawable.lagarto_background),
        contentDescription = "Imagem",
        contentScale = ContentScale.Crop,
        modifier = Modifier
            .padding(8.dp)
            .size(84.dp)
            .clip(RoundedCornerShape(corner = CornerSize(16.dp)))
    )
}
