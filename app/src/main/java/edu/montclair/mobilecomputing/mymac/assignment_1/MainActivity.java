package edu.montclair.mobilecomputing.mymac.assignment_1;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Button mForgetPassword = (Button) findViewById(R.id.btn_forgetpassword_MA);
        mForgetPassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                forgetPasswordForm();
            }
        });

        Button mRegistrationForm = (Button) findViewById(R.id.btn_register_MA);
        mRegistrationForm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                registrationForm();
            }
        });

    }
    void forgetPasswordForm(){
        Intent gecis = new Intent(MainActivity.this, ForgetPassword.class);
        //gecis.putExtra("key", number);
        //gecis.putExtra("number", number);
        startActivity(gecis);


    }

    void registrationForm(){

        Intent gecis = new Intent(MainActivity.this, RegistrationPage.class);
        //gecis.putExtra("key", number);
        //gecis.putExtra("number", number);
        startActivity(gecis);

    }

}
