package com.example.noteapp;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageButton;

public class AddNoteActivity extends AppCompatActivity {

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_add_note);
            ImageButton btnBack = findViewById(R.id.btnBack);
            btnBack.setOnClickListener(v -> finish());
        }
    }
