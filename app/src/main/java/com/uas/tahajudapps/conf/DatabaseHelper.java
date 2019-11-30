package com.uas.tahajudapps.conf;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import com.uas.tahajudapps.modal.User;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class DatabaseHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "user";
    private static final int DATABASE_VERSION = 1;
    private static final String CREATE_TABLE_STATUS = "CREATE TABLE IF NOT EXISTS c4_tblstatus (id_status INTEGER PRIMARY KEY AUTOINCREMENT, status TEXT);";
    private static final String CREATE_TABLE_USER = "CREATE TABLE IF NOT EXISTS c4_tbluser(id_user INTEGER PRIMARY KEY AUTOINCREMENT, nm_user TEXT, id_status INTEGER, FOREIGN KEY (id_status) REFERENCES c4_tblstatus (id_status))";
    private static final String DELETE_TABLE_USER = "DROP TABLE IF EXISTS c4_tbluser";
    private static final String DELETE_TABLE_STATUS = "DROP TABLE IF EXISTS c4_tblstatus";
    private static final String INSERT_STATUS = "INSERT INTO c4_tblstatus (status) VALUES ('Developer'), ('Dosen'), ('Asisten Praktikum')";
    private static final String INSERT_USER = "INSERT INTO c4_tbluser (nm_user, id_status) VALUES " +
            "('Muh. Ammarullah Ridho', '1')," +
            "('Kurnia Siwi Kinasih', '1')," +
            "('Ardito Wahyu Prakoso', '1'),"+
            "('Bapak Supriyono, M.Kom', '2'),"+
            "('Habibie Ismail', '3'),"+
            "('Munajatul Azizah', '3')";

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        System.out.println("Database Created");
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE_STATUS);
        db.execSQL(CREATE_TABLE_USER);
        db.execSQL(INSERT_STATUS);
        db.execSQL(INSERT_USER);
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newV) {
        db.execSQL(DELETE_TABLE_USER);
        db.execSQL(DELETE_TABLE_STATUS);
        onCreate(db);
        System.out.println("Table Dropped");
    }

    public List<User>readDeveloper() {
        List<User> arrayUser = new ArrayList<>();
        SQLiteDatabase database = this.getWritableDatabase();
        Cursor cursor = database.rawQuery("SELECT c4_tbluser.id_user, c4_tbluser.nm_user, c4_tblstatus.status FROM c4_tbluser, c4_tblstatus WHERE c4_tbluser.id_status = c4_tblstatus.id_status AND c4_tbluser.id_status = 1", null);
        if (cursor.moveToFirst()) {
            do {
                User user = new User(cursor.getInt(0), cursor.getString(1), cursor.getString(2));
                arrayUser.add(user);
            } while (cursor.moveToNext());
        }

        return arrayUser;
    }

    public List<User>readDosen() {
        List<User> arrayUser = new ArrayList<>();
        SQLiteDatabase database = this.getWritableDatabase();
        Cursor cursor = database.rawQuery("SELECT c4_tbluser.id_user, c4_tbluser.nm_user, c4_tblstatus.status FROM c4_tbluser, c4_tblstatus WHERE c4_tbluser.id_status = c4_tblstatus.id_status AND c4_tbluser.id_status = 2", null);
        if (cursor.moveToFirst()) {
            do {
                User user = new User(cursor.getInt(0), cursor.getString(1), cursor.getString(2));
                arrayUser.add(user);
            } while (cursor.moveToNext());
        }

        return arrayUser;
    }

    public List<User>readAslab() {
        List<User> arrayUser = new ArrayList<>();
        SQLiteDatabase database = this.getWritableDatabase();
        Cursor cursor = database.rawQuery("SELECT c4_tbluser.id_user, c4_tbluser.nm_user, c4_tblstatus.status FROM c4_tbluser, c4_tblstatus WHERE c4_tbluser.id_status = c4_tblstatus.id_status AND c4_tbluser.id_status = 3", null);
        if (cursor.moveToFirst()) {
            do {
                User user = new User(cursor.getInt(0), cursor.getString(1), cursor.getString(2));
                arrayUser.add(user);
            } while (cursor.moveToNext());
        }

        return arrayUser;
    }
}