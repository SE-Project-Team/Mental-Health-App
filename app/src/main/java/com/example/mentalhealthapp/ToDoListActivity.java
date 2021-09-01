package com.example.mentalhealthapp;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class ToDoListActivity extends AppCompatActivity {
   List<String> toDoList;
   ListView listView;
   ArrayAdapter<String> arrayAdapter;
   EditText editText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_to_do_list);


        toDoList=PrefConfig.readListFromPref(this);
        if(toDoList == null)
          toDoList =new ArrayList<>();

        arrayAdapter =new ArrayAdapter<>(this, R.layout.list_view_layout,toDoList);
        listView = findViewById(R.id.id_list_view);

        listView.setAdapter(arrayAdapter);

        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int position, long id) {
                final int which_item =position;

                 new AlertDialog.Builder(ToDoListActivity.this)
                .setIcon(android.R.drawable.ic_delete)
                  .setTitle("Are you sure ?")
                         .setMessage("Do you want to delete this item")
                         .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                             @Override
                             public void onClick(DialogInterface dialogInterface, int i) {
                                 toDoList.remove(which_item);
                                 arrayAdapter.notifyDataSetChanged();
                                 PrefConfig.writeListInPref(ToDoListActivity.this,toDoList);
                             }
                         })
                         .setNegativeButton("No",null)
                         .show();

                return true;
            }
        });
        editText =findViewById(R.id.id_edit_text);
    }

    public void addItemToList(View view){
        toDoList.add(editText.getText().toString());
        arrayAdapter.notifyDataSetChanged();

        PrefConfig.writeListInPref(getApplicationContext(),toDoList);
        editText.setText("");
    }
}

