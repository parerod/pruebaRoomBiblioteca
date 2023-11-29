package com.example.pruebaroom.modelo.daos

import androidx.room.*
import com.example.pruebaroom.modelo.entidades.Biblioteca
import com.example.pruebaroom.modelo.entidades.Libro


@Dao
interface InterfaceDaoLibro {

    @Insert
    fun addLibro(li: Libro)
    @Query("SELECT * FROM libro")
    fun getLibros():MutableList<Libro>
    @Query("SELECT * FROM libro WHERE id_bibliotecaPadre LIKE :id")
    fun getLibroByBiblioteca(id:Int):MutableList<Libro>
    @Update
    fun updateLibro(li : Libro)
    @Delete
    fun deleteLibro(li : Libro)

}