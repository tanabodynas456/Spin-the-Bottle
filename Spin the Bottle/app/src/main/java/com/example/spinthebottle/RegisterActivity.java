package com.example.spinthebottle;

import android.content.ContentValues;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class RegisterActivity extends AppCompatActivity {
    EditText username,password,email,dob;
    RadioGroup gender;
    Button register,cancel;
    DatabaseHelper databaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        username = findViewById(R.id.username);
        password = findViewById(R.id.password);
        email = findViewById(R.id.email);
        dob = findViewById(R.id.dob);
        gender = findViewById(R.id.gender);
        register = findViewById(R.id.register);
        cancel = findViewById(R.id.cancel);

        databaseHelper = new DatabaseHelper(this);

        register.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                String usernameValue = username.getText().toString();
                String passwordValue = password.getText().toString();
                String emailValue = email.getText().toString();
                String dobValue = dob.getText().toString();
                RadioButton checkedBtn = findViewById(gender.getCheckedRadioButtonId());
                String genderValue = checkedBtn.getText().toString();


                if (usernameValue.length() > 1){
                    ContentValues contentValues = new ContentValues();
                    contentValues.put("username",usernameValue);
                    contentValues.put("password",passwordValue);
                    contentValues.put("email",emailValue);
                    contentValues.put("dob",dobValue);
                    contentValues.put("gender",genderValue);

                    databaseHelper.insertUser(contentValues);
                    Toast.makeText(RegisterActivity.this, "User Registered!", Toast.LENGTH_SHORT).show();
                }
                else {
                    Toast.makeText(RegisterActivity.this, "Input your Value!!!", Toast.LENGTH_SHORT).show();
                }


            }
        });


    }
}