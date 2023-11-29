package com.example.pruebaroom

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.pruebaroom.modelo.conexiones.AppDB
import com.example.pruebaroom.modelo.entidades.Biblioteca
import com.example.pruebaroom.modelo.entidades.Libro

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var casaDelLibro = Biblioteca("La casa del Libro","sevilla")
        var entreParques = Biblioteca("La de entre Parques","sevilla")

        var laLeyenda= Libro("La leyenda del hechicero","Taran Matharu",506,1)
        var elImperioFinal= Libro("El imperio Final","Brandon Sanderson",853,2)
        var elProblemaFinal= Libro("El problema Final","Arturo Perez Reverte",310,1)

        val conexion= AppDB.getBaseDatos(this)
        val daoBiblioteca=conexion.DaoBiblioteca()
        val daoLibro=conexion.DaoLibro()
        daoBiblioteca.addBiblioteca(casaDelLibro)
        daoBiblioteca.addBiblioteca(entreParques)
        daoLibro.addLibro(laLeyenda)
        daoLibro.addLibro(elImperioFinal)
        daoLibro.addLibro(elProblemaFinal)
        val lista: List<Biblioteca> = daoBiblioteca.getBibliotecas()

        val idBiblios : MutableList<Int> = mutableListOf(1,3)

        lista.forEach {
            val direc: String? = it.direccion
            if (direc != null) {
                Log.d("libroId",direc)
            }
        }

        val biblios = daoBiblioteca.getBibliotecaListaId(idBiblios)

        biblios.forEach {
            Log.d("bibli",it.nombre)
        }


    }
}