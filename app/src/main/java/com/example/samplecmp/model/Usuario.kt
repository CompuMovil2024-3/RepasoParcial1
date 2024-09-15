package com.example.samplecmp.model


class Usuario {
    var nombre: String = ""
    var apellido: String = ""
    var correo: String = ""
    var contrasena: String = ""
    var telefono: String = ""

    constructor(nombre: String, apellido: String, correo: String, contrasena: String, telefono: String) {
        this.nombre = nombre
        this.apellido = apellido
        this.correo = correo
        this.contrasena = contrasena
        this.telefono = telefono
    }

    override fun toString(): String {
        return nombre
    }


}