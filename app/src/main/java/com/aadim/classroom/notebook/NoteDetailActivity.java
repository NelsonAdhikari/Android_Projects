package com.aadim.classroom.notebook;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.aadim.classroom.R;

public class NoteDetailActivity extends AppCompatActivity {
   TextView title,description,category;

    TextView tvTitle,tvCategory,tvDescription;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_note_detail);
        tvTitle =findViewById(R.id.detailtitle);
        tvCategory= findViewById(R.id.detailcat);
        tvDescription = findViewById(R.id.detaildesc);


        Intent intent = getIntent();
        String title= intent.getExtras().getString("tvTitle");
        String desc=intent.getExtras().getString("tvDescription");
        String cat=intent.getExtras().getString("tvCategory");



        tvTitle.setText(title);
        tvCategory.setText(desc);
        tvDescription.setText(cat);
//                }
            }
        }


