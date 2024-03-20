package com.example.onlineshop;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Info extends AppCompatActivity {
    private ImageButton MainButton, ProfileButton, ContactsButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);

        MainButton = (ImageButton)findViewById(R.id.main);
        ProfileButton = (ImageButton)findViewById(R.id.profile);
        ContactsButton = (ImageButton)findViewById(R.id.contacts);

        MainButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent MainIntent = new Intent(Info.this,Shop.class);
                startActivity(MainIntent);
            }
        });
        ProfileButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent ProfileIntent = new Intent(Info.this,Profile.class);
                startActivity(ProfileIntent);
            }
        });
        ContactsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent ContactsIntent = new Intent(Info.this,Contacts.class);
                startActivity(ContactsIntent);
            }
        });
    }
}