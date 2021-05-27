package com.example.apa.View.Home.ui.dashboard;

import android.app.Activity;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.apa.Controller.Home.FirestoreActivity;
import com.example.apa.Model.Activity.ActivitySport;
import com.example.apa.R;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link AddActivity#newInstance} factory method to
 * create an instance of this fragment.
 */
public class AddActivity extends Fragment implements View.OnClickListener{

    private EditText Titre, Duration, Description;
    private TextView Error;
    private Button AddActivity;

    public AddActivity() {
        // Required empty public constructor
    }

    public static AddActivity newInstance() {
        AddActivity fragment = new AddActivity();
        return fragment;
    }



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View mView = inflater.inflate(R.layout.fragment_add_activity, container, false);
        Titre = mView.findViewById(R.id.TitleActivity);
        Duration = mView.findViewById(R.id.DurationActivity);
        Description = mView.findViewById(R.id.DescriptionActivity);
        AddActivity = mView.findViewById(R.id.AddActivityButton);
        Error = mView.findViewById(R.id.IfErrorAddActivity);
        AddActivity.setOnClickListener(this::onClick);
        return mView;
    }

    @Override
    public void onClick(View v) {
        if(checkiffill()){
            FirebaseFirestore db = FirebaseFirestore.getInstance();
            CollectionReference dbCourses = db.collection("Activity");

            // adding our data to our courses object class.
            ActivitySport courses = new ActivitySport(Titre.getText().toString(),Duration.getText().toString(), Description.getText().toString());

            // below method is use to add data to Firebase Firestore.
            dbCourses.add(courses).addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
                @Override
                public void onSuccess(DocumentReference documentReference) {
                    // after the data addition is successful
                    // we are displaying a success toast message.
                    Error.setVisibility(View.VISIBLE);
                    Error.setText("your activity is added");
                }
            }).addOnFailureListener(new OnFailureListener() {
                @Override
                public void onFailure(@NonNull Exception e) {
                    // this method is called when the data addition process is failed.
                    // displaying a toast message when data addition is failed.
                    Error.setText(e.getMessage());
                }
            });
        }else{
            Error.setText("Require all Field complete");
        }
    }

    private boolean checkiffill(){
        return !Titre.getText().toString().equals("") && !Duration.getText().toString().equals("") && !Description.getText().toString().equals("");
    }
}