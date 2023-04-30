package com.aadim.classroom.notebook;

public interface NoteListener {
    void onClick(Note note);
    void onNoteEdit(Note note);
  void onNoteDelete(Note note);
}
