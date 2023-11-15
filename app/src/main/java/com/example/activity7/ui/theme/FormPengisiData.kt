package com.example.activity7.ui.theme

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.selection.selectable
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.RadioButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.activity7.R
import java.util.jar.Attributes.Name

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HalamanSatu(
    onSumbitButtonClicked:(MutableList<String>) -> Unit
)
{
    var namaTxt by remember{
        mutableStateOf("")
    }
    var alamatTxt by remember {
        mutableStateOf("")
    }
    var tlpnTxt by remember {
        mutableStateOf("")
    }
    var ListData:MutableList<String> = mutableListOf(namaTxt,alamatTxt,tlpnTxt)

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier.fillMaxWidth()
    ){
        OutlinedTextField(
            value = namaTxt,
            onValueChange ={namaTxt = it},
            label =  { Text(text = stringResource(id = R.string.nama))}
        )

        OutlinedTextField(
            value = alamatTxt,
            onValueChange ={alamatTxt = it},
            label =  { Text(text = stringResource(id = R.string.alamat))}
        )

        OutlinedTextField(
            value = tlpnTxt,
            onValueChange ={tlpnTxt = it},
            label =  { Text(text = stringResource(id = R.string.tlpn))}
        )
        Spacer(modifier = Modifier.height(15.dp))

        Button(onClick={ onSumbitButtonClicked(ListData)}){
            Text(text = stringResource(id = R.string.Submit))
        }

    }
}