package com.example.simonfredysinaga.appquiz;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

public class user extends AppCompatActivity {

    EditText isinama, isiemail, isiusername, isipassword;
    Button btndaftar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user);

        isinama = (EditText)findViewById(R.id.isi_nama);
        isiemail = (EditText)findViewById(R.id.isi_email);
        isiusername = (EditText)findViewById(R.id.isi_username);
        isipassword = (EditText)findViewById(R.id.isi_password);
        btndaftar = (Button)findViewById(R.id.bt_daftar);
    }
}
