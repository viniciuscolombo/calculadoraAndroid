package com.example.calculadora

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

class CalculatorViewModel : ViewModel() {
    var inputAtual by mutableStateOf("0")
        private set

    var inputAnterior by mutableStateOf("0")
        private set

    var operacaoAtual by mutableStateOf("")
        private set

    var resetaTela by mutableStateOf(false)
        private set

    fun adicionaNumero(numero: String) {
        if (inputAtual == "0" || resetaTela){
            inputAtual = numero
            resetaTela = false
        } else {
            inputAtual += numero
        }
    }

    fun setaOperacao(operacao: String){
        if (inputAtual.isNotEmpty()) {
            inputAnterior = inputAtual
            operacaoAtual = operacao
            resetaTela = true
        }
    }

    fun calcular() {
        if (operacaoAtual.isEmpty() || inputAnterior.isEmpty() || inputAtual.isEmpty())  return

        val num1 = inputAnterior.toDoubleOrNull() ?: return
        val num2 = inputAtual.toDoubleOrNull() ?: return

        inputAtual = when (operacaoAtual) {
            "+" -> (num1 + num2).toString()
            "-" -> (num1 - num2).toString()
            "*" -> (num1 * num2).toString()
            "÷" -> if (num2 != 0.0) (num1 / num2).toString() else "Erro"
            else -> inputAtual
        }

        inputAnterior = ""
        operacaoAtual = ""
        resetaTela    = true
    }

    fun clear() {
        inputAtual = "0"
        inputAnterior = ""
        operacaoAtual = ""
        resetaTela = false
    }

}