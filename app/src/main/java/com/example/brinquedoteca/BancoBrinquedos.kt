package com.example.brinquedoteca

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class BancoBrinquedos(context: Context) : SQLiteOpenHelper(context, NomeDoBanco, null, versaoDoBanco) {

    override fun onCreate(db: SQLiteDatabase) {
        val SQL_criacao =
            "CREATE TABLE brinquedo (" +
                    "codigo INTEGER PRIMARY KEY," +
                    "modelo TEXT," +
                    "idade INTEGER," +
                    "idade FLOAT, " +
                    "peso FLOAT, " +
                    "volume FLOAT, "+
                    "custo FLOAT)"

        db.execSQL(SQL_criacao)
    }

    override fun onUpgrade(db: SQLiteDatabase, versaoAntiga: Int, novaVersao: Int){
        val SQL_exclusao = "DROP TABLE IF EXISTS brinquedo"
        db.execSQL(SQL_exclusao)
        onCreate(db)
    }

    override fun onDowngrade(db:SQLiteDatabase, versaoAntiga: Int, novaVersao: Int){
        onUpgrade(db, versaoAntiga, novaVersao)
    }

    companion object {
        const val versaoDoBanco = 1
        const val NomeDoBanco = "brinquedosiftm.db"
    }

}