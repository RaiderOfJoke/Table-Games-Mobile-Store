package com.example.onlineshop;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Contacts extends AppCompatActivity {

    private ImageButton MainButton, ProfileButton, InfoButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contacts);

        MainButton = (ImageButton)findViewById(R.id.main);
        ProfileButton = (ImageButton)findViewById(R.id.profile);
        InfoButton = (ImageButton)findViewById(R.id.about);

        MainButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent MainIntent = new Intent(Contacts.this,Shop.class);
                startActivity(MainIntent);
            }
        });
        ProfileButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent ProfileIntent = new Intent(Contacts.this,Profile.class);
                startActivity(ProfileIntent);
            }
        });
        InfoButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent InfoIntent = new Intent(Contacts.this,Info.class);
                startActivity(InfoIntent);
            }
        });
    }
}