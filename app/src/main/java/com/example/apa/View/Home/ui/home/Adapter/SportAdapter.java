package com.example.apa.View.Home.ui.home.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.apa.Model.Activity.ActivitySport;
import com.example.apa.R;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

public class SportAdapter extends RecyclerView.Adapter<SportAdapter.ViewHolder> {

    private ArrayList<ActivitySport> SportArrayList;
    private Context context;

    public SportAdapter(ArrayList<ActivitySport> sportArrayList, Context context) {
        SportArrayList = sportArrayList;
        this.context = context;
    }

    @NonNull
    @NotNull
    @Override
    public SportAdapter.ViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(context).inflate(R.layout.fragment_activity, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull SportAdapter.ViewHolder holder, int position) {
        ActivitySport courses = SportArrayList.get(position);
        holder.titre.setText(courses.getTitre());
        holder.duration.setText(courses.getDuration());
        holder.description.setText(courses.getDescription());
    }

    @Override
    public int getItemCount() {
        return SportArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private final TextView titre;
        private final TextView duration;
        private final TextView description;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            // initializing our text views.
            titre = itemView.findViewById(R.id.TitleFragmentView);
            duration = itemView.findViewById(R.id.DureeFragmentView);
            description = itemView.findViewById(R.id.DescriptionFragmentView);
        }
    }
}
