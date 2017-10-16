package com.example.hidarah42.belajarsharedprefrences;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    //Variabel Global
    private EditText ID,Pass;
    private Button Save,Info;
    private TextView Display;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Inisialisasi
        ID = (EditText)findViewById(R.id.etid);
        Pass = (EditText)findViewById(R.id.etpass);
        Display = (TextView)findViewById(R.id.tvdisplay);
        Save = (Button)findViewById(R.id.btn_save);
        Info = (Button)findViewById(R.id.btn_display);

        Save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                saveInfo();
            }
        });

        Info.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                display();
            }
        });
    }

    public void saveInfo(){
        SharedPreferences sharedPref= getSharedPreferences("Info", Context.MODE_PRIVATE);

        SharedPreferences.Editor editor = sharedPref.edit();
        editor.putString("Username",ID.getText().toString());
        editor.putString("Password",Pass.getText().toString());
        editor.apply();

        Toast.makeText(this, "Saved!", Toast.LENGTH_SHORT).show();
    }

    public void display(){
        SharedPreferences sharedPref= getSharedPreferences("Info", Context.MODE_PRIVATE);

        String Name = sharedPref.getString("Username","");
        String Pw = sharedPref.getString("Password","");
        Display.setText(Name+" "+Pw);
    }
}
