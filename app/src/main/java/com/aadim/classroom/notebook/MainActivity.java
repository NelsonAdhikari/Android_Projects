package com.aadim.classroom.notebook;

        import androidx.activity.result.ActivityResult;
        import androidx.activity.result.ActivityResultCallback;
        import androidx.activity.result.ActivityResultLauncher;
        import androidx.activity.result.contract.ActivityResultContracts;
        import androidx.appcompat.app.AppCompatActivity;
        import androidx.recyclerview.widget.RecyclerView;

        import android.annotation.SuppressLint;
        import android.content.Intent;
        import android.os.Bundle;
        import android.view.View;
        import android.widget.LinearLayout;
        import android.widget.Toast;

        import com.aadim.classroom.R;
        import com.google.android.material.floatingactionbutton.FloatingActionButton;

        import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    FloatingActionButton btnAddNote;
    ArrayList<Note> notes;
    NotesAdapter adapter;

    NotebookDbHelper dbHelper;
    LinearLayout li_no_notes;

    ActivityResultLauncher<Intent> resultIntent = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback<ActivityResult>() {
        @Override
        public void onActivityResult(ActivityResult result) {
            if (result.getResultCode() == RESULT_OK)
            {
                Intent intent = result.getData();
                String title = intent.getExtras().getString("note_title");
                String description = intent.getExtras().getString("note_description");
                String category = intent.getExtras().getString("note_category");
                Toast.makeText(MainActivity.this, "Title :" + title + " Description :" + description  , Toast.LENGTH_SHORT).show();

                Note note = new Note(title,description,category);
                adapter.addData(note);

                dbHelper.addNote(note);
                if(li_no_notes.getVisibility()==View.VISIBLE){
                    li_no_notes.setVisibility(View.GONE);
                }

            }
        }
    });


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dbHelper= new NotebookDbHelper(getApplicationContext());

        li_no_notes=findViewById(R.id.li_no_notes);


        notes = new ArrayList<>();
        notes.addAll(dbHelper.getAllNotes());
        if(notes.size()<1){
            li_no_notes.setVisibility(View.VISIBLE);
        }else {
            li_no_notes.setVisibility(View.GONE);
        }


        btnAddNote = findViewById(R.id.btnAddNote);
        RecyclerView rv = findViewById(R.id.recycleview_notes);
        adapter = new NotesAdapter(notes, new NoteListener(){
            @Override
            public void onClick(Note note) {
                Intent intent=new Intent(MainActivity.this,NoteDetailActivity.class);
                intent.putExtra("tvTitle",note.getTitle());
                intent.putExtra("tvDescription",note.getDes());
                intent.putExtra("tvCategory",note.getCategory());
                startActivity(intent);
            }

            @Override
            public void onNoteEdit(Note note) {

            }

            @Override
            public void onNoteDelete(Note note) {
//                new AlertDialog.Builder(note)
//                        .setTitle("Delete entry")
//                        .setMessage("Are you sure you want to delete this entry?")
            }
        });
        rv.setAdapter(adapter);

        btnAddNote.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,AddNotesActivity.class);
                resultIntent.launch(intent);
            }
        });

    }
}
