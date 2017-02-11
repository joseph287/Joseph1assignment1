package edu.montclair.mobilecomputing.mymac.assignment_1;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import edu.montclair.mobilecomputing.mymac.assignment_1.R;

public class ForgetPassword extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forget_password);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Button quit = (Button) findViewById(R.id.btn_back1);
        quit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        Button controlButton = (Button) findViewById(R.id.Forget_Password_Register);
        controlButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                control();
            }
        });


        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                Intent email = new Intent(Intent.ACTION_SEND);
                email.putExtra(Intent.EXTRA_EMAIL, new String[]{"joseph287@gmail.com"});
                email.putExtra(Intent.EXTRA_SUBJECT, "I need more information" );
                email.putExtra(Intent.EXTRA_TEXT, "");
                email.setType("message/rfc822");
                startActivity(Intent.createChooser(email, "Choose an Email client :"));

            }
        });


    }

void control(){

    EditText d2;
    d2 = (EditText)findViewById(R.id.Forget_Password_Email);


    if (!isEditTextContainEmail(d2)){
     Toast.makeText(this.getBaseContext(),"E-Mail Address is wrong!", Toast.LENGTH_LONG).show();
      return;}


    AlertDialog.Builder builder1 = new AlertDialog.Builder(ForgetPassword.this);
    builder1.setCancelable(true);
    builder1.setTitle("Thank you");
    builder1.setMessage("New Password sent to your e-mail");
    builder1.setPositiveButton("Dismiss",
            new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog,
                                    int which) {



                }
            });
    builder1.setNegativeButton("",
            new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog,
                                    int which) {

                    dialog.dismiss();


                }
            });
    AlertDialog alert1 = builder1.create();
    alert1.show();

    return;
}


    public static boolean isEditTextContainEmail(EditText argEditText) {

        try {
            Pattern pattern = Pattern.compile("^[_A-Za-z0-9-]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");
            Matcher matcher = pattern.matcher(argEditText.getText().toString().trim());
            return matcher.matches();
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

}
