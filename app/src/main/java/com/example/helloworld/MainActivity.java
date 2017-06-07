package com.example.helloworld;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.helloworld.broadcast.BaseActivity;

import java.util.List;

public class MainActivity extends BaseActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button btn_offline = (Button) findViewById(R.id.btn_offline);
        btn_offline.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent("com.example.broadcast.OFFLINE");
                sendBroadcast(intent);
            }
        });
    }

    public void sendMessage(View view) {
//        EditText editText = (EditText) findViewById(R.id.et_message);
//        String message = editText.getText().toString().trim();
//        Intent intent = new Intent(this, DisplayMessageActivity.class);
//        intent.putExtra("message",message);
//        startActivity(intent);
        Uri location = Uri.parse("geo:0,0?q=1600+Amphitheatre+Parkway,+Mountain+View,+California");
        Intent intent = new Intent(Intent.ACTION_VIEW, location);
//        Intent chooser = Intent.createChooser(intent, "共享");
//        if (intent.resolveActivity(getPackageManager()) != null) {
//            startActivity(chooser);
//        }
        PackageManager packageManager = getPackageManager();
        List<ResolveInfo> activities = packageManager.queryIntentActivities(intent, 0);
        if (activities.size() > 0 ) {
            Log.i("MainActivity","大于零");
            startActivity(intent);
        }
        Log.i("MainActivity","小于零");
    }
}
