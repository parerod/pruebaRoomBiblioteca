package com.example.pruebaroom.modelo.conexiones

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase
import com.example.pruebaroom.modelo.daos.InterfaceDaoBiblioteca
import com.example.pruebaroom.modelo.daos.InterfaceDaoLibro
import com.example.pruebaroom.modelo.entidades.Biblioteca
import com.example.pruebaroom.modelo.entidades.Libro

@Database(entities = [Libro::class, Biblioteca::class], version = 2)
abstract class AppDB : RoomDatabase() {
    abstract fun DaoBiblioteca(): InterfaceDaoBiblioteca
    abstract fun DaoLibro(): InterfaceDaoLibro

    companion object {
        private var INSTANCE: AppDB? = null
        fun getBaseDatos(context: Context): AppDB {
            if (INSTANCE == null) {
                INSTANCE = Room.databaseBuilder(
                    context.applicationContext,
                    AppDB::class.java,
                    "libroDB"
                ).allowMainThreadQueries()
                    .addMigrations(MIGRATION_1_2)
                    .build()
                //Con migracion hay que incrementar la version y añadirle que migracion
                /*INSTANCE = Room.databaseBuilder(context.getApplicationContext(),BaseDatos.class,
                    "DietaBD").addMigrations(MIGRATION1_2).allowMainThreadQueries().build();*/
            }
            return INSTANCE as AppDB
        }

        val MIGRATION_1_2: Migration = object : Migration(1,2) {
            override fun migrate(database: SupportSQLiteDatabase) {
                database.execSQL("ALTER TABLE biblioteca ADD COLUMN direccion TEXT")
            }
        }
    }






}
