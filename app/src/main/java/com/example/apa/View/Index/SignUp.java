package com.example.apa.View.Index;

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

import com.example.apa.R;
import com.example.apa.View.Home.Home;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.UserProfileChangeRequest;

public class SignUp extends Fragment implements View.OnClickListener {

    private EditText FirstName;
    private EditText LastName;
    private EditText Password1;
    private EditText Password2;
    private EditText Email;
    private TextView error;
    private FirebaseAuth mAuth = FirebaseAuth.getInstance();
    private Context context;
    private Button signup;

    public SignUp() {
        // Required empty public constructor
    }

    public static Fragment newInstance() {
        SignUp fragment = new SignUp();
        return fragment;
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
            View myView = inflater.inflate(R.layout.fragment_sign_up, container, false);
            FirstName = myView.findViewById(R.id.FNEdit);
            LastName = myView.findViewById(R.id.LNEdit);
            Password1 = myView.findViewById(R.id.PasswordEdit1);
            Password2 = myView.findViewById(R.id.PasswordEdit2);
            Email = myView.findViewById(R.id.MailEdit);
            context = getActivity().getApplicationContext();
            error = myView.findViewById(R.id.ErrorSignUp);
            signup = (Button) myView.findViewById(R.id.SignUpButton);
            signup.setOnClickListener(this::onClick);
        return myView;
    }

    @Override
    public void onClick(View v) {
        if(generalCheck()){
            if(passwordCheck()){
                mAuth.createUserWithEmailAndPassword(Email.getText().toString(), Password1.getText().toString())
                        .addOnCompleteListener(getActivity(), new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if (task.isSuccessful()) {
                                    // Sign in success, update UI with the signed-in user's information
                                    FirebaseUser user = mAuth.getCurrentUser();
                                    UserProfileChangeRequest profileChangeRequest = new UserProfileChangeRequest.Builder().setDisplayName(FirstName.getText().toString() + " " + LastName.getText().toString()).build();
                                    user.updateProfile(profileChangeRequest);
                                    Intent SignUpOkay = new Intent(v.getContext(), Home.class);
                                    SignUpOkay.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                                    context.startActivity(SignUpOkay);
                                } else {
                                    // If sign in fails, display a message to the user.
                                    String s = String.valueOf(task.getException().getMessage());
                                    error.setText(s);
                                }
                            }
                        });
            }
            else{
                error.setText("Password are differents");
            }
        }
        else{
            error.setText("One field is not set");
        }
    }

    private boolean generalCheck(){
        return !FirstName.getText().toString().equals("") && !LastName.getText().toString().equals("") && !Email.getText().toString().equals("") && !Password1.getText().toString().equals("") && !Password2.getText().toString().equals("");
    }

    private boolean passwordCheck(){
        return Password1.getText().toString().equals(Password2.getText().toString());
    }
}