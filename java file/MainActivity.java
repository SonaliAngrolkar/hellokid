package com.example.hellokids;
//LOGIN AND REGISTRATION BACKEND PART

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    Button loginbtn;
    TextView signup, msg;
    EditText id, pass;
    LinearLayout first, second;
    TextView signin, msg1;
    EditText loginid, password, mobilenumber;
    Button register;
    SQLiteDatabase db;
    Cursor c;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //FIND OUT ID
        loginbtn = findViewById(R.id.loginbtn);
        signup = findViewById(R.id.signup);
        signin = findViewById(R.id.signin);
        id = findViewById(R.id.loginid);
        pass = findViewById(R.id.password);
        msg = findViewById(R.id.msg);
        first = findViewById(R.id.first);
        second = findViewById(R.id.second);
        msg1 = findViewById(R.id.msg1);
        loginid = findViewById(R.id.loginid1);
        password = findViewById(R.id.password1);
        mobilenumber = findViewById(R.id.mobilenumber);
        register = findViewById(R.id.registerbtn);

        //CREATE DATABASE KID1
        db = openOrCreateDatabase("kid1", Context.MODE_PRIVATE, null);
        //CREATE TABLE KID1
        db.execSQL("CREATE TABLE IF NOT EXISTS kid1(kidId INTEGER,kidpass INTEGER,kidmob INTEGER);");

        //LOGIN
        loginbtn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                //CHECK ID AND PASSWORD
                c = db.rawQuery("SELECT * FROM kid1 WHERE kidId  ='" + id.getText() + "' AND kidpass='" + pass.getText() + "'", null);
                if (c.getCount() == 0) {
                    msg.setText("No records found");

                } else {
                    Intent i = new Intent(MainActivity.this, MainActivity2.class);
                    startActivity(i);
                }
            }
        });

        //GO TO REGISTRATION PAGE PAGE
        signup.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                first.setVisibility(v.INVISIBLE);
                second.setVisibility(v.VISIBLE);
            }
        });
        //GO TO LOGIN PAGE
        signin.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                first.setVisibility(v.VISIBLE);
                second.setVisibility(v.INVISIBLE);

            }
        });
        //REGISTER
        register.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                String regex = "(0/9)?[7-9][0-9]{9}";
                String mob = mobilenumber.getText().toString();
                //CHECL EDITBOX IS NOT EMPTY
                if (loginid.getText().toString().trim().length() == 0 && password.getText().toString().trim().length() == 0 && mobilenumber.getText().toString().trim().length() == 0) {
                    msg1.setText("Fill All Details !");
                }
                //VALIDATE MOBILE NUMBER
                else if (mob.matches(regex)) {
                    //INSERT DATA INTO DATABASE
                    db.execSQL("INSERT INTO kid1(kidId,kidpass,kidmob)VALUES('" + loginid.getText() + "','" + password.getText() + "','" + mobilenumber.getText() + "');");
                    msg1.setText("Register Success !");
                } else {
                    msg1.setText("Invalid Mobile Number !");
                }
            }
        });

    }
}