package com.example.a16004118.c347msarevision.Helper;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.example.a16004118.c347msarevision.Object.DBItem;

import java.util.ArrayList;

public class DBHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "revision.db";
    private static final int DATABASE_VERSION = 1;

    private static final String TABLE_DBITEM = "DBItem";
    private static final String COLUMN_ID = "_id";
    private static final String COLUMN_NAME = "name";
    private static final String COLUMN_STAR = "star";

    public DBHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        String createTableSql = "CREATE TABLE " + TABLE_DBITEM + "("
                + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                + COLUMN_NAME + " TEXT,"
                + COLUMN_STAR + " INTEGER)";
        db.execSQL(createTableSql);
        Log.i("info", "created tables");


        for (int i = 1; i < 6; i++) {
            ContentValues values = new ContentValues();
            values.put(COLUMN_NAME, "Name " + i);
            values.put(COLUMN_STAR, i);
            db.insert(TABLE_DBITEM, null, values);
        }
        Log.i("Info", "record inserted");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        //delete table and user records
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_DBITEM);
        onCreate(db);

        //better way to upgrade db
        //keep original user data
        db.execSQL("ALTER TABLE " + TABLE_DBITEM + " ADD COLUMN score TEXT ");

    }

    public void insertDBItem(String name, int star) {

        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COLUMN_NAME, name);
        values.put(COLUMN_STAR, star);
        db.insert(TABLE_DBITEM, null, values);
        db.close();

    }

    public ArrayList<DBItem> getAllDBItem() {

        ArrayList<DBItem> dbItems = new ArrayList<>();
        String selectQuery = "SELECT " + COLUMN_ID + ", "
                + COLUMN_NAME + ", "
                + COLUMN_STAR
                + " FROM " + TABLE_DBITEM;

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        if (cursor.moveToFirst()){
            do{
                int id = cursor.getInt(0);
                String name = cursor.getString(1);
                int star = cursor.getInt(2);
                DBItem obj = new DBItem(id, name, star);
                dbItems.add(obj);
            }while (cursor.moveToNext());
        }
        cursor.close();
        db.close();
        Log.e("DBHelper", "getAllDBItem: " + dbItems.size() );
        return  dbItems;
    }

    public int updateDBItem(DBItem data) {
//        Log.i("DBHelper", "id: " + id);
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COLUMN_NAME, data.getName());
        values.put(COLUMN_STAR, data.getStar());
        String condition = COLUMN_ID + "= ?";
        String[] args = {String.valueOf(data.getId())};
        int result = db.update(TABLE_DBITEM, values, condition, args);

        if (result < 1) {
            Log.i("DBHelper", "Update failed");
            Log.i("DBHelper", result + "");
        } else {
            Log.i("DBHelper", "Update successful");
            Log.i("DBHelper", result + "");
        }

        db.close();
        return result;
    }


    public int deleteDBItem(int id) {
        SQLiteDatabase db = this.getWritableDatabase();
        String condition = COLUMN_ID + "= ?";
        String[] args = {String.valueOf(id)};
        int result = db.delete(TABLE_DBITEM, condition, args);
        if (result < 1) {
            Log.d("DBHelper", "Delete failed");
        } else {
            Log.i("DBHelper", "Delete successful");
            Log.i("DBHelper", result + "");
        }
        db.close();
        return result;
    }

    public ArrayList<DBItem> getAllDBItembyStars(int stars) {
        ArrayList<DBItem> songs = new ArrayList<DBItem>();

        SQLiteDatabase db = this.getReadableDatabase();
        String[] columns = {COLUMN_NAME, COLUMN_STAR, COLUMN_ID};
        String condition = COLUMN_STAR + " =?";
        String[] args = {String.valueOf(stars)};
        Cursor cursor = db.query(TABLE_DBITEM, columns, condition, args,
                null, null, null, null);

        if (cursor.moveToFirst()) {
            do {
                String name = cursor.getString(0);
                int star = cursor.getInt(1);
                int id = cursor.getInt(2);
                DBItem dbItem = new DBItem(id, name, star);
                songs.add(dbItem);
            } while (cursor.moveToNext());
        }
        cursor.close();
        db.close();
        return songs;
    }
}
