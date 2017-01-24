package com.theironyard.androidcontacts;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, AdapterView.OnItemLongClickListener, AdapterView.OnItemClickListener {
    static final String SHOW_CONTACT = "com.theironyard.androidcontacts.contact";
    //    defining variable types
    ArrayAdapter<String> contacts;
    ListView list;
    EditText name;
    EditText number;
    Button addButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//          connecting view ID's to variables
        list = (ListView) findViewById(R.id.list);
        name = (EditText) findViewById(R.id.name);
        number = (EditText) findViewById(R.id.number);
        addButton = (Button) findViewById(R.id.addButton);
//          creating the listview
        contacts = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1);
        list.setAdapter(contacts);
//          setting up listeners for user input
        addButton.setOnClickListener(this);
        list.setOnItemLongClickListener(this);
        list.setOnItemClickListener(this);
    }

    @Override
    public void onClick(View v) {
        String nam  = name.getText().toString();
        String num = number.getText().toString();
        contacts.add(nam + "  ( " + num + " )");
        name.setText("");
        number.setText("");
    }

    @Override
    public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
        String contact = contacts.getItem(position);
        contacts.remove(contact);
        return true;
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Intent intent = new Intent(this, DisplayContactActivity.class);
        String contact = contacts.getItem(position);
        intent.putExtra(SHOW_CONTACT, contact);
        startActivity(intent);
    }
}
