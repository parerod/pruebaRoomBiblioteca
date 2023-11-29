package com.example.pruebaroom.modelo.entidades

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.Ignore
import androidx.room.PrimaryKey

@Entity(tableName="biblioteca")
data class Biblioteca (
    @ColumnInfo(name = "nombre")
    var nombre:String,
    @ColumnInfo(name = "direccion")
    var direccion:String?=null){
    @PrimaryKey(autoGenerate=true)
    @ColumnInfo(name = "id_biblioteca")
    var id_biblioteca:Int=0



}