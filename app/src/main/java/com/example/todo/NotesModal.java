package com.example.todo;

public class NotesModal {

    // variables for our notes description
    private String notesDescription,notesTitle;
    private int id;

    // creating getter and setter methods
    public String getNotesDescription() {
        return notesDescription;
    }

    public void setNotesDescription(String notesDescription) {
        this.notesDescription = notesDescription;
    }


    public String getNotesTitle() {
        return notesTitle;
    }

    public void setNotesTitle(String notesTitle) {
        this.notesTitle = notesTitle;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    // constructor
    public NotesModal(String notesDescription, String notesTitle) {
        this.notesDescription = notesDescription;
        this.notesTitle = notesTitle;
    }

}