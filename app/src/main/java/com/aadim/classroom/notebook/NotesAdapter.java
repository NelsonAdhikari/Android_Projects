package com.aadim.classroom.notebook;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.aadim.classroom.R;

import java.util.ArrayList;

public class NotesAdapter extends RecyclerView.Adapter<NotesAdapter.NotesHolder>  {
    ArrayList<Note> notes;
    NoteListener noteListener;

    public NotesAdapter(ArrayList<Note> notes, NoteListener noteListener) {
        this.notes = notes;
        this.noteListener=noteListener;
    }
    public void addData(Note note){
        notes.add(note);
        notifyItemInserted(notes.size());
    }


    @NonNull
    @Override
    public NotesHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list_view,parent,false);
        return new NotesHolder((view));

    }

    @Override
    public void onBindViewHolder(@NonNull NotesHolder holder, int position) {
        holder.bindView(notes.get(position));

    }

    @Override
    public int getItemCount() {
        return notes.size();
    }



    class NotesHolder extends RecyclerView.ViewHolder{


            TextView title;
            TextView category;
            TextView description;
        public NotesHolder(@NonNull View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.display_note_title);
            category = itemView.findViewById(R.id.display_note_category);
            description = itemView.findViewById(R.id.display_note_description);
        }
        public void bindView(Note note){
            title.setText(note.getTitle());
            description.setText(note.getDes());
            category.setText(note.getCategory());

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    noteListener.onClick(note);
                }
            });


        }

    }
}
