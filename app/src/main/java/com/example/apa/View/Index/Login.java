package com.example.apa.View.Index;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.apa.MainActivity;
import com.example.apa.R;
import com.example.apa.View.Home.Home;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import java.util.Objects;
import java.util.concurrent.Executor;

public class Login extends Fragment implements View.OnClickListener {

    private EditText email;
    private EditText password;
    private TextView error;
    private Context context;
    private FirebaseAuth mAuth = FirebaseAuth.getInstance();
    private Button signIn;

    public Login() {
    }

    public static Fragment newInstance() {
        Login fragment = new Login();
        return fragment;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View MyView = inflater.inflate(R.layout.fragment_login, container, false);
        email = MyView.findViewById(R.id.Mail);
        password = MyView.findViewById(R.id.Password);
        signIn = (Button) MyView.findViewById(R.id.SignInReq);
        error = MyView.findViewById(R.id.IfErrorSignin);
        context = getActivity().getApplicationContext();
        signIn.setOnClickListener(this::onClick);
        return MyView;
    }

    @Override
    public void onClick(View v) {
        mAuth.signInWithEmailAndPassword(email.getText().toString(), password.getText().toString())
                .addOnCompleteListener(requireActivity(), new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information
                            FirebaseUser user = mAuth.getCurrentUser();
                            Intent SignInOkay = new Intent(v.getContext(), Home.class);
                            SignInOkay.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
                            context.startActivity(SignInOkay);
                        } else {
                            // If sign in fails, display a message to the user.
                            error.setVisibility(View.VISIBLE);
                            error.setText(task.getException().getMessage());
                        }
                    }
                });
    }
}