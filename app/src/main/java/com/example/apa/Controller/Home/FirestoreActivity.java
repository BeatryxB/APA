package com.example.apa.Controller.Home;

import android.app.Activity;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.apa.R;
import com.example.apa.Model.Activity.ActivitySport;
import com.example.apa.View.Home.ui.home.Adapter.SportAdapter;
import com.example.apa.View.Home.ui.home.HomeFragment;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.List;

public class FirestoreActivity {

    private TextView tv;
    Activity ctx;
    HomeFragment context;

    public FirestoreActivity(Activity ctx, HomeFragment sc) {
        this.ctx = ctx;
        context = sc;
    }


    public void loadActivity(){

        // creating our new array list
        ArrayList<ActivitySport> ActivitySportList = new ArrayList<>();
        RecyclerView SportRv;
        SportRv = (RecyclerView) ctx.findViewById(R.id.ActivitySportID);
        SportRv.setLayoutManager(new LinearLayoutManager(context.getContext()));

        // adding our array list to our recycler view adapter class.
        SportAdapter sportAdapter= new SportAdapter(ActivitySportList, context.getContext());

        // setting adapter to our recycler view.
        SportRv.setAdapter(sportAdapter);

        FirebaseFirestore db = FirebaseFirestore.getInstance();
        db.collection("Activity").get()
                .addOnSuccessListener(new OnSuccessListener<QuerySnapshot>() {
                    @Override
                    public void onSuccess(QuerySnapshot queryDocumentSnapshots) {
                        // after getting the data we are calling on success method
                        // and inside this method we are checking if the received
                        // query snapshot is empty or not.
                        if (!queryDocumentSnapshots.isEmpty()) {
                            // if the snapshot is not empty we are
                            // hiding our progress bar and adding
                            // our data in a list.
                            List<DocumentSnapshot> list = queryDocumentSnapshots.getDocuments();
                            for (DocumentSnapshot d : list) {
                                // after getting this list we are passing
                                // that list to our object class.
                                ActivitySport c = d.toObject(ActivitySport.class);

                                // and we will pass this object class
                                // inside our arraylist which we have
                                // created for recycler view.
                                ActivitySportList.add(c);
                                System.out.println(sportAdapter.getItemCount());
                            }
                            // after adding the data to recycler view.
                            // we are calling recycler view notifuDataSetChanged
                            // method to notify that data has been changed in recycler view.
                            sportAdapter.notifyDataSetChanged();
                        } else {
                            // if the snapshot is empty we are displaying a toast message.
                            //Toast.makeText(CourseDetails.this, "No data found in Database", Toast.LENGTH_SHORT).show();
                        }
                    }
                }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                // if we do not get any data or any error we are displaying
                // a toast message that we do not get any data
                //Toast.makeText(CourseDetails.this, "Fail to get the data.", Toast.LENGTH_SHORT).show();
            }
        });

        /*
        DocumentReference Docref = db.collection("Activity").document("qJw7b05mzhxKUgNJfD7f");
        Docref.get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
            private static final String TAG = "cc";

            @Override
            public void onComplete(@NonNull Task<DocumentSnapshot> task) {
                if (task.isSuccessful()) {
                    DocumentSnapshot document = task.getResult();
                    if (document.exists()) {
                        tv =  ctx.findViewById(R.id.test_data);
                        if(document.getData().isEmpty()){
                            tv.setText("You don't have any activity");
                        }else {
                            tv.setText(document.getData().get("Titre").toString());
                        }


                    }
                    else {
                        Log.d(TAG, "No such document");
                    }
                } else {
                    Log.d(TAG, "get failed with ", task.getException());
                }
            }
        });*/
    }
}
