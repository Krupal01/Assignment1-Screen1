package com.example.myapplication;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.NumberPicker;

import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity {

    String emailPattern = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@" + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
    String MobilePattern = "[0-9]{10}";
    String msg;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportActionBar().setDisplayShowCustomEnabled(true);
        getSupportActionBar().setCustomView(R.layout.actionbar);

        NumberPicker numberPicker = findViewById(R.id.Age);
        numberPicker.setMinValue(0);
        numberPicker.setMaxValue(100);
        numberPicker.setWrapSelectorWheel(true);

        EditText Username = findViewById(R.id.Username);
        EditText Mobile = findViewById(R.id.Mobile);
        EditText Email = findViewById(R.id.Email);
        EditText Password = findViewById(R.id.password);
        Button next = findViewById(R.id.Next);

        next.setOnClickListener(v -> {
            msg = "";
            if(Username.getText().toString().isEmpty()){
                msg+="not valid Username \n";
            }
            if (Mobile.getText().toString().isEmpty() || !(Mobile.getText().toString().matches(MobilePattern)) ){
                msg+="not valid Mobile \n";
            }
            if (Email.getText().toString().isEmpty() || !(Email.getText().toString().matches(emailPattern)) ){
                msg+="not valid Email \n";
            }
            if (!(Password.getText().toString().length()>=6)){
                msg+="not valid Password \n";
            }

            if (!msg.isEmpty()){
            AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
            builder.setTitle("Error");
            builder.setMessage(msg);
            AlertDialog alertDialog = builder.create();
            alertDialog.show();
            }

        });





    }
}
