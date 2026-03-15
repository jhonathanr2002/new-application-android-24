package com.personal.jr.myapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.personal.jr.myapplication.ui.theme.MyApplicationTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            MyApplicationTheme {
                Calculadora()
            }
        }
    }
}

@Composable
fun Calculadora() {
    var num1 by remember { mutableStateOf("") }
    var num2 by remember { mutableStateOf("") }
    var resultado by remember { mutableStateOf("0") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp)
    ) {

        Text(text = "Calculadora", style = MaterialTheme.typography.headlineMedium)

        Spacer(modifier = Modifier.height(20.dp))

        OutlinedTextField(
            value = num1,
            onValueChange = { num1 = it },
            label = { Text("Número 1") }
        )

        Spacer(modifier = Modifier.height(10.dp))

        OutlinedTextField(
            value = num2,
            onValueChange = { num2 = it },
            label = { Text("Número 2") }
        )

        Spacer(modifier = Modifier.height(20.dp))

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {

            Button(onClick = {
                val r = num1.toDouble() + num2.toDouble()
                resultado = r.toString()
            }) {
                Text("+")
            }

            Button(onClick = {
                val r = num1.toDouble() - num2.toDouble()
                resultado = r.toString()
            }) {
                Text("-")
            }

            Button(onClick = {
                val r = num1.toDouble() * num2.toDouble()
                resultado = r.toString()
            }) {
                Text("×")
            }

            Button(onClick = {
                val r = num1.toDouble() / num2.toDouble()
                resultado = r.toString()
            }) {
                Text("÷")
            }
        }

        Spacer(modifier = Modifier.height(15.dp))

        Text(
            text = "Resultado: $resultado",
            style = MaterialTheme.typography.headlineSmall
        )
    }
}