package com.example.calculadora


import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape

import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp

/*Monta a tela da calculadora e chama a grid de botôes*/
@Composable
fun CalculatorScreen(viewModel: CalculatorViewModel) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ){
        Text(
            text = viewModel.inputAtual,
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 32.dp)
                .background(Color.LightGray, RoundedCornerShape(8.dp))
                .padding(16.dp),
            style = MaterialTheme.typography.displayLarge,
            textAlign = TextAlign.End
        )
        Column (
            modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ){
            CalculatorButtonGrid(viewModel = viewModel)
        }
    }
}

/* Monta a grid de botôes conforme foi passado no slide*/
@Composable
fun CalculatorButtonGrid(viewModel: CalculatorViewModel){
    Column (
        modifier = Modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.spacedBy(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Row (
            horizontalArrangement = Arrangement.spacedBy(16.dp),
            modifier = Modifier.fillMaxWidth()
        ){
            CalculatorButton("1") {viewModel.adicionaNumero("1")}
            CalculatorButton("2") {viewModel.adicionaNumero("2")}
            CalculatorButton("3") {viewModel.adicionaNumero("3")}
            CalculatorButton("+") {viewModel.setaOperacao("+")}
        }

        Row (
            horizontalArrangement = Arrangement.spacedBy(16.dp),
            modifier = Modifier.fillMaxWidth()
        ){
            CalculatorButton("4") {viewModel.adicionaNumero("4")}
            CalculatorButton("5") {viewModel.adicionaNumero("5")}
            CalculatorButton("6") {viewModel.adicionaNumero("6")}
            CalculatorButton("-") {viewModel.setaOperacao("-")}
        }

        Row (
            horizontalArrangement = Arrangement.spacedBy(16.dp),
            modifier = Modifier.fillMaxWidth()
        ){
            CalculatorButton("7") {viewModel.adicionaNumero("7")}
            CalculatorButton("8") {viewModel.adicionaNumero("8")}
            CalculatorButton("9") {viewModel.adicionaNumero("9")}
            CalculatorButton("*") {viewModel.setaOperacao("*")}
        }

        Row (
            horizontalArrangement = Arrangement.spacedBy(16.dp),
            modifier = Modifier.fillMaxWidth()
        ){
            CalculatorButton("C") {viewModel.clear()}
            CalculatorButton("0") {viewModel.adicionaNumero("0")}
            CalculatorButton("=") {viewModel.calcular()}
            CalculatorButton("÷") { viewModel.setaOperacao("÷")}
        }
    }
}

@Composable
fun CalculatorButton(
    symbol: String,
    modifier: Modifier = Modifier,
    onClick: () -> Unit
) {
    Button(
        onClick = onClick,
        modifier = modifier
            .size(80.dp)
            .aspectRatio(1f)
    ) {
        Text(text = symbol, style = MaterialTheme.typography.headlineMedium)
    }
}