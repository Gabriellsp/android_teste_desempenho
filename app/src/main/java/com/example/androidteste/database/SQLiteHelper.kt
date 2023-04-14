package com.example.androidteste.database

import android.annotation.SuppressLint
import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import com.example.androidteste.models.CharacterThumbnail
import com.example.androidteste.models.MarvelCharacter

class SQLiteHelper(context: Context) :
    SQLiteOpenHelper(context, DATABASE_NAME, null, DATABASE_VERSION){

    companion object{
        private const val DATABASE_VERSION = 1
        private const val DATABASE_NAME = "tcc.db"

    }

    override fun onCreate(db: SQLiteDatabase?) {
        val createMarvelCharacterTable = "CREATE TABLE marvelCharacter(id INTEGER, name TEXT, description TEXT, thumbnailUrl TEXT);"
        db!!.execSQL(createMarvelCharacterTable)
    }

    override fun onUpgrade(db: SQLiteDatabase?, p1: Int, p2: Int) {
        db!!.execSQL("DROP TABLE IF EXISTS marvelCharacter")
        onCreate(db)
    }

    fun insertMarvelCharacter(char: MarvelCharacter): Long{
        val db = this.writableDatabase

        val contentValues = ContentValues()
        contentValues.put("id", char.id)
        contentValues.put("name", char.name)
        contentValues.put("description", char.description)
        contentValues.put("thumbnailUrl", char.thumbnail!!.path+"."+char.thumbnail!!.extension)

        val success = db.insert("marvelCharacter", null, contentValues)
        db.close()
        return success
    }

    @SuppressLint("Range")
    fun getAllChars(): ArrayList<MarvelCharacter>{
        val charsList: ArrayList<MarvelCharacter> = ArrayList()
        val selectQuery = "SELECT * FROM marvelCharacter"
        val db = this.readableDatabase
        val cursor: Cursor?
        try {
            cursor = db.rawQuery(selectQuery, null)
        }catch (e: Exception){
            e.printStackTrace()
            db.execSQL(selectQuery)
            return ArrayList()
        }
        var id: Int
        var name: String
        var description: String
        var thumbnailUrl: String

        if(cursor.moveToFirst()){
            do {
                id = cursor.getInt(cursor.getColumnIndex("id"))
                name = cursor.getString(cursor.getColumnIndex("name"))
                description = cursor.getString(cursor.getColumnIndex("description"))
                thumbnailUrl = cursor.getString(cursor.getColumnIndex("thumbnailUrl"))
                val char = MarvelCharacter(id = id.toLong(),name= name, description = description, thumbnail = CharacterThumbnail(path=thumbnailUrl, extension = ".jpeg"))
                charsList.add(char)
            }while(cursor.moveToNext())
        }
        return  charsList
    }

}
