package com.bca.mobileprogramming;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class UserDatabaseConnection extends SQLiteOpenHelper {
    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "UserDatabase";

    public UserDatabaseConnection(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    // Creating tables.
    @Override
    public void onCreate(SQLiteDatabase db) {
        String createQuery = "CREATE TABLE UserTable(id INTEGER PRIMARY KEY, name TEXT, address TEXT)";

        db.execSQL(createQuery);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + DATABASE_NAME);

        onCreate(db);
    }

    public void insertData(int id, String name, String address) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues contentValues = new ContentValues();

        contentValues.put("id", id);
        contentValues.put("name", name);
        contentValues.put("address", address);

        db.insert("UserTable", null, contentValues);

        db.close();
    }

    public Cursor selectData() {
        SQLiteDatabase db = this.getReadableDatabase();

        String query = "SELECT * FROM UserTable";

        Cursor cursor = db.rawQuery(query, null);

        return cursor;
    }

    public void updateData(String id, String name, String address) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues contentValues = new ContentValues();

        contentValues.put("name", name);
        contentValues.put("address", address);

        db.update("UserTable", contentValues, "id=?", new String[]{id});

        db.close();
    }

    public void deleteData(String id) {
        SQLiteDatabase db = this.getWritableDatabase();

        db.delete("UserTable", "id=?", new String[]{id});
    }
}
