package com.example.pruebaroom.modelo.daos

import androidx.room.*
import com.example.pruebaroom.modelo.entidades.Biblioteca

@Dao
interface InterfaceDaoBiblioteca {

    @Insert
    fun addBiblioteca(bi : Biblioteca)
    @Query("SELECT * FROM biblioteca")
    fun getBibliotecas():MutableList<Biblioteca>
    @Query("SELECT * FROM biblioteca WHERE id_biblioteca IN (:idBiblios)")
    fun getBibliotecaListaId(idBiblios: MutableList<Int>):MutableList<Biblioteca>
    @Query("SELECT * FROM biblioteca WHERE nombre LIKE :nombre")
    fun getBibliotecaNombre(nombre: String):Biblioteca?
    @Update
    fun updateBiblioteca(bi : Biblioteca)
    @Delete
    fun deleteBiblioteca(bi : Biblioteca)
}