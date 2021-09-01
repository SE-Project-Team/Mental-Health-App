package com.example.mentalhealthapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class JournalActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    JournalDatabase db;

    private FloatingActionButton fabActJournal,fabCalendar;
    ArrayList<JournalEntry> journalEntries=new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_journal);

        db=new JournalDatabase(JournalActivity.this);

        recyclerView =findViewById(R.id.listOfNotes);
        fabActJournal=findViewById(R.id.fabActJournal);

        fabActJournal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(JournalActivity.this,Writing.class);
                startActivity(intent);
            }
        });

        fabCalendar=findViewById(R.id.fabCalendar);
        fabCalendar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent =new Intent(JournalActivity.this,CalendarActivity.class);
                startActivity(intent);
            }
        });
        journalEntries=db.getJournalEntries();
        JournalPreviewAdapter adapter=new JournalPreviewAdapter(journalEntries,JournalActivity.this);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,true));
    }

    @Override
    public void finish(){
        Intent intent=new Intent(JournalActivity.this,MainActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(intent);
    }
}