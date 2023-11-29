package com.example.pruebaroom.modelo.entidades

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.ForeignKey.Companion.CASCADE
import androidx.room.PrimaryKey

@Entity(tableName="libro",
        foreignKeys = [
            ForeignKey(
                entity = Biblioteca::class,
                parentColumns = ["id_biblioteca"],
                childColumns = ["id_bibliotecaPadre"],
                onDelete = CASCADE
            )
        ])
data class Libro (
    @ColumnInfo(name = "nombre")
    var nombre:String,
    @ColumnInfo(name = "autor")
    var autor:String,
    @ColumnInfo(name = "paginas")
    var paginas:Int,
    @ColumnInfo(name="id_bibliotecaPadre")
    var id_bibliotecaPadre:Int
    ) {
        @PrimaryKey(autoGenerate=true)
        @ColumnInfo(name = "id_libro")
        var libroId:Int=0


    override fun toString(): String {

        return "Nombre= $nombre"
    }
}

