package com.example.mentalhealthapp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.zip.Inflater;

public class JournalPreviewAdapter extends RecyclerView.Adapter<JournalPreviewAdapter.viewHolder>{

    ArrayList<JournalEntry> journalEntries=new ArrayList<>();

    public JournalPreviewAdapter(ArrayList<JournalEntry> journalEntries) {
        this.journalEntries = journalEntries;
    }

    public void setJournalEntries(ArrayList<JournalEntry> journalEntries) {
        this.journalEntries = journalEntries;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.basic_item_layout_journal_main,parent,false);
        viewHolder holder=new viewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull viewHolder holder, int position) {
        //This holder is generated by Layout Manager and we have access to all fields in the inner class
        holder.title.setText(journalEntries.get(position).getTitle());
        holder.startLine.setText(journalEntries.get(position).getContent());

    }

    @Override
    public int getItemCount() {
        return journalEntries.size();
    }

    public class viewHolder extends RecyclerView.ViewHolder{

        private TextView title, startLine;

        public viewHolder(@NonNull View itemView) {
            super(itemView);
            title=itemView.findViewById(R.id.txtTitleOfDiary);
            startLine=itemView.findViewById(R.id.txtPreviewOfDiary);
        }


    }
}
