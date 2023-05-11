@file:OptIn(ExperimentalMaterial3Api::class)

package com.pmdm.loginusuario

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.pmdm.loginusuario.ui.theme.LoginUsuarioTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LoginUsuarioTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    LoginScreen()
                }
            }
        }
    }
}

@Composable
fun LoginScreen() {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(text = "Inicio de sesión") },
                actions = {
                    IconButton(onClick = { /*TODO*/ }) {
                        Icon(imageVector = Icons.Default.Refresh, contentDescription = "Recargar")
                    }
                },
            )
        }
    ) {
        var textoUsuario by rememberSaveable { mutableStateOf("") }
        var textoPassWord by rememberSaveable { mutableStateOf("") }
        var resultado by rememberSaveable { mutableStateOf("") }

        Column(
            Modifier
                .padding(it)
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Top
        ) {

            OutlinedTextField(
                value = textoUsuario,
                onValueChange = { textoUsuario = it },
                label = { Text("Login") },
                placeholder = { Text("Usuario") }
            )
            OutlinedTextField(
                value = textoPassWord,
                onValueChange = { textoPassWord = it },
                label = { Text("Password") },
                placeholder = { Text("Contraseña") }
            )
            Button(
                onClick = {
                    if (inicioSesion(textoUsuario, textoPassWord)) {
                        resultado = "Acceso concedido"
                    } else {
                        resultado = "Credenciales erroneas"
                    }
                }
            ) {
                Text("ENTRAR")
            }
            Text(
                text = resultado
            )
        }
    }
}