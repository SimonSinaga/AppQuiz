package com.example.simonfredysinaga.appquiz;

import android.app.DatePickerDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListAdapter;
import android.support.v7.app.AlertDialog;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;

public class Regis extends AppCompatActivity {

    Database database;
    ArrayList<HashMap<String, String>> dataList;
    EditText namareg, emailreg, passwordreg;
    Button bt_regis;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_regis);

        database = new Database(this);
        dataList = new ArrayList<HashMap<String, String>>();
        getData();

        namareg=(EditText)findViewById(R.id.nama_regis);
        emailreg=(EditText)findViewById(R.id.email_regis);
        passwordreg=(EditText)findViewById(R.id.password_regis);
        bt_regis=(Button)findViewById(R.id.bt_register);

        bt_regis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (namareg.getText().length()!=0 &&
                        emailreg.getText().length()!=0 &&
                        passwordreg.getText().length()!=0){
                    database.sisipData(namareg.getText().toString(),
                            emailreg.getText().toString(),
                            passwordreg.getText().toString());
                    getData();
                    Toast.makeText(Regis.this, "Data Tersimpan", Toast.LENGTH_SHORT).show();
                }else {
                    Toast.makeText(Regis.this, "Data Gagal Tersimpan, Silakan Coba Lagi", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }

    private void getData(){
        dataList = database.tampilData();
        if (dataList.size() != 0){                      //berapa size dari data
            ListAdapter adapter = new SimpleAdapter(Regis.this, dataList,
                    R.layout.activity_regis,
                    new String[]{
                            "kode_brg", "nama_brg", "jlh_brg", "harga_brg"},
                    new int[]{
                            R.id.nama_regis, R.id.email_regis,
                            R.id.password_regis
                    });
        }
    }
}
