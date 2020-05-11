package com.silicon.hub.firepay;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;

import com.google.android.material.textfield.TextInputLayout;
import com.hbb20.CountryCodePicker;
import com.silicon.hub.firepay.Utils.PasswordUtils;

public class SignUpActivity extends AppCompatActivity {

    TextInputLayout textInputFirstName;
    TextInputLayout textInputLastName;
    TextInputLayout textInputEmail;
    TextInputLayout textInputPassword;
    CountryCodePicker countryCodePicker;
    TextInputLayout textInputCarrierNumber;

    Button signUp;

    String firstName;
    String lastName;
    String email;
    String passwordUnhashed;
    String passwordHashed;
    String country;
    String phoneNumber;


    FirePayRepository userRepository;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        textInputFirstName = findViewById(R.id.text_input_first_name);
        textInputLastName = findViewById(R.id.text_input_last_name);
        textInputEmail = findViewById(R.id.text_input_email);
        textInputPassword = findViewById(R.id.text_input_password);
        countryCodePicker = findViewById(R.id.ccp);
        textInputCarrierNumber = findViewById(R.id.text_input_carrierNumber);
        countryCodePicker.registerCarrierNumberEditText(textInputCarrierNumber.getEditText());

        userRepository = new FirePayRepository(this.getApplication());

        signUp = findViewById(R.id.button_signup);
        signUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (validateUserInfo()){
                 // if user info is not false then save it
                    userRepository.insert(
                            new User(firstName,
                                    lastName,
                                    country,
                                    phoneNumber,
                                    email,
                                    passwordUnhashed,
                                    passwordHashed)
                    );
                    Intent intent = new Intent(SignUpActivity.this, HomeActivity.class);
                    startActivity(intent);
                    finish();
                }
            }
        });


    }

    private boolean validateUserInfo() {
        boolean isUserInfoValid = true;

        fetchUserSignUpInfo();
        if (firstName.isEmpty()){
            textInputFirstName.setError("Field can't be empty");
            isUserInfoValid = false;
        }else if(firstName.length() > 15){
            textInputFirstName.setError("Firstname too long");
        }
        else{
            textInputFirstName.setError(null);
        }

        if (lastName.isEmpty()){
            textInputLastName.setError("Field can't be empty");
            isUserInfoValid = false;
        }else{
            textInputLastName.setError(null);
        }

        if (email.isEmpty()){
            textInputEmail.setError("Field can't be empty");
            isUserInfoValid = false;
        }else if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()){
            textInputEmail.setError("Please enter a valid email address");
            isUserInfoValid = false;
        }else{
            textInputEmail.setError(null);
        }

        if (passwordUnhashed.isEmpty()){
            textInputPassword.setError("Field can't be empty");
            isUserInfoValid = false;
        } else if(!PasswordUtils.PASSWORD_PATTERN.matcher(passwordUnhashed).matches()){
             textInputPassword.setError("Password should contain atleast an alphabet, a number and 6 characters");
            isUserInfoValid = false;
        } else{
            textInputPassword.setError(null);
        }

        if (!countryCodePicker.isValidFullNumber()){
            textInputCarrierNumber.setError("Please enter a valid number");
            isUserInfoValid = false;
        } else{
            textInputCarrierNumber.setError(null);
        }

        // if any of the input is empty or not a valid email or passwordUnhashed pattern then is isUserInfoValid should return false

        return isUserInfoValid;
    }

    private void fetchUserSignUpInfo(){
        firstName = textInputFirstName.getEditText().getText().toString().trim();
        lastName = textInputLastName.getEditText().getText().toString().trim();
        email = textInputEmail.getEditText().getText().toString().trim();
        passwordUnhashed = textInputPassword.getEditText().getText().toString();

        passwordHashed = PasswordUtils.getHash(passwordUnhashed);

        country = countryCodePicker.getSelectedCountryEnglishName();
        phoneNumber = countryCodePicker.getFullNumberWithPlus();
    }

}
