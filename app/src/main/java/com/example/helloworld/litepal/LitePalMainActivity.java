package com.example.helloworld.litepal;

import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.example.helloworld.R;

import org.litepal.crud.DataSupport;
import org.litepal.tablemanager.Connector;

import java.util.List;

public class LitePalMainActivity extends AppCompatActivity {

    private Button btn_create;
    private Button btn_insert;
    private Button btn_update;
    private Button btn_delete;
    private Button btn_query;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_database);
        btn_create = (Button) findViewById(R.id.btn_create);
        btn_insert = (Button) findViewById(R.id.btn_insert);
        btn_update = (Button) findViewById(R.id.btn_update);
        btn_delete = (Button) findViewById(R.id.btn_delete);
        btn_query = (Button) findViewById(R.id.btn_query);

        btn_create.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Connector.getDatabase();
            }
        });
        btn_insert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Book book = new Book();
                book.setAuthor("徐元强");
                book.setName("徐元强喜欢大美腿");
                book.setPage(100);
                book.setPress("xyq");
                book.setPrice(10000);
                book.save();
            }
        });
        btn_update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d("LitePalMainActivity","更新啦");
                Book book = new Book();
                book.setAuthor("徐元强");
                book.setName("徐元强喜欢苗条白妹子");
                book.setPage(200);
                book.setPress("xyq");
                book.setPrice(9999);
//                book.save();
//                book.setPrice(8888);
//                book.save();
                book.updateAll("name = ? and author = ?","徐元强喜欢白妹子","徐元强");
            }
        });
        btn_delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DataSupport.deleteAll(Book.class,"price = ?","10000");
            }
        });
        btn_query.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                List<Book> bookList = DataSupport.findAll(Book.class);
                for (Book book: bookList) {
                    Log.d("LitePalMainActivity",book.getAuthor());
                    Log.d("LitePalMainActivity",book.getName());
                    Log.d("LitePalMainActivity",book.getPrice()+"");
                    Log.d("LitePalMainActivity",book.getPage()+"");
                    Log.d("LitePalMainActivity",book.getPress());
                }
            }
        });
    }
}
