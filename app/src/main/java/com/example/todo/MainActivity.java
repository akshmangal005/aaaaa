package com.example.todo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class MainActivity extends AppCompatActivity {

    // creating variables for our array list,
    // dbhandler, adapter and recycler view.
    private ArrayList<NotesModal> notesModalArrayList;
    private DBHandler dbHandler;
    private NotesRVAdapter notesRVAdapter;
    private RecyclerView notesRV;
    FloatingActionButton newNotes;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        Intent intent()
        newNotes=findViewById(R.id.addTask);

        // initializing our all variables.
        notesModalArrayList = new ArrayList<>();
        dbHandler = new DBHandler(MainActivity.this);

        // getting our course array
        // list from db handler  class.
        notesModalArrayList = dbHandler.readNotes();

        // on below line passing our array lost to our adapter class.
        notesRVAdapter = new NotesRVAdapter(notesModalArrayList, MainActivity.this);
        notesRV=findViewById(R.id.idRVNotes);

        // setting layout manager for our recycler view.
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(MainActivity.this, RecyclerView.VERTICAL, false);
        notesRV.setLayoutManager(linearLayoutManager);

        // setting our adapter to recycler view.
        notesRV.setAdapter(notesRVAdapter);

        newNotes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),addTask.class);
                startActivity(intent);
            }
        });
    }
}