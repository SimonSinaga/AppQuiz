package com.example.simonfredysinaga.appquiz;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

public class home extends AppCompatActivity implements AdapterView.OnItemSelectedListener{

    String[] ddkategori = {"Pemograman", "Pengetahuan Umum"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        Spinner spinner = (Spinner)findViewById(R.id.sp_kategori);

        ArrayAdapter<String> aa = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, ddkategori);

        aa.setDropDownViewResource(android.R.layout.simple_spinner_item);

        spinner.setAdapter(aa);
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        Toast.makeText(getApplicationContext(), "Pilih: "+ddkategori[position], Toast.LENGTH_LONG).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
