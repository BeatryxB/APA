package com.example.apa;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.apa.View.Home.Home;
import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity {

    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button SignIn = findViewById(R.id.SignIn);
        Button SignUp = findViewById(R.id.SignUp);
        SignIn.setOnClickListener(Signing);
        SignUp.setOnClickListener(Signup);
        mAuth = FirebaseAuth.getInstance();
        IfLogging();

    }

    private final View.OnClickListener Signing = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            View SignIn = findViewById(R.id.FragmentLogin);
            View SignUp = findViewById(R.id.FragmentSignup);
            if(SignIn.getVisibility()==View.VISIBLE)
            {
                SignIn.setVisibility(View.GONE);
            }
            else if(SignUp.getVisibility()==View.VISIBLE){
                SignUp.setVisibility(View.GONE);
                SignIn.setVisibility(View.VISIBLE);
            }
            else{
                SignIn.setVisibility(View.VISIBLE);
            }
        }
    };

    private final View.OnClickListener Signup = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            View SignIn = findViewById(R.id.FragmentLogin);
            View SignUp = findViewById(R.id.FragmentSignup);
            if(SignUp.getVisibility()==View.VISIBLE)
            {
                SignUp.setVisibility(View.GONE);
            }
            else if(SignIn.getVisibility()==View.VISIBLE){
                SignIn.setVisibility(View.GONE);
                SignUp.setVisibility(View.VISIBLE);
            }
            else{
                SignUp.setVisibility(View.VISIBLE);
            }
        }
    };

    private void IfLogging(){
        if (mAuth.getCurrentUser()!=null){
            Intent i = new Intent(getApplicationContext(), Home.class);
            i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
            getApplicationContext().startActivity(i);
        }
    }

}