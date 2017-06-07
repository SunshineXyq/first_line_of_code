package com.example.helloworld.savedata;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.example.helloworld.R;

public class MyDatabaseActivity extends AppCompatActivity {

    private Button btn_create;
    private Button btn_insert;
    private Button btn_update;
    private Button btn_delete;
    private Button btn_query;
    private MyDatabaseHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_database);
        btn_create = (Button) findViewById(R.id.btn_create);
        btn_insert = (Button) findViewById(R.id.btn_insert);
        btn_update = (Button) findViewById(R.id.btn_update);
        btn_delete = (Button) findViewById(R.id.btn_delete);
        btn_query = (Button) findViewById(R.id.btn_query);
        dbHelper = new MyDatabaseHelper(this, "BookStore.db", null, 2);
        btn_create.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SQLiteDatabase db = dbHelper.getWritableDatabase();
            }
        });
        btn_insert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SQLiteDatabase db = dbHelper.getWritableDatabase();
                ContentValues values = new ContentValues();
                values.put("name","徐元强是大帅哥");
                values.put("author","徐元强");
                values.put("price","88万");
                values.put("pages","88");
                db.insert("Book",null,values);
                values.clear();
                values.put("name","大帅哥是徐元强");
                values.put("author","徐元强");
                values.put("price","188万");
                values.put("pages","188");
                db.insert("Book",null,values);
            }
        });
        btn_update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SQLiteDatabase db = dbHelper.getWritableDatabase();
                ContentValues values = new ContentValues();
                values.put("price","288w");
                db.update("Book",values,"name = ?",new String[]{"徐元强是大帅哥"});
            }
        });
        btn_delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SQLiteDatabase db = dbHelper.getWritableDatabase();
                db.delete("Book","price = ?",new String[]{"188万"});
            }
        });
        btn_query.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SQLiteDatabase db = dbHelper.getWritableDatabase();
                Cursor cursor = db.query("Book", null, null, null, null, null, null);
                if (cursor.moveToFirst()) {
                    do {
                        String name = cursor.getString(cursor.getColumnIndex("name"));
                        String author = cursor.getString(cursor.getColumnIndex("author"));
                        String pages = cursor.getString(cursor.getColumnIndex("pages"));
                        String price = cursor.getString(cursor.getColumnIndex("price"));
                        Log.d("MyDatabaseActivity", name);
                        Log.d("MyDatabaseActivity", author);
                        Log.d("MyDatabaseActivity", pages);
                        Log.d("MyDatabaseActivity", price);
                    } while (cursor.moveToNext());
                }
            }
        });
    }
}
