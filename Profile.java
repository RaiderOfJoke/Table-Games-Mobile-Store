package com.example.onlineshop;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Profile extends AppCompatActivity {
    private ImageButton MainButton, ContactsButton, InfoButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        MainButton = (ImageButton)findViewById(R.id.main);
        ContactsButton = (ImageButton)findViewById(R.id.contacts);
        InfoButton = (ImageButton)findViewById(R.id.about);

        MainButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent MainIntent = new Intent(Profile.this,Shop.class);
                startActivity(MainIntent);
            }
        });
        ContactsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent ContactsIntent = new Intent(Profile.this,Contacts.class);
                startActivity(ContactsIntent);
            }
        });
        InfoButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent InfoIntent = new Intent(Profile.this,Info.class);
                startActivity(InfoIntent);
            }
        });
    }
}