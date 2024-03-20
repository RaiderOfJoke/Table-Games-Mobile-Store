package com.example.onlineshop;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Shop extends AppCompatActivity {
    private ImageButton ProfileButton, ContactsButton, InfoButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shop);

        ProfileButton = (ImageButton)findViewById(R.id.profile);
        ContactsButton = (ImageButton)findViewById(R.id.contacts);
        InfoButton = (ImageButton)findViewById(R.id.about);

        ProfileButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent ProfileIntent = new Intent(Shop.this,Profile.class);
                startActivity(ProfileIntent);
            }
        });
        ContactsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent ContactsIntent = new Intent(Shop.this,Contacts.class);
                startActivity(ContactsIntent);
            }
        });
        InfoButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent InfoIntent = new Intent(Shop.this,Info.class);
                startActivity(InfoIntent);
            }
        });
    }
}