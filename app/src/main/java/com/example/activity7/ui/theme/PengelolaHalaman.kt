@file:OptIn(ExperimentalMaterial3Api::class,ExperimentalMaterial3Api::class)

package com.example.activity7.ui.theme

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.foundation.selection.selectable
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.Icon
import androidx.compose.material3.TopAppBarDefaults
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
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.activity7.R
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHose
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.activity7.data.SumberData.flavors
import java.io.StringReader


enum class PengelolaHalaman(
    Home,
    Rasa,
    Summary
)

@Composable
fun EsJumboAppBar(
    bisaNavigasiBack : Boolean,
    navigasiUp:()->Unit,
    modifie: Modifier = Modifier
){
    TopAppBar(
        title = {Text(stringResource(id = R.string.app_name))},
        colors = TopAppBarDefaults.mediumTopAppBarColors(
            containerColor = MaterialTheme.colorScheme.primaryContainer
        ),
        modifier = modifier,
        navigationIcon = {
            if(bisaNavigasiBack){
                IconButton(onClick = navigasiUp) {
                    Icon(
                        imageVector = Icons.Filled.ArrowBack,
                        contentDescription = stringResource(R.string.back_button)
                    )
                }
            }
        }
    )
}

@Composable
fun EsJumboApp(
    viewModel: OrderViewModel = viewModel(),
    navController :NavHostController = rememberNavController() {
        Scaffold(
            topBar = {
                EsJumboAppBar(
                    bisaNavigasiBack = false,
                    navigasiUp = { /*TODO: implement back navigation*/ })
            }
        )
    }
){
    innerPadding->
    val uiState by viewModel.stateUI.collectAsState()
    NavHost(
        navController = navController,
        startDestionation = PengelolaHalaman.Home.name,
        modifier = Modifier.padding(innerpadding)
    )
    {
        composable(route = PengelolaHalaman.Home.name)
        HalamanHome(
            onNextButtonClicked = {
                navController.navigate(PengelolaHalaman.Rasa.name)
            }
        )
    }
    composable(route = PengelolaHalaman.Home.name)
    HalamanSatu(
    pilihanRasa = flavors.map{
        id-> context.resource.getString(id)
    },
        onSelectionChanged = {viewModel.setRasa(it)},
        onConfirmButtonClicked = {
            viewModel.setJumlah(it)
        },
        onNextButtonClicker = {
            navController.navigate(PengelolaHalaman.Summary.name)
        },
        onCancelButtonClicked = {
            cancelOrderAndNavigateToHome(
                viewModel,
                navController
            )
        }
    )
    composable(route = PengelolaHalaman.Summary.name){
        HalamanDua(
            orderUiState = uiState,
            onCancelButtonClicker = {
                cancelOrderAndNavigateToRasa(navController)
            }
        )
    }
}
private fun cancelOrderAndNavigateToHome(
    viewModel: OrderViewModel,
    navController:NavHostController
){
    viewModel.resetOrder()
    navController.popBackStack(PengelolaHalaman.Home.name, inclusive = false)
}
private fun cancelOrderAndNavigateToRasa(
    navController:NavHostController
){
    navController.popBackStack(PengelolaHalaman.Rasa.name, inclusive = false)

}