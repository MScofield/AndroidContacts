package com.theironyard.androidcontacts;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ViewGroup;
import android.widget.TextView;

public class DisplayContactActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_contact);

        Intent intent = getIntent();
        String contact = intent.getStringExtra(MainActivity.SHOW_CONTACT);
        TextView textView = new TextView(this);
        textView.setTextSize(40);
        textView.setText(contact);

        ViewGroup layout = (ViewGroup) findViewById(R.id.activity_display_contact);
        layout.addView(textView);
    }
}
