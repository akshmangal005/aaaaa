package com.example.todo;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class addTask extends AppCompatActivity {
    // creating variables for our edittext, button and dbhandler
    private EditText notesDescriptionEdit,notesTitleEdit;
    private Button addnotesBtn;
    private DBHandler dbHandler;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_task);


        notesDescriptionEdit=findViewById(R.id.description);
        notesTitleEdit=findViewById(R.id.addttle);
        addnotesBtn=findViewById(R.id.add);
        dbHandler = new DBHandler(addTask.this);

        // below line is to add on click listener for our addTask button.
        addnotesBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // below line is to get data from all edit text fields.
                String taskDescription = notesDescriptionEdit.getText().toString();
                String noteTitle = notesTitleEdit.getText().toString();
                // validating if the text fields are empty or not.
                if (taskDescription.isEmpty()) {
                    Toast.makeText(addTask.this, "Please enter all the data..", Toast.LENGTH_SHORT).show();
                    return;
                }

                // on below line we are calling a method to add new
                // course to sqlite data and pass all our values to it.
                dbHandler.addNewTask(taskDescription,noteTitle);

                // after adding the data we are displaying a toast message.
                Toast.makeText(addTask.this, "Task has been added.", Toast.LENGTH_SHORT).show();
                notesDescriptionEdit.setText("");
                notesTitleEdit.setText("");
                finish();
            }
        });
    }
}