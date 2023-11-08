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
import androidx.compose.ui.unit.sp
import com.example.activity7.R
import com.example.activity7.data.OrderUIState
import com.example.activity7.komponen.FormatLabelHarga
import com.example.activity7.ui.komponen.FormatLabelHarga


@Composable
fun HalamanDua(
    orderUiState:OrderUIState,
    onCancelButtonClicker:()-> Unit,
    modifier:Modifier = Modifier
    //onSendButtonClicked: (String,String)
){
    val items = listOf(
        Pair(stringResource(R.string.quantity),orderUiState.jumlah),
        Pair(stringResource(R.string.flavor),orderUiState.rasa),
        )
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.SpaceBetween
    ){
        Column (
            modifier = Modifier.padding(dimensionResource(R.dimen.padding_medium)),
            verticalArrangement = Arrangement.spacedBy(dimensionResource(R.dimen.padding_small))
        ){
            items.forEach{ item ->
                Column{
                    Text(item.first.uppercase())
                    Text(text= item.sexond.toString(),fontWeight = FontWeight.Bold)
                }
                Divider(thickness = dimensionResource(R.dimen.thickness_divider))
            }
            Spacer(modifier = Modifier.height(dimensionResource(R.dimen.padding_small)))
            FormatLabelHarga(subtotal = orderUiState.harga,
                modifier = Modifier.align(Alignment.End))
        }
        Row(modifier = Modifier
            .weight(1f, false)
            .padding(dimensionResource(R.dimen.padding_medium))
        ){
            Column(
                verticalArrangement = Arrangement.spacedBy(dimensionResource(R.dimen.padding_small))
            ){
                Button(
                    modifier = Modifier.fillMaxWidth(),
                    onClick = {}
                ){
                    Text(stringResource(R.string.send))
                }
                OutlinedButton(
                    modifier = Modifier.fillMaxWidth(),
                    onClick = onCancelButtonClicker) {
                    Text(stringResource(R.string.cancel))
                }
            }
        }
    }
}