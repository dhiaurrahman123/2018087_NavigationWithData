package com.example.activity7.ui.theme

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.Image
import androidx.compose.foundation.layout.BorderStroke
import androidx.compose.material3.Button
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedCard
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.foundation.layout.Row
import androidx.compose.runtime.Composable
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.layout.ContentScale
import com.example.activity7.R
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.contentColorFor
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp



@Composable
fun HalamanHome(
    onNextButtonClicked:()->Unit
) {
    val image= painterResource(id = R.drawable.esteh)
    Column(modifier=Modifier,
        verticalArrangement = Arrangement.SpaceBetween) {
        OutlinedCard (
            colors = CardDefaults.cardColors(
                containerColor = MaterialTheme.colorScheme.surface
            ),
            border = BorderStroke(1.dp, Color.Black), modifier = Modifier
                ///.fillMaxWidth(0.95f)
                ///.padding(vertical = 50.dp)
                ///.align(alignment.CenterHorizontally)
            ){
            Column(horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier,
                .align(alignment.CenterHorizontally)){
            Image(
                painter = image,
                contentDescription = null,
                contentScale = ContentScale.Crop
            )
            Text(
                text = "Es Teh",
                color = Color.DarkGray,
                fontSize = 35.sp,
                modifier = Modifier
                    .align(Alignment.CenterHorizontally)
            )
            Text(
                text = "Mimunam Dingin",
                color = Color.DarkGray,
                fontSize = 35.sp,
                modifier = Modifier
                    .align(Alignment.CenterHorizontally)
            )
            Row(modifier= Modifier
                .fillMaxWidth()
                .padding(dimensionResource(R.deman.padding_medium))
                .weight(if, false)
               horizontalArrangment = Arrangement.spaceBy(dimensionResource(R.deman.padding_medium)),
                verticalAligment = Aligment.Bottom
            )
            {
                Button(
                    modifier = Modifier.weight(if)
                    onClick = onNextButtonClicked
                ){
                    Text(stringResource(R.string.next))
                    }
            }
    }
            }
        }
    }
@Preview(showBackground = true)
@Composable
fun PreviewHalamanHome(){
    Activity7Theme {
        HalamanHome {
            (onNextButtonClicked = {})
        }
    }
}