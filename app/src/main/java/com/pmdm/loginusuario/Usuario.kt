package com.pmdm.loginusuario

data class Usuario(val nombreUsuario: String, val password: String)

val userList = mutableListOf(
    Usuario("Nacho", "Chona"),
    Usuario("Salatiel", "Tiellasa"),
    Usuario("Ivan", "Vani"),
    Usuario("Alejandro", "Drojanlea"),
)

fun inicioSesion(nombreUsuario: String, password: String): Boolean {
    return userList.any { it.nombreUsuario == nombreUsuario && it.password == password }
}