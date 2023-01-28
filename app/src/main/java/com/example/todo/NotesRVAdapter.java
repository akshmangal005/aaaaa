package com.example.todo;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class NotesRVAdapter extends RecyclerView.Adapter<NotesRVAdapter.ViewHolder> {

    // variable for our array list and context
    private ArrayList<NotesModal> notesModalArrayList;
    private Context context;

    // constructor
    public NotesRVAdapter(ArrayList<NotesModal> courseModalArrayList, Context context) {
        this.notesModalArrayList = courseModalArrayList;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // on below line we are inflating our layout
        // file for our recycler view items.
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.notes_rv_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        // on below line we are setting data
        // to our views of recycler view item.
        NotesModal modal = notesModalArrayList.get(position);
        holder.notesTitleTV.setText(modal.getNotesTitle());
        holder.notesDescTV.setText(modal.getNotesDescription());
    }

    @Override
    public int getItemCount() {
        // returning the size of our array list
        return notesModalArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        // creating variables for our text views.
        private TextView notesTitleTV, notesDescTV;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            // initializing our text views
            notesTitleTV = itemView.findViewById(R.id.idTVNotesTitle);
            notesDescTV = itemView.findViewById(R.id.idTVNotesDescription);
        }
    }
}

