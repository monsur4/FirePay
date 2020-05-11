package com.silicon.hub.firepay;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.textfield.TextInputLayout;
import com.silicon.hub.firepay.Utils.PasswordUtils;
import com.silicon.hub.firepay.Utils.Session;


public class LoginActivity extends AppCompatActivity {
    Button login;
    TextInputLayout emailTextInputLayout;
    TextInputLayout passwordTextInputLayout;
    TextView signUp;

    FirePayRepository userRepository;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        login = findViewById(R.id.button_login);
        emailTextInputLayout = findViewById(R.id.text_input_email_login);
        passwordTextInputLayout = findViewById(R.id.text_input_password_login);
        signUp = findViewById(R.id.textview_signup_from_login);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                login();
            }
        });

        signUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LoginActivity.this, SignUpActivity.class);
                startActivity(intent);
            }
        });

        userRepository = new FirePayRepository(this.getApplication());
    }


    public void login(){
        String emailString = emailTextInputLayout.getEditText().getText().toString();
        String passwordString = passwordTextInputLayout.getEditText().getText().toString();
        String passwordHashed = PasswordUtils.getHash(passwordString);
        // check database for email and passwordUnhashed

        if(userRepository.checkLoginCredentials(emailString, passwordHashed) != null){
            Session session = new Session(this);
            session.setUserEmail(emailString);
            session.setLoggedInStatus(true);
            Intent intent = new Intent(LoginActivity.this, HomeActivity.class);
            startActivity(intent);
            finish();
        }else{
            Toast.makeText(this, "Wrong email or password", Toast.LENGTH_LONG).show();
        }


    }
}
