package com.example.mentalhealthapp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.zip.Inflater;

public class ToDoListPreviewAdapter extends RecyclerView.Adapter<ToDoListPreviewAdapter.viewHolder> {

    ArrayList<ToDoItem> toDoListEntries= new ArrayList<>();

    public ToDoListPreviewAdapter(ArrayList<ToDoItem> toDoListEntries) {
        this.toDoListEntries =toDoListEntries;
    }

    public void setToDoListEntries(ArrayList<ToDoItem> toDoListEntries) {
        this.toDoListEntries =toDoListEntries;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ToDoListPreviewAdapter.viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_view_layout,parent,false);
        ToDoListPreviewAdapter.viewHolder holder=new ToDoListPreviewAdapter.viewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ToDoListPreviewAdapter.viewHolder holder, int position) {
        //This holder is generated by Layout Manager and we have access to all fields in the inner class
        holder.title.setText(toDoListEntries.get(position).getTitle());
    }

    @Override
    public int getItemCount() {
        return toDoListEntries.size();
    }

    public class viewHolder extends RecyclerView.ViewHolder{

        private TextView title;

        public viewHolder(@NonNull View itemView) {
            super(itemView);
            title=itemView.findViewById(R.id.txtTitleToDoListItem);
        }


    }
}
