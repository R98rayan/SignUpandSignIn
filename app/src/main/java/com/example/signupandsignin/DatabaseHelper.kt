package com.example.signupandsignin

import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class DatabaseHelper(context: Context): SQLiteOpenHelper(context,"accountsFixedAgain.db", null, 2) {
    private val sqLiteDatabase: SQLiteDatabase = writableDatabase

    override fun onCreate(db: SQLiteDatabase?) {
        db?.execSQL("create table accounts (pk INTEGER PRIMARY KEY AUTOINCREMENT, Name text, Phone text, Email text, Password text)")
    }

    override fun onUpgrade(db: SQLiteDatabase?, p1: Int, p2: Int) {
        // This removes the table if a new version is detected
        db!!.execSQL("DROP TABLE IF EXISTS accounts")
        onCreate(db)
    }

    fun saveData(account: Account){
        val contentValues = ContentValues()
        contentValues.put("Name", account.name)
        contentValues.put("Phone", account.phone)
        contentValues.put("Email", account.email)
        contentValues.put("Password", account.password)
        sqLiteDatabase.insert("accounts", null, contentValues)
    }

    fun getData(): ArrayList<Account>{
        val accounts = arrayListOf<Account>()

        // Read all data using cursor
        val cursor: Cursor = sqLiteDatabase.rawQuery("SELECT * FROM accounts", null)

        if(cursor.count < 1){  // Handle empty table
            println("No Data Found")
        }else{
            while(cursor.moveToNext()){  // Iterate through table and populate people Array List
                val pk = cursor.getInt(0)  // The integer value refers to the column
                val name = cursor.getString(1)
                val phone = cursor.getString(2)
                val email = cursor.getString(3)
                val password = cursor.getString(4)
                accounts.add(Account(pk, name, phone, email, password))
            }
        }
        return accounts
    }

    fun getOneDataByEmail(email: String): Account{
        val accounts = arrayListOf<Account>()

        // Read all data using cursor
        val cursor: Cursor = sqLiteDatabase.rawQuery("SELECT * FROM accounts WHERE Email = '$email'", null)

        if(cursor.count < 1){  // Handle empty table
            println("No Data Found")
        }else{
            while(cursor.moveToNext()){  // Iterate through table and populate people Array List
                val pk = cursor.getInt(0)  // The integer value refers to the column
                val name = cursor.getString(1)
                val phone = cursor.getString(2)
                val email = cursor.getString(3)
                val password = cursor.getString(4)
                return Account(pk, name, phone, email, password)
            }
        }
        return Account(-1, "", "", "", "")
    }
}