package com.example.noteapp;
import java.util.List;
import java.util.ArrayList;
import android.os.Bundle;
import android.content.Intent;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
public class MainActivity extends AppCompatActivity {
    FloatingActionButton fabAddNote;
    RecyclerView recyclerView;
    NoteAdapter noteAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        noteAdapter = new NoteAdapter();
        recyclerView.setAdapter(noteAdapter);

        loadNotes();

        fabAddNote = findViewById(R.id.fabAdd);
        fabAddNote.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, AddNoteActivity.class);
            startActivity(intent);
        });

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }


    private void loadNotes() {
    List<Note> notes = new ArrayList<>();

    notes.add(new Note(
            "Học Android Studio",
            "Tìm hiểu về RecyclerView, Adapter và cách tạo UI đẹp cho ứng dụng",
            "04/10/2025"
    ));

    notes.add(new Note(
            "Mua sắm cuối tuần",
            "Danh sách: Rau, thịt, cá, trứng, sữa, bánh mì",
            "03/10/2025"
    ));

    notes.add(new Note(
            "Họp dự án",
            "Cuộc họp lúc 14:00 tại phòng A. Chuẩn bị báo cáo tiến độ",
            "02/10/2025"
    ));

    notes.add(new Note(
            "Ý tưởng app mới",
            "Tạo ứng dụng quản lý tài chính cá nhân với biểu đồ",
            "01/10/2025"
    ));

    notes.add(new Note(
            "Nhắc nhở",
            "Đặt lịch khám răng tuần sau và mua thuốc vitamin",
            "30/09/2025"
    ));

    noteAdapter.setNotes(notes);
}
}