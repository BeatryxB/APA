package com.example.apa.View.Home.ui.dashboard;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.apa.R;



public class AddActivityToPatient extends Fragment implements View.OnClickListener {

    private EditText patient, activity;
    private Button Add;
    private TextView error;

    public AddActivityToPatient() {
        // Required empty public constructor
    }

    public static AddActivityToPatient newInstance() {
        AddActivityToPatient fragment = new AddActivityToPatient();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View mView = inflater.inflate(R.layout.fragment_add_activity_to_patient, container, false);
        patient = mView.findViewById(R.id.TitleActivityToPatient);
        activity = mView.findViewById(R.id.ActivityToPatient);
        error = mView.findViewById(R.id.IfErrorAddActivityToPatient);
        Add = mView.findViewById(R.id.AddActivityButton);
        Add.setOnClickListener(this::onClick);
        return mView;
    }

    @Override
    public void onClick(View v) {
        if(checkIfFill()){

        }else{
            error.setText("You need to fill all field");
        }
    }

    private boolean checkIfFill(){
        return !patient.getText().toString().equals("") && !activity.getText().toString().equals("");
    }
}