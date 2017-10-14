package com.example.hidarah42.gugelmapsarraylist;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Toast;

public class Detail extends AppCompatActivity {

    // Variabel Global
    private String Data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //Ambil Data
        Intent i = this.getIntent();
        Data = i.getExtras().getString("Data");

        setTitle(Data);
        Toast.makeText(this, Data, Toast.LENGTH_SHORT).show();
    }

}
