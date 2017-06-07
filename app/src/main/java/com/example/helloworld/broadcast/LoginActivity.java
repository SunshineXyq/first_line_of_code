package com.example.helloworld.broadcast;

import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import com.example.helloworld.ChatActivity;
import com.example.helloworld.MainActivity;
import com.example.helloworld.R;

public class LoginActivity extends BaseActivity {

    private EditText et_account;
    private EditText et_password;
    private Button btn_login;
    private CheckBox check_box;
    private SharedPreferences pref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        et_account = (EditText) findViewById(R.id.et_account);
        et_password = (EditText) findViewById(R.id.et_password);
        check_box = (CheckBox) findViewById(R.id.check_box);
        btn_login = (Button) findViewById(R.id.btn_login);
        pref = PreferenceManager.getDefaultSharedPreferences(this);
        boolean is_remember = pref.getBoolean("is_remember", false);
        if (is_remember) {
            String account = pref.getString("account", "");
            String pwd = pref.getString("pwd", "");
            et_account.setText(account);
            et_password.setText(pwd);
            check_box.setChecked(true);
        }
        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String account = et_account.getText().toString();
                String password = et_password.getText().toString();
                if (account.equals("admin") && password.equals("123456")) {
                    SharedPreferences.Editor edit = pref.edit();
                    if (check_box.isChecked()) {
                        edit.putBoolean("is_remember",true);
                        edit.putString("account",account);
                        edit.putString("pwd",password);
                    } else {
                        edit.clear();
                    }
                    edit.apply();
                    Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                    startActivity(intent);
                    finish();
                } else {
                    Toast.makeText(LoginActivity.this, "账号或密码错误", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
